package ns;


import model.NamedQueryModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import java.util.Iterator;
import java.util.List;

public class NamedNativeMainClass {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery nativeQuery1 = session.getNamedNativeQuery("findAllNamedData");
        List<Object> list1  = nativeQuery1.list();
        Iterator itr = list1.iterator();
        System.out.println("************ Named Record By Native Query *******************");
        while(itr.hasNext()){
            Object[] row = (Object[])itr.next();
            System.out.println(row[0]+" : "+row[1]+" : "+row[2]);
        }

        //Also to convert to pojo class object
        //this type of Queries is called Entity Queries
        NativeQuery nativeQuery2 = session.getNamedNativeQuery("findAllNamedData").addEntity(NamedQueryModel.class);
        List<NamedQueryModel> list2  = nativeQuery2.list();
        System.out.println("************ Named Record By Native Entity Queries *******************");
        for(NamedQueryModel nql: list2){
            System.out.println(nql.toString());
        }


        //this type of Queries is called Scalar Queries to improve the performence
        NativeQuery nativeQuery3 = session.createNativeQuery("SELECT named_id, name, rashi FROM named WHERE named_id = :nid").addScalar("named_Id", StandardBasicTypes.INTEGER).addScalar("name", StandardBasicTypes.STRING).addScalar("rashi", StandardBasicTypes.STRING);
        /*
        NativeQuery nativeQuery4 = session.createNativeQuery("SELECT named_id, name, rashi FROM named").addScalar("named_Id", StandardBasicTypes.INTEGER).addScalar("name", StandardBasicTypes.STRING).addScalar("rashi", StandardBasicTypes.STRING);
        NativeQuery nativeQuery5 = session.getNamedNativeQuery("findAllNamedData").addScalar("named_Id", StandardBasicTypes.INTEGER).addScalar("name", StandardBasicTypes.STRING).addScalar("rashi", StandardBasicTypes.STRING);
        NativeQuery nativeQuery6 = session.getNamedNativeQuery("findById").addScalar("named_Id", StandardBasicTypes.INTEGER).addScalar("name", StandardBasicTypes.STRING).addScalar("rashi", StandardBasicTypes.STRING);
        */

        nativeQuery3.setParameter("nid", new Integer(3));

        List<Object> list3  = nativeQuery3.list();
        System.out.println("************ Named Record By Scalar Query *******************");
        for(Object nql: list3){
            Object[] row3 = (Object[])nql;
            System.out.println(row3[0]+" : "+row3[1]+" : "+row3[2]);
        }

        transaction.commit();
        session.close();
        sf.close();
    }
}