package first_secondlevelcache;

import one_to_many.Book04;
import one_to_many.Student04;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {
    public static void main(String[] args) {

        Student08 student1= new Student08();
        Student08 student2= new Student08();

        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student08.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();

        Transaction tx=session.beginTransaction();



        // 1.level cache 1.senario: in same session with same id doing fetch

        student1= session.get(Student08.class,1L);

        System.out.println("------------------------------------");
        System.out.println(student1);

        System.out.println("------------------------------------");

        student2= session.get(Student08.class,1L);

        System.out.println("------------------------------------");
        System.out.println(student2);

        System.out.println("+++++++++//+++++//++//+/+/+/+//+/+/+/+/");

        session.clear();

        // 2.senario: in same session with different id doing fetch

        student1= session.get(Student08.class,1L);

        System.out.println("------------------------------------");
        System.out.println(student1);

        System.out.println("------------------------------------");

        student2= session.get(Student08.class,2L);

        System.out.println("------------------------------------");
        System.out.println(student2);

        session.clear();
        System.out.println();

        System.out.println("---------second level cache---------------------------");

        //2.level cache 1.senario:

        student1=session.get(Student08.class, 1L);
        System.out.println(student1);

        tx.commit();
        session.close();

        System.out.println("++++*+*+/+//+/+/+/+/+*/-/+/+/*/*//+");

        Session session2=sf.openSession();
        Transaction tx2=session2.beginTransaction();

        student2=session2.get(Student08.class,1L);
        System.out.println(student2);

        tx2.commit();
        session2.close();


        sf.close();

    }



}
