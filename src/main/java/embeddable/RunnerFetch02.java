package embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {
    public static void main(String[] args) {
        Student02 student1=new Student02();

        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student02.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();

        Transaction tx=session.beginTransaction();

        //Be careful about your toString() in Student02
        student1=session.get(Student02.class,1001);
        System.out.println(student1);

        tx.commit();
        session.close();
        sf.close();
    }
}
