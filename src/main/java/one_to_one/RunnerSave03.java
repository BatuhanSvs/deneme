package one_to_one;

import hibernate.annotation.Student01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {

        Diary diary1= new Diary();
        Diary diary2= new Diary();

        Student03 stdnt1=new Student03();
        Student03 stdnt2= new Student03();

        stdnt1.setId(1001);
        stdnt1.setName("Mahir");
        stdnt1.setGrade(100);
        stdnt1.setDiary(diary1);

        stdnt2.setId(1002);
        stdnt2.setName("Ozlem");
        stdnt2.setGrade(95);



// we have two Entity classes.
        /*
        if we write <mapping class="one_to_one.Student03"/>
                    <mapping class="one_to_one.Diary"/>
         in our xml field ,we don't need to write addAnnotatedClass() method. We can choose one of them.
         */
        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx=session.beginTransaction();


        tx.commit();
        session.close();
        sf.close();
    }
}
