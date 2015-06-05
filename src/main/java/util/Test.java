package util;

import model.Pessoa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Test {

    static Pessoa pessoa;

    public static void main(String[] args) {

        AnnotationConfiguration configuration = new AnnotationConfiguration();
        configuration.configure();

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        pessoa = new Pessoa();
        pessoa.setNome("Enoque");
        pessoa.setCpf("397.334.938-05");
        pessoa.setRg("0000");
        pessoa.setSexo("Masculino");

        Transaction tx = session.beginTransaction();
        session.save(pessoa);
        tx.commit();
    }
    
}
