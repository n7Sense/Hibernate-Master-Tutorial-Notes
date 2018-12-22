package ns.hcql;

import model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;

import java.util.Iterator;
import java.util.List;

public class CriteriaMainClass {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Employee.class);
        Criterion criterion1 = Restrictions.and(Restrictions.between("salary", new Double(1000), new Double(10000)),Restrictions.like("firstName", "S%"), Restrictions.isNotNull("managerId"));
        Criterion criterion2 = Restrictions.and(Restrictions.between("salary", new Double(1000), new Double(10000)), Restrictions.like("firstName", "%S%"), Restrictions.isNotNull("commission"));
        Criterion criterion3 = Restrictions.between("salary", new Double(1000), new Double(10000));
        Order order = Order.asc("employeeId");
        criteria.add(criterion1);
        criteria.addOrder(order);
        criteria.setFirstResult(1);
        criteria.setMaxResults(5);


        //when we retrive whole record then we can use List<Entity> but when we use Projections i.e selected Column then must
        // shuld go of List<Object> class only.
        List<Employee> emp = criteria.list();
        System.out.println("*********************** Retriving Whole Employee Records **************************");
        for(Employee e: emp){
            System.out.println(e.toString());
        }

        //Getting PARTIAL record with only single Column
        Projection projection = Projections.property("firstName");

        //Getting PARTIAL record with only Multiple Column
        ProjectionList projectionList  = Projections.projectionList();
        projectionList.add(Projections.property("employeeId"));
        projectionList.add(Projections.property("firstName"));
        projectionList.add(Projections.property("lastName"));
        projectionList.add(Projections.property("salary"));

        criteria.setProjection(projectionList);

        List<Object> objects = criteria.list();
        Iterator itr = objects.iterator();
        System.out.println("*********************** Retriving Partial Employee Records **************************");
        while(itr.hasNext()) {
            Object[] row = (Object[]) itr.next();
            System.out.println(row[0]+" : "+row[1]+" : "+row[2]+" : "+row[3]);
        }


        // Aggregation On Employee Records
        ProjectionList projectionList2  = Projections.projectionList();
        projectionList.add(Projections.rowCount());
        projectionList.add(Projections.sum("salary"));
        projectionList.add(Projections.avg("salary"));

        transaction.commit();
        session.close();
        sf.close();
    }
}
