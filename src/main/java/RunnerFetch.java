
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch {
    public static void main(String[] args) {

        // Hibernate configuration and create SessionFactory
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class)
                .addAnnotatedClass(LibraryCard.class);
        SessionFactory sf = con.buildSessionFactory();

        // Open Session and begin Transaction
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Fetch Student and LibraryCard objects using get()
/*
        Student student1 = session.get(Student.class, 1);
        LibraryCard libraryCard1 = session.get(LibraryCard.class, 1);

        Student student2 = session.get(Student.class, 2);
        LibraryCard libraryCard2 = session.get(LibraryCard.class, 2);

        Student student3 = session.get(Student.class, 3);
        LibraryCard libraryCard3 = session.get(LibraryCard.class, 3);

        // Print the fetched objects
        System.out.println(student1);
        System.out.println(libraryCard1);

        System.out.println(student2);
        System.out.println(libraryCard2);

        System.out.println(student3);
        System.out.println(libraryCard3);
*/

        String hqlQuery = "From Student";
        List<Student> studentList = session.createQuery(hqlQuery, Student.class).getResultList();

        for(Student std: studentList){
            System.out.println(std);
        }

        String hqlQuery2 = "From LibraryCard";
        List<LibraryCard> cardList = session.createQuery(hqlQuery2, LibraryCard.class).getResultList();

        for(LibraryCard card: cardList) {
            System.out.println(card);
        }



        // Commit Transaction and close Session
        tx.commit();
        session.close();
        sf.close();
    }
}