package dao;

import model.Pessoa;
import util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PessoaDao {

    public void save(Pessoa pessoa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(pessoa);
        t.commit();
        session.close();
    }

    public Pessoa getPessoa(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Pessoa pessoa = (Pessoa) session.load(Pessoa.class, id);
        session.close();
        return pessoa;
    }

    public List<Pessoa> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from tab_pessoa").list();
        t.commit();
        session.close();
        return lista;
    }

    public void remove(Pessoa pessoa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(pessoa);
        t.commit();
        session.close();
    }

    public void update(Pessoa pessoa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(pessoa);
        t.commit();
        session.close();
    }

}
