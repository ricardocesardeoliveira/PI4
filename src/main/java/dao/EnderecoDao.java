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
        session.close();
    }
    
    public Endereco getEndereco(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Endereco endereco = (Endereco) session.load(Endereco.class, id);
        session.close();
        return endereco;
    }

    public List<Endereco> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from tab_endereco").list();
        t.commit();
        session.close();
        return lista;
    }

    public void remove(Endereco endereco) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(endereco);
        t.commit();
        session.close();
    }

    public void update(Endereco endereco) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(endereco);
        t.commit();
        session.close();
    }
    
}
