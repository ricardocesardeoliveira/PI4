
package dao;

import java.util.List;
import model.Veiculo;
import model.VeiculoAcessorio;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class VeiculoAcessorioDao {
    
    public void save(VeiculoAcessorio veiculo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(veiculo);
        t.commit();
        session.close();
    }

    public Veiculo getVeiculoAcessorio(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Veiculo veiculo = (Veiculo) session.load(Veiculo.class, id);
        session.close();
        return veiculo; 
    }

    public List<Veiculo> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from TAB_VEICULO_ACESSORIO").list();
        t.commit();
        session.close();
        return lista;
    }

    public void remove(VeiculoAcessorio veiculo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(veiculo);
        t.commit();
        session.close();
    }

    public void update(VeiculoAcessorio veiculo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(veiculo);
        t.commit();
        session.close();
    }
    
}
