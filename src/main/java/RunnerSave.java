
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class RunnerSave {

    public static void main(String[] args) {

        // Create Student objects
        Student student01 = new Student();
        //  student01.setId(1);
        student01.setFirstName("Arda");
        student01.setLastName("Guler");

        Student student02 = new Student();
        //   student02.setId(2);
        student02.setFirstName("Ferdi");
        student02.setLastName("Kadioglu");

        Student student03 = new Student();
        //  student03.setId(3);
        student03.setFirstName("Altay");
        student03.setLastName("Bayindir");

        // Create LibraryCard objects
        LibraryCard libraryCard01 = new LibraryCard();
        //    libraryCard01.setId(1);
        libraryCard01.setExpirationDate(LocalDate.now());

        LibraryCard libraryCard02 = new LibraryCard();
        //  libraryCard02.setId(2);
        libraryCard02.setExpirationDate(LocalDate.now());

        LibraryCard libraryCard03 = new LibraryCard();
        //   libraryCard03.setId(3);
        libraryCard03.setExpirationDate(LocalDate.now());

        // Set up the relationship between Student and LibraryCard objects
        student01.setLibraryCard(libraryCard01);
        student02.setLibraryCard(libraryCard02);
        student03.setLibraryCard(libraryCard03);

        // Hibernate configuration and create SessionFactory
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class)
                .addAnnotatedClass(LibraryCard.class);
        SessionFactory sf = con.buildSessionFactory();

        // Open Session and begin Transaction
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Save Student and LibraryCard objects
        session.save(student01);
        session.save(student02);
        session.save(student03);
        session.save(libraryCard01);
        session.save(libraryCard02);
        session.save(libraryCard03);


        // Commit Transaction and close Session
        tx.commit();
        session.close();
        sf.close();







    }

}