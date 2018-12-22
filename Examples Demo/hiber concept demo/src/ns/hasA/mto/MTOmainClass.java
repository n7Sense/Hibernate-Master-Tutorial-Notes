package ns.hasA.mto;

import model.hasA.mto.Course;
import model.hasA.mto.Faculty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MTOmainClass {

    public static void main(String[] args) {
        Faculty faculty1 = new Faculty(0, "Durga Sir");
        Faculty faculty2 = new Faculty(0, "Madhusudan");
        Faculty faculty3 = new Faculty(0, "Keshav");

        Course course1 = new Course(0, "Java", faculty1);
        Course course2 = new Course(0, "Bhagvat Geet", faculty2);
        Course course3 = new Course(0, "JDBC", faculty1);
        Course course4 = new Course(0, "Ramayan", faculty3);

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(course1);
        session.save(course2);
        session.save(course3);
        session.save(course4);
        session.save(faculty1);
        session.save(faculty2);
        session.save(faculty3);
        transaction.commit();
        session.close();
    }
}
