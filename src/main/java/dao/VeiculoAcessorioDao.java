
package dao;

import java.util.List;
import model.Veiculo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class VeiculoAcessorioDao {
    
    public void save(Veiculo veiculo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(veiculo);
        t.commit();
        session.close();
    }

    public Veiculo getVeiculo(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Veiculo veiculo = (Veiculo) session.load(Veiculo.class, id);
        session.close();
        return veiculo; 
    }

    public List<Veiculo> listVeiculosFiat() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from TAB_VEICULO where id_marca = 1").list();
        t.commit();
        session.close();
        return lista;
    }
    
    public List<Veiculo> listVeiculosFiatFilter(String nome) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("from TAB_VEICULO where nome = :nome");
        query.setParameter("nome", nome);
        List lista = query.list();
        t.commit();
        session.close();
        return lista;
    }
    
    public List<Veiculo> listVeiculosVW() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from TAB_VEICULO where id_marca = 2").list();
        t.commit();
        session.close();
        return lista;
    }
    
    public List<Veiculo> listVeiculosBMW() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from TAB_VEICULO where id_marca = 3").list();
        t.commit();
        session.close();
        return lista;
    }
    
    public List<Veiculo> listVeiculosNissan() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from TAB_VEICULO where id_marca = 4").list();
        t.commit();
        session.close();
        return lista;
    }
    
    public List<Veiculo> listVeiculosToyota() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from TAB_VEICULO where id_marca = 5").list();
        t.commit();
        session.close();
        return lista;
    }
    
    public List<Veiculo> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from TAB_VEICULO").list();
        t.commit();
        session.close();
        return lista;
    }

    public void remove(Veiculo veiculo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(veiculo);
        t.commit();
        session.close();
    }

    public void update(Veiculo veiculo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(veiculo);
        t.commit();
        session.close();
    }
    
}
