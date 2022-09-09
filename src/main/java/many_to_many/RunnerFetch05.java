package many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch05 {
    public static void main(String[] args) {
        Student05 student1=new Student05();
        Book05 book1=new Book05();

        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student05.class).addAnnotatedClass(Book05.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();

        Transaction tx=session.beginTransaction();

        student1=session.get(Student05.class,1001);
        System.out.println(student1.getName());
        System.out.println("--------------------------------------");
        System.out.println(student1.getBookList().get(0));

        System.out.println("------------------------------------------");

        List<Book05> list = student1.getBookList();
        list.stream().forEach(t-> System.out.println(t));


        System.out.println("------------------------------------------");

        String hqlQuery1="FROM Book05 b WHERE b.name='Math book'";
         book1=(Book05) session.createQuery(hqlQuery1).getSingleResult();
        System.out.println(book1.getName()+ " : "+ book1.getStudentList().size());
         System.out.println(book1.getStudentList());
        System.out.println("------------------------------------------");

        book1.getStudentList().forEach(s-> System.out.println(s));

        System.out.println("------------------------------------------");
        
        
        String hqlQuery2="FROM Student05 s WHERE s.name='Tom Hanks'";
        student1=(Student05)session.createQuery(hqlQuery2).getSingleResult();
        System.out.println(student1.getName());
        student1.getBookList().forEach(t-> System.out.println(t));



        String hqlQuery3="SELECT s.name FROM Student05 s";
       List<Object [] > resultList=session.createQuery(hqlQuery3).list();
        System.out.println(resultList);


        String hqlQuery4="SELECT s.name,b.name FROM Student05 s INNER JOIN FETCH Book05 b ON s.id=1001";
        List<Object [] > resultList2=session.createQuery(hqlQuery4).getResultList();
        System.out.println(resultList2);

        resultList2.forEach(t-> System.out.println(Arrays.toString(t)));


        



        tx.commit();
        session.close();
        sf.close();
    }
}
