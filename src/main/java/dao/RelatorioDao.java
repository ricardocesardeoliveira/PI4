package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.PrePedido;
import model.Relatorio;
import model.RelatorioFaixaIdade;
import model.Veiculo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class RelatorioDao {
    
    public List<PrePedido> listarPorFaixaDeIdade() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from tab_pre_pedido").list();
        t.commit();
        return lista;
    }
    
    
    public List<Relatorio> listarVeiculosMaisVendidos() {
        Connection conn = null;
        Statement stmt = null;
        String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";  
        String DB_URL = "jdbc:derby://localhost:1527/multimarcas";
        List<Relatorio> veiculosMaisVendidos = new ArrayList<>();

   //  Database credentials
        String USER = "rjs";
        String PASS = "123";
        try{
           //STEP 2: Register JDBC driver
           Class.forName(JDBC_DRIVER);

           //STEP 3: Open a connection
           System.out.println("Connecting to a selected database...");
           conn = DriverManager.getConnection(DB_URL, USER, PASS);
           System.out.println("Connected database successfully...");

           //STEP 4: Execute a query
           System.out.println("Creating statement...");
           stmt = conn.createStatement();

           String sql = "SELECT Max(V.NOME), Count(PP.ID_VEICULO) FROM TAB_PRE_PEDIDO PP INNER JOIN TAB_VEICULO V ON V.ID_VEICULO = PP.ID_VEICULO GROUP BY V.NOME ORDER BY Count(*) DESC , V.NOME";
           
            //STEP 5: Extract data from result set
            try (ResultSet rs = stmt.executeQuery(sql)) {
                //STEP 5: Extract data from result set
                while(rs.next()){
                    //Retrieve by column name
                    System.out.println(rs.getString(1));
                    System.out.println(rs.getString(2));
                    String veiculo  = rs.getString(1);
                    int qtdeVendida = rs.getInt(2);
                    
                    //Display values  
                    System.out.println("veiculo: " + veiculo);
                    System.out.println("qtdeVendida: " + qtdeVendida);
//                    Relatorio relatorio = new Relatorio(rs.getString(1), rs.getString(2));
//                    veiculosMaisVendidos.add(relatorio);
                    
                }}
        }catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                 conn.close();
           }catch(SQLException se){
           }// do nothing
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }//end finally try
        }//end try
        System.out.println("Goodbye!");
        
        return veiculosMaisVendidos;
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
        return listaRetorno;
    }
    
    
}
