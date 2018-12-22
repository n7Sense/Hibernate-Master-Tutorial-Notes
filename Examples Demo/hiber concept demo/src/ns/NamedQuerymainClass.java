package ns;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class NamedQuerymainClass {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.getNamedQuery("findRashiById");
        query.setParameter("nid", new Integer(3));
        List<Object> list  = query.list();
        Iterator itr = list.iterator();
        while(itr.hasNext()){
            Object[] row = (Object[])itr.next();
            System.out.println(row[0]+" : "+row[1]+" : "+row[2]);
        }


        transaction.commit();
        session.close();
        sf.close();
    }
}
