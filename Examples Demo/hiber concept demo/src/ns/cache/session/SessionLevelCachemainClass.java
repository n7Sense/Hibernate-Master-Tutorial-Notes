package ns.cache.session;

import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class SessionLevelCachemainClass {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session1 = sf.openSession();
        //Transaction transaction = session.beginTransaction();
        Query query = session1.createQuery("SELECT e.employeeId, e.firstName, e.lastName from Employee e");
        List<Employee> employeeList = query.list();
        Employee emp1 = session1.get(Employee.class, 153);
        Employee emp2 = session1.get(Employee.class, 155);
        System.out.println("Employe Id 153\n"+emp1.toString());
        System.out.println("Employe Id 155\n"+emp2.toString());
        session1.close();
        Session session2 = sf.openSession();
        Employee emp = (Employee)session2.get(Employee.class, 155);
        System.out.println("Session 2 Employe Id 155\n"+emp2.toString());
        sf.close();
    }
}
