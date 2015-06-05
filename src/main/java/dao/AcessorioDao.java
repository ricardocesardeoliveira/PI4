package dao;

import util.HibernateUtil;
import java.util.List;
import model.Acessorio;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AcessorioDao {

    public void save(Acessorio acessorio) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(acessorio);
        t.commit();
    }

    public Acessorio getAcessorio(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Acessorio) session.load(Acessorio.class, id);
    }

    public List<Acessorio> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from tab_acessorio").list();
        t.commit();
        return lista;
    }

    public void remove(Acessorio acessorio) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(acessorio);
        t.commit();
    }

    public void update(Acessorio acessorio) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(acessorio);
        t.commit();
    }

}
