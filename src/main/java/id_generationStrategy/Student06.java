package id_generationStrategy;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity

public class Student06 {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
   // @GeneratedValue(strategy = GenerationType.AUTO, generator = "STD_SEQ")
   // @SequenceGenerator(name = "STD_SEQ", initialValue = 1000, allocationSize = 50)

    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }



  /*
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "uuid2")
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

   */



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    private String name;

    private String grade;
}
