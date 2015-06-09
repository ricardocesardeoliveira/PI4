package dao;

import java.util.List;
import model.Marca;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MarcaDao {

    public void save(Marca marca) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(marca);
        t.commit();
        session.close();
    }
    
    public List<Marca> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from tab_marca").list();
        t.commit();
        session.close();
        return lista;
    }
    
    public void remove(Marca marca) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(marca);
        t.commit();
        session.close();
    }
    
    public void update(Marca marca) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(marca);
        t.commit();
        session.close();
    }
    
}
