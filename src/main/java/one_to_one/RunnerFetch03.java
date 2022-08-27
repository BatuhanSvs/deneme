package one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.util.Arrays;
import java.util.List;

public class RunnerFetch03 {
    public static void main(String[] args) {
        Student03 std01=new Student03();

        Diary dry=new Diary();

        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx=session.beginTransaction();

        /*
        std01=session.get(Student03.class,1001);
        System.out.println(std01);
        System.out.println(std01.getDiary());

        dry=session.get(Diary.class,1);
        System.out.println(dry);

         */

        String hql1="SELECT s.name, d.name,s.grade FROM Student03 s INNER JOIN FETCH Diary d ON s.id = d.student";
        List<Object[]> result1= session.createQuery(hql1).getResultList();

        result1.stream().forEach(t-> System.out.println(Arrays.toString(t)));


        System.out.println("==============================================");

//This will get all students information
        String hql2="SELECT s.name, d.name,s.grade FROM Student03 s LEFT JOIN FETCH Diary d ON s.id = d.student";
        List<Object[]> result2= session.createQuery(hql2).getResultList();

        result2.stream().forEach(t-> System.out.println(Arrays.toString(t)));

        System.out.println("==============================================");

//This will get ann diary information
        String hql3="SELECT s.name, d.name,s.grade FROM Student03 s RIGHT JOIN FETCH Diary d ON s.id = d.student";
        List<Object[]> result3= session.createQuery(hql3).getResultList();

        result3.stream().forEach(t-> System.out.println(Arrays.toString(t)));

        System.out.println("==============================================");

        String hql4="FROM Student03 s INNER JOIN FETCH s.diary";
        List<Student03> result4= session.createQuery(hql4).getResultList();
        System.out.println(result4);

        System.out.println("==============================================");

        String hql5="FROM Diary d INNER JOIN FETCH d.student";
        List<Diary> result5= session.createQuery(hql5).getResultList();
        System.out.println(result5);

        System.out.println("==================================================================");

        Query<Result> query= session.createQuery("SELECT new one_to_one.Result(s.name, d.name,s.grade) FROM Student03 s INNER JOIN FETCH Diary d ON s.id=d.student");

        List<Result> results=query.getResultList();

        results.stream().forEach(t-> System.out.println(t));






        tx.commit();
        session.close();
        sf.close();
    }
}
