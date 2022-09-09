package id_generationStrategy;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave06 {
    public static void main(String[] args) {
        Student06 student1= new Student06();
        student1.setName("John Coffee");
        student1.setGrade( "100");

        Student06 student2= new Student06();
        student2.setName("Tom Hanks");
        student2.setGrade("90");

        Student06 student3= new Student06();
        student3.setName("Sevarus Snape");
        student3.setGrade("60");

        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student06.class);
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
