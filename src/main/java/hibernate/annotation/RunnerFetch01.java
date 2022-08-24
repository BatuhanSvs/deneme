package hibernate.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {

        Student01 student01=new Student01();


        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx=session.beginTransaction();

        /*1.way
        student01=session.get(Student01.class,101);
        System.out.println(student01);

         */

        /*2.way:
        String sqlQuery="SELECT*FROM tbl_student1";
        List<Object[]> list1=session.createNativeQuery(sqlQuery).getResultList();
        for (Object[] r:list1) {
            System.out.println(Arrays.toString(r));
            System.out.println(r[0]);
        }

         */


        /*3.way
        String hqlQuery="FROM Student01";
        List<Student01> list2=session.createQuery(hqlQuery).getResultList();
        for (Student01 r:list2
             ) {

            //this output shape with toString() method in our Student01 class.
            System.out.println(r);
        }
         */

        String sqlQuery2="SELECT*FROM tbl_student1 t WHERE t.student_name= 'Ozlem'";
        List<Object[]> result=session.createNativeQuery(sqlQuery2).getResultList();

        result.stream().forEach(t-> System.out.println(Arrays.toString(t)));

        /*if you sure that your result will be unique you can use this way. We should do casting, because we don't know
        what it will return us

        Object[] result=(Object[]) session.createNativeQuery(sqlQuery2).uniqueResult();
        System.out.println(Arrays.toString(result));

         */

        /*
         we can do all same thing in hql

         String hqlQuery= "FROM tbl_student01 WHERE name='Ozlem'"
         */

//I didn't named table with Entity annotation. so I used class name and parameters name
        String hqlQuery02= "SELECT t.name FROM Student01 t WHERE t.gender=100";
        List<Student01> list2=session.createQuery(hqlQuery02).getResultList();
        System.out.println(list2);






        tx.commit();
        session.close();
        sf.close();
    }
}
