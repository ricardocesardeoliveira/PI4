package dao;

import java.util.List;
import model.PrePedido;
import model.Relatorio;
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
    
    
    
}
