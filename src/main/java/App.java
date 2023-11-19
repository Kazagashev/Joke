import crud.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<Person> users = session.createQuery("from Person").getResultList();
        for (Person person : users) {
            System.out.println(person);
        }
        session.getTransaction().commit();
        sessionFactory.close();


    }
}
