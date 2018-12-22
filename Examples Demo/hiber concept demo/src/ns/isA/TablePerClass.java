package ns.isA;

import model.isA.tpc.AdminUser;
import model.isA.tpc.ProjectManager;
import model.isA.tpc.SuperUser;
import model.isA.tpc.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TablePerClass {

    public static void main(String[] args) {
        AdminUser au = new AdminUser("Rahul", "rahul@gmail.com", "Builder");
        ProjectManager pm = new ProjectManager("PM Kumar", "kumar@pm.cm", "Creating Project");
        SuperUser su = new SuperUser("SU Sunita", "sunita@su.com", "Creating User");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, 1);
        System.out.println("***************************\n"+user.toString());
        //session.update(v);
        session.save(au);
        session.save(pm);
        session.save(su);
        transaction.commit();
        session.close();
        sf.close();
    }
}
