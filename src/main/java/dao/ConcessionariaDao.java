package dao;

import util.HibernateUtil;
import java.util.List;
import model.Concessionaria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConcessionariaDao {

    public void save(Concessionaria concessionaria) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(concessionaria);
        t.commit();
    }

    public Concessionaria getConcessionaria(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Concessionaria) session.load(Concessionaria.class, id);
    }

    public List<Concessionaria> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from tab_concessionaria").list();
        t.commit();
        return lista;
    }

    public void remove(Concessionaria concessionaria) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(concessionaria);
        t.commit();
    }

    public void update(Concessionaria concessionaria) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(concessionaria);
        t.commit();
    }

}
