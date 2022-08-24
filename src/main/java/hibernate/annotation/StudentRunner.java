package hibernate.annotation;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentRunner {
    public static void main(String[] args) {
        Student01 std1=new Student01();
        std1.setId(100);
        std1.setName("Ozlem");
        std1.setGender(90);

        Student01 std2=new Student01();
        std2.setId(101);
        std2.setName("Mahir");
        std2.setGender(100);


        Student01 std3=new Student01();
        std3.setId(102);
        std3.setName("Yilmaz");
        std3.setGender(85);

        Student01 std4=new Student01();
        std4.setId(103);
        std4.setName("Okur");
        std4.setGender(60);

        Student01 std5=new Student01();
        std5.setId(104);
        std5.setName("Sevim");
        std5.setGender(100);

        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx=session.beginTransaction();

        session.save(std1);
        session.save(std2);
        session.save(std3);
        session.save(std4);
        session.save(std5);


        tx.commit();

        // Every session creates connections backend. If you don't close the session, connections stay alive. And then it can be problem for our codes
        session.close();
        sf.close();


    }
}
