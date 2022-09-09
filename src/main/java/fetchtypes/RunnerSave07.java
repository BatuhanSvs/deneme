package fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {
    public static void main(String[] args) {

        Student07 student1=new Student07();
        Student07 student2=new Student07();
        Student07 student3=new Student07();

        Book07 book1= new Book07();
        Book07 book2= new Book07();
        Book07 book3= new Book07();
        Book07 book4= new Book07();

        student1.setName("John Coffee");
        student1.setGrade("65");
        student1.setId(100);

        student2.setName("Harry Potter");
        student2.setGrade("100");
        student2.setId(101);

        student3.setName("Sevarus Snape");
        student3.setGrade("100");
        student3.setId(102);


        book1.setId(1);
        book1.setName("Ezginin günlğü");
        book1.setStudent(student1);

        book2.setId(2);
        book2.setName("Melez Prens");
        book2.setStudent(student1);

        book3.setId(3);
        book3.setName("Zümrüd-ü anka yoldaşlığı");
        book3.setStudent(student2);

        book4.setId(4);
        book4.setName("Ezginin günlğü");
        book4.setStudent(null);

        student1.getBookList().add(book1);
        student1.getBookList().add(book2);
        student2.getBookList().add(book3);




        Configuration con= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session=sf.openSession();

        Transaction tx= session.beginTransaction();

        session.persist(student1);
        session.persist(student2);
        session.persist(student3);



        tx.commit();
        session.close();
        sf.close();
    }

}
