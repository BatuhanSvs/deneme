package one_to_many;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {
    public static void main(String[] args) {

        Book04 book1=new Book04();
        Book04 book2=new Book04();
        Book04 book3=new Book04();
        Book04 book4=new Book04();

        Student04 std1=new Student04();
        Student04 std2=new Student04();

        std1.setId(101);
        std1.setName("Johny Depp");
        std1.setGrade(95);

        std2.setId(102);
        std2.setName("Leo");
        std2.setGrade(90);


        book1.setId(1);
        book1.setName("The art book of "+std1.getName());
        book1.setStudent(std1);

        book2.setId(2);
        book2.setName("The math book of "+std1.getName());
        book2.setStudent(std1);

        book3.setId(3);
        book3.setName("The chemistry book of "+std2.getName());
        book3.setStudent(std2);

        book4.setId(4);
        book4.setName("Nobody have this book");

        std1.getBooklist().add(book1);
        std1.getBooklist().add(book2);
        std1.getBooklist().add(book4);
        std2.getBooklist().add(book3);


        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student04.class).addAnnotatedClass(Book04.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        session.persist(std1);
        session.persist(std2);

        /* we will comment this part thanks to orphanRemoval and CascateType

        session.persist(book1);
        session.persist(book2);
        session.persist(book3);
        session.persist(book4);


         */


        tx.commit();
        session.close();
        sf.close();
    }
}
