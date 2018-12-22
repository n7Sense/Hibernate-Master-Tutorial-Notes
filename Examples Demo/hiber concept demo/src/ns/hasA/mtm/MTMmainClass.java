package ns.hasA.mtm;

import model.hasA.mtm.Actor;
import model.hasA.mtm.Movies;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class MTMmainClass {

    public static void main(String[] args) {

        Movies dangale = new Movies();
        dangale.setMovieId(1);
        dangale.setMovieName("Dangale");

        Movies sultan = new Movies();
        sultan.setMovieId(2);
        sultan.setMovieName("Sultan");

        Movies pk = new Movies();
        pk.setMovieId(3);
        pk.setMovieName("PK");

        Movies dabang = new Movies("Dabang");
        dabang.setMovieId(4);
        dabang.setMovieName("Dabang");

        Set<Movies> moviesSet1 = new HashSet<Movies>();
        moviesSet1.add(dangale);
        moviesSet1.add(pk);

        Set<Movies> moviesSet2 = new HashSet<Movies>();
        moviesSet2.add(sultan);
        moviesSet2.add(dabang);

        Actor amirKhan = new Actor();
        amirKhan.setActorId(1);
        amirKhan.setActorName("Amir Khan");
        amirKhan.setMoviesSet(moviesSet1);

        Actor salmanKhan = new Actor();
        salmanKhan.setActorId(2);
        salmanKhan.setActorName("Salman Khan");
        salmanKhan.setMoviesSet(moviesSet2);

        Actor anuska = new Actor();
        anuska.setActorId(3);
        anuska.setActorName("Anushka Sharma");
        anuska.setMoviesSet(moviesSet2);

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(amirKhan);
        session.saveOrUpdate(salmanKhan);
        session.saveOrUpdate(anuska);
        session.saveOrUpdate(sultan);
        session.saveOrUpdate(dangale);
        session.saveOrUpdate(pk);
        session.saveOrUpdate(dabang);

        transaction.commit();
        session.close();


    }
}

    /*    Actor amir_khan = new Actor("Amir Khan");
        Actor akchay_kumar = new Actor("Akchay Kumar");
        Actor salman_khan = new Actor("Salman Khan");
        Actor saifAli_khan = new Actor("SaifAli Khan");
        Actor john_ebrahim = new Actor("John Ebrahim");
        Actor ritesh_desmukh = new Actor("Ritesh Desmukh");
        Actor vivek_oberoye = new Actor("Vivek Oberoye");

        Movies dangale = new Movies("Dangale");
        Movies tepk = new Movies("Toilate ek prem katha");
        Movies hssh = new Movies("Hum Saath Saath Hain");
        Movies grandMasti = new Movies("Grand Masti");
        Movies race2 = new Movies("Race2");
        Movies khatta_meetha = new Movies("Khatta Meetha");
        Movies pk = new Movies("PK");
        Movies dabang = new Movies("Dabang");

        Set<Movies> moviesSet1 = new HashSet<Movies>();
        moviesSet1.add(dangale);
        moviesSet1.add(pk);
        Set<Movies> moviesSet2 = new HashSet<Movies>();
        moviesSet2.add(tepk);
        moviesSet2.add(khatta_meetha);

        Set<Movies> moviesSet3 = new HashSet<Movies>();
        moviesSet3.add(hssh);

        Set<Movies> moviesSet4 = new HashSet<Movies>();
        moviesSet4.add(grandMasti);

        Set<Movies> moviesSet5 = new HashSet<Movies>();
        moviesSet5.add(race2);

        Set<Movies> moviesSet6 = new HashSet<Movies>();
        moviesSet2.add(dabang);

        amir_khan.setMoviesSet(moviesSet1);
        akchay_kumar.setMoviesSet(moviesSet2);
        salman_khan.setMoviesSet(moviesSet3);
        ritesh_desmukh.setMoviesSet(moviesSet4);
        vivek_oberoye.setMoviesSet(moviesSet4);









        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session  session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(amir_khan);
        session.saveOrUpdate(akchay_kumar);
        session.saveOrUpdate(saifAli_khan);
        session.saveOrUpdate(salman_khan);
        session.saveOrUpdate(ritesh_desmukh);
        session.saveOrUpdate(vivek_oberoye);
        session.saveOrUpdate(john_ebrahim);

        session.saveOrUpdate(dangale);
        session.saveOrUpdate(dabang);
        session.saveOrUpdate(hssh);
        session.saveOrUpdate(race2);
        session.saveOrUpdate(grandMasti);
        session.saveOrUpdate(pk);
        session.saveOrUpdate(tepk);
        session.saveOrUpdate(khatta_meetha);

        transaction.commit();
        session.close();
*/