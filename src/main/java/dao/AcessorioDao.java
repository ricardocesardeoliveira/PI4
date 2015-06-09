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
        session.close();
    }

    public Acessorio getAcessorio(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Acessorio acessorio = (Acessorio) session.load(Acessorio.class, id);
        session.close();
        return acessorio;
    }

    public List<Acessorio> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from tab_acessorio").list();
        t.commit();
        session.close();
        return lista;
    }

    public void remove(Acessorio acessorio) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(acessorio);
        t.commit();
        session.close();
    }

    public void update(Acessorio acessorio) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(acessorio);
        t.commit();
        session.close();
    }

}
