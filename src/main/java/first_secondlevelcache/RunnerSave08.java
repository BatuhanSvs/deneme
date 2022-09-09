package first_secondlevelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave08 {
    public static void main(String[] args) {
        Student08 student1= new Student08();
        Student08 student2= new Student08();

        student1.setName("Ozlem YILMAZ OKUR");
        student1.setGrade(100);

        student2.setName("Mahir OKUR");
        student2.setGrade(100);


        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student08.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        session.persist(student1);
        session.persist(student2);


        tx.commit();
        session.close();
        sf.close();
    }
}
