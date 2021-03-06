package ns;

import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class nSense {

    public static void main(String[] args) {




        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session  session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        String hql1 = "SELECT e from Employee e where e.salary>5000";
        String hql2 = "Insert into Emp` ";

        Query q  = session.createQuery("SELECT e from Employee e");

        List<Employee> employeeList = (List<Employee>) q.list();
        q.executeUpdate();
        System.out.println("***************************************\n"+employeeList.size());
        for(Employee emp: employeeList){
            System.out.println(emp.toString());
        }
        transaction.commit();
        session.close();
        sf.close();
    }
}