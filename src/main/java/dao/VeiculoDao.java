
package dao;

import java.util.List;
import model.Pessoa;
import model.Veiculo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class VeiculoDao {
    
    public void save(Veiculo veiculo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(veiculo);
        t.commit();
    }

    public Veiculo getVeiculo(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Veiculo) session.load(Veiculo.class, id);
    }

    public List<Veiculo> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from TAB_VEICULO").list();
        t.commit();
        return lista;
    }

    public void remove(Veiculo veiculo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(veiculo);
        t.commit();
    }

    public void update(Veiculo veiculo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(veiculo);
        t.commit();
    }
    
}
