package ns.hasA.oto;

import model.hasA.oto.Vote;
import model.hasA.oto.Voter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OTOmainClass {

    public static void main(String[] args) {

        Voter voter1 = new Voter();
        voter1.setVoterName("Sunita");
        voter1.setAge(24);

        Vote vote1 = new Vote();
        vote1.setPartyName("Love");
        vote1.setVoter(voter1);

        /*This will throw an Error
         * Exception in thread "main" org.hibernate.NonUniqueObjectException: A different object with the same
         * identifier value was already associated with the session : [model.hasA.oto.Vote#3]
         */
        Vote vote2 = new Vote();
        vote2.setPartyName("Love");
        vote2.setVoter(voter1);



        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(voter1);
        session.save(vote1);

        //Throw Exception
        session.save(vote2);

        transaction.commit();
        session.close();


    }
}
