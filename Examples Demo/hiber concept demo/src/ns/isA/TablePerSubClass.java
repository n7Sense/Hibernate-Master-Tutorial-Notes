package ns.isA;

import model.isA.tpsc.InventoryManager;
import model.isA.tpsc.ProductManager;
import model.isA.tpsc.Programmer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TablePerSubClass {
    public static void main(String[] args) {

        InventoryManager im =  new InventoryManager("Sunil invt Mgr", "sunit@invt.com", "INVENTORY  MGR", "Thane");
        ProductManager productManager = new ProductManager("Keshav Prod Mgr", "keshav@prod.com", "PRODUCT MGR", "Maharashtra");
        Programmer prog = new Programmer("Madhusudan Prog", "madhusudan@prog.com", "PROGRAMMER", "Java");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(im);
        session.save(productManager);
        session.save(prog);
        transaction.commit();
        session.close();
        sf.close();
    }
}
