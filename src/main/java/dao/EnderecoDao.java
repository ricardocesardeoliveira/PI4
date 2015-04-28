package dao;

import java.util.List;
import model.Endereco;
import model.Pessoa;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EnderecoDao {

    public void save(Endereco endereco) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(endereco);
        t.commit();
    }
    
    public Endereco getEndereco(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Endereco) session.load(Endereco.class, id);
    }

    public List<Endereco> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from tab_endereco").list();
        t.commit();
        return lista;
    }

    public void remove(Endereco endereco) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(endereco);
        t.commit();
    }

    public void update(Endereco endereco) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(endereco);
        t.commit();
    }
    
}
