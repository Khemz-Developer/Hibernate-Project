import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Computer.class)
                .addAnnotatedClass(CustomerOrder.class)
                .addAnnotatedClass(Product.class)
                .getMetadataBuilder()
                .build();
        return (SessionFactory) metadata.getSessionFactoryBuilder().build();
    }
    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
