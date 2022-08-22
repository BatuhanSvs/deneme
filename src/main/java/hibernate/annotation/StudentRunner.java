package hibernate.annotation;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentRunner {
    public static void main(String[] args) {
        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        // Every session creates connections backend. If you don't close the session, connections stay alive. And then it can be problem for our codes
        session.close();
        sf.close();


    }
}
