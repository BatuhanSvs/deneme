package many_to_many;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {
    public static void main(String[] args) {

        Book05 bookArt=new Book05();
        Book05 bookMath=new Book05();

        Student05 student1= new Student05();
        Student05 student2= new Student05();
        Student05 student3= new Student05();

        student1.setId(1001);
        student1.setName("John Coffee");
        student1.setGrade("65");
        student1.getBookList().add(bookMath);
        student1.getBookList().add(bookArt);

        student2.setId(1002);
        student2.setName("Tom Hanks");
        student2.setGrade("70");
        student2.getBookList().add(bookMath);
        student2.getBookList().add(bookArt);

        student3.setId(1003);
        student3.setName("Sevarus Snape");
        student3.setGrade("80");
        student3.getBookList().add(bookMath);
        student3.getBookList().add(bookArt);


        bookArt.setId(101);
        bookArt.setName("Art book");

        bookMath.setId(102);
        bookMath.setName("Math book");


        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student05.class).addAnnotatedClass(Book05.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();

        Transaction tx=session.beginTransaction();

        session.persist(student1);
        session.persist(student2);
        session.persist(student3);


        tx.commit();
        session.close();
        sf.close();
    }
}
