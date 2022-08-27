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





        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student04.class).addAnnotatedClass(Book04.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();




        tx.commit();
        session.close();
        sf.close();
    }
}
