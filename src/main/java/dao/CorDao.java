
package dao;

import java.util.List;
import model.Cor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CorDao {
    
    public void save(Cor cor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(cor);
        t.commit();
        session.close();
    }
    
    public List<Cor> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from tab_cor").list();
        t.commit();
        session.close();
        return lista;
    }
    
    public void remove(Cor cor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(cor);
        t.commit();
        session.close();
    }
    
    public void update(Cor cor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(cor);
        t.commit();
        session.close();
    }
    
}
