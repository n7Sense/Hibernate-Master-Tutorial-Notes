package ns.hasA.otm;


import model.hasA.otm.Author;
import model.hasA.otm.Books;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class OTMMainClass {

    public static void main(String[] args) {

    // For Inserting Record
    /*    Author author = new Author();
        author.setAuthorName("Gavin king");

        Books book1 = new Books("EJB Container");
        Books book2 = new Books("Hibernate");
        //Books book3 = new Books("Krishna Puran");

        Set<Books> booksSet = new HashSet<Books>();
        booksSet.add(book1);
        booksSet.add(book2);
        //booksSet.add(book3);

        author.setBooks(booksSet);
        */

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session  session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        //For Retriving Record.
        Object o = session.load(Author.class, new Integer(1));
        Author au = (Author)o;
        System.out.println("******************* The Parent Record ********************");
        System.out.println(au.getAuthorId()+" : "+au.getAuthorName());
        System.out.println("******************* The Parent Related Child Record *****************");
        Set<Books> bookSet = au.getBooks();
        for(Books book: bookSet){
            System.out.println(book.getBookId()+" : "+book.getBookName());
        }
        //If You DO Cascade Type All Then no need to save Child Entity
        //session.save(author);

        transaction.commit();
        session.close();
        sf.close();
    }
}