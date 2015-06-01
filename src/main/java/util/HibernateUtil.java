package util;

import model.Acessorio;
import model.Concessionaria;
import model.Cor;
import model.Endereco;
import model.Kit;
import model.Marca;
import model.Pessoa;
import model.PrePedido;
import model.Veiculo;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                AnnotationConfiguration ac = new AnnotationConfiguration();
                ac.addAnnotatedClass(Pessoa.class);
                ac.addAnnotatedClass(Marca.class);
                ac.addAnnotatedClass(Concessionaria.class);
                ac.addAnnotatedClass(Endereco.class);
                ac.addAnnotatedClass(Veiculo.class);
                ac.addAnnotatedClass(Cor.class);
                ac.addAnnotatedClass(Acessorio.class);
                ac.addAnnotatedClass(PrePedido.class);
                ac.addAnnotatedClass(Kit.class);
                sessionFactory = ac.configure().buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
            return sessionFactory;
        } else {
            return sessionFactory;
        }
    }

}
