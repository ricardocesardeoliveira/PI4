
package dao;

import java.util.List;
import model.PrePedido;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class PrePedidoDao {
    
        public void save(PrePedido prePedido) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(prePedido);
        t.commit();
    }

    public PrePedido getPrePedido(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (PrePedido) session.load(PrePedido.class, id);
    }

    public List<PrePedido> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from TAB_PRE_PEDIDO").list();
        t.commit();
        return lista;
    }

    public void remove(PrePedido prePedido) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(prePedido);
        t.commit();
    }

    public void update(PrePedido prePedido) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(prePedido);
        t.commit();
    }

}
