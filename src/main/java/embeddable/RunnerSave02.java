package embeddable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {
        Course02 course=new Course02();
        course.setElective("Music,English,Turkish");
        course.setMandatory("Math,Chemistry,Physics");

        Student02 student= new Student02();
        student.setId(1001);
        student.setName("Sukran");
        student.setGender(80);
        student.setCourses(course);



        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student02.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();

        Transaction tx=session.beginTransaction();

        session.save(student);

        tx.commit();
        session.close();
        sf.close();
    }
}
