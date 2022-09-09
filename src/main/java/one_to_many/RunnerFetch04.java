package one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {
        Student04 student1= new Student04();
        Student04 student2= new Student04();
        Book04 book1=new Book04();
        Book04 book2=new Book04();

        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student04.class).addAnnotatedClass(Book04.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //We get the book name of the student whose Id was given with get() method
        student1=session.get(Student04.class,101);
        List<Book04> b=student1.getBooklist();
        b.stream().forEach(t-> System.out.println(t));

        System.out.println("******************************");

        //We reach the owner's name of the book which one's ıd was given
        book1=session.get(Book04.class,1);
        Student04 std=book1.getStudent();
        System.out.println(std);

        System.out.println("******************************");

        book1=session.get(Book04.class,4);
        Student04 std1=book1.getStudent();
        System.out.println(std1);

        System.out.println("******************************");

        book1=session.get(Book04.class,2);
        System.out.println(book1.getStudent().getName());

        System.out.println("******************************");

        String sqlQuery1="SELECT s.id, s.std_name,b.name FROM student04 s INNER JOIN book04 b ON s.id=b.student_id";
        List<Object []> result1= session.createNativeQuery(sqlQuery1).getResultList();
        result1.stream().forEach(t-> System.out.println(Arrays.toString(t)));

        System.out.println("******************************");

        //it show an error but it doesn't matter
        String hqlQuery1="SELECT s.id, s.name,b.name FROM Student04 s INNER JOIN FETCH Book04 b ON s.id=b.student";
        List<Object []> result2= session.createQuery(hqlQuery1).getResultList();
        result2.stream().forEach(t-> System.out.println(Arrays.toString(t)));

        System.out.println("******************************");

        String hqlQuery2="SELECT s.id, s.name,b.name FROM Student04 s LEFT JOIN FETCH Book04 b ON s.id=b.student";
        List<Object []> result3= session.createQuery(hqlQuery2).getResultList();
        result3.stream().forEach(t-> System.out.println(Arrays.toString(t)));

        System.out.println("******************************");

        String hqlQuery3="SELECT s.id, s.name,b.name FROM Student04 s RIGHT JOIN FETCH Book04 b ON s.id=b.student";
        List<Object []> result4= session.createQuery(hqlQuery3).getResultList();
        result4.stream().forEach(t-> System.out.println(Arrays.toString(t)));

        System.out.println("******************************");

       /* Delete with sql

        String sqlQuery2="DELETE FROM book04";
        int numOffRec1=session.createNativeQuery(sqlQuery2).executeUpdate();
        System.out.println("Effected rows: "+numOffRec1);

        */


/* Delete with hql
        String hqlQuery4= "DELETE FROM Book04";
        int effRows=session.createQuery(hqlQuery4).executeUpdate();
        System.out.println("Effected rows: "+effRows);

 */

/* Delete a special book

        String hqlQuery5="DELETE FROM Book04 b WHERE b.name='The art book of Johny Depp' ";
        int effRaws2=session.createQuery(hqlQuery5).executeUpdate();
        System.out.println("Effected rows: " + effRaws2);

 */
       /*Delete specific book by using student id. We can also delete a specific student in Student04 class by using student id. I mean , if you
       use id with Book04, you will delete book. if you use id with Student04 you will delete student but you should be careful.

        String hqlQuery6="DELETE FROM Book04 b WHERE b.student=101 ";
        int effRaws3=session.createQuery(hqlQuery6).executeUpdate();
        System.out.println("Effected rows: " + effRaws3);


        */
/*
        student2=session.get(Student04.class,101);
        session.delete(student2);

        this function will give you "Cannot delete or update a parent row: a foreign key constraint fails" error. but you can delete the book by using student id
 */


        book2=session.get(Book04.class,1);
        session.remove(book2);








        tx.commit();
        session.close();
        sf.close();
    }
}
