package dao;

import java.util.ArrayList;
import java.util.List;
import model.PrePedido;
import model.Relatorio;
import model.RelatorioFaixaIdade;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class RelatorioDao {
    
    public List<PrePedido> listarPorFaixaDeIdade() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from tab_pre_pedido").list();
        t.commit();
        session.close();
        return lista;
    }
   
    public List<Relatorio> veiculosMaisVendidos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String query = "SELECT NEW model.Relatorio(MAX(V.nome), COUNT(PP.veiculo)) " +
                        "FROM model.PrePedido PP " +
                        "INNER JOIN PP.veiculo V " +
                        "GROUP BY V.nome " +
                        "ORDER BY Count(*) DESC , V.nome";
        List<Relatorio> lista = session.createQuery(query).list();
        t.commit();
        session.close();
        return lista;
    }
    
    public List<RelatorioFaixaIdade> veiculosMaisVendidosFaixaIdade() {
        List<RelatorioFaixaIdade> listaTemp = new ArrayList<>();
        List<RelatorioFaixaIdade> listaRetorno = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String[] idades = {"18 AND 28", "29 AND 39", "40 AND 50", "51 AND 200"};
        String[] idadesTexto = {"De 18 à 28 anos", "De 29 à 39 anos", "De 40 à 50 anos", "Maiores que 51 anos"};
        int indexIdadesTexto = 0;
        
        for (String idade : idades) {
            String query = "SELECT NEW model.RelatorioFaixaIdade(V.nome, M.nome, Count(*)) " +
                           "FROM model.PrePedido PP " +
                           "INNER JOIN PP.veiculo V " +
                           "INNER JOIN PP.pessoa P " +
                           "INNER JOIN V.marca M " +
                           "WHERE P.idade BETWEEN " + idade + 
                           " GROUP BY V.nome, M.nome " +
                           "ORDER BY Count(*) DESC , V.nome";
            listaTemp = session.createQuery(query).setMaxResults(1).list();
            if (!listaTemp.isEmpty()) {
                listaTemp.get(0).setFaixaIdade(idadesTexto[indexIdadesTexto]);
                listaRetorno.add(listaTemp.get(0));
                indexIdadesTexto ++;
            }
            
        }
        t.commit();
        session.close();
        return listaRetorno;
    }
    
    public List<RelatorioFaixaIdade> veiculosMaisVendidosPorSexo() {
        List<RelatorioFaixaIdade> listaTemp = new ArrayList<>();
        List<RelatorioFaixaIdade> listaRetorno = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String[] sexos = {"Masculino", "Feminino"};
        
        for (String sexo : sexos) {
            String query = "SELECT NEW model.RelatorioFaixaIdade(V.nome, M.nome, Count(*)) " +
                           "FROM model.PrePedido PP " +
                           "INNER JOIN PP.veiculo V " +
                           "INNER JOIN PP.pessoa P " +
                           "INNER JOIN V.marca M " +
                           "WHERE P.sexo LIKE '" + sexo + 
                           "' GROUP BY V.nome, M.nome " +
                           "ORDER BY Count(*) DESC , V.nome";
            listaTemp = session.createQuery(query).setMaxResults(1).list();
            if (!listaTemp.isEmpty()) {
                listaTemp.get(0).setFaixaIdade(sexo);
                listaRetorno.add(listaTemp.get(0));
            }
            
        }
        t.commit();
        session.close();
        return listaRetorno;
    }
    
    public List<RelatorioFaixaIdade> veiculosMaisVendidosRegiao() {
        List<RelatorioFaixaIdade> listaTemp = new ArrayList<>();
        List<RelatorioFaixaIdade> listaRetorno = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String[] regioesTexto = {"Norte", "Nordeste", "Centro-Oeste", "Sudeste", "Sul"};
        int indexIdadesTexto = 0;
        
        for (String regiao : regioesTexto) {
            String query = "SELECT NEW model.RelatorioFaixaIdade(V.nome, M.nome, Count(*)) " +
                           "FROM model.PrePedido PP " +
                           "INNER JOIN PP.veiculo V " +
                           "INNER JOIN V.marca M " +
                           "INNER JOIN PP.pessoa P " +
                           "INNER JOIN P.endereco E " +
                           "WHERE E.regiao LIKE '" + regiao + 
                           "' GROUP BY V.nome, M.nome " +
                           "ORDER BY Count(*) DESC , V.nome";
            listaTemp = session.createQuery(query).setMaxResults(1).list();
            if (!listaTemp.isEmpty()) {
                listaTemp.get(0).setFaixaIdade(regioesTexto[indexIdadesTexto]);
                listaRetorno.add(listaTemp.get(0));
                indexIdadesTexto ++;
            }
            
        }
        t.commit();
        session.close();
        return listaRetorno;
    }
    
}
