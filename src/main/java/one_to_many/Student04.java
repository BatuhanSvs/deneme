package one_to_many;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student04 {

    @Id
    private int id;

    //with this way we can do our input more functionel
    @Column(name="std_name",length = 100,unique = true)
    private String name;

    @Column
    private  int grade;

    @OneToMany(mappedBy = "student", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Book04> bookList = new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book04> getBooklist() {
        return bookList;
    }

    public void setBooklist(List<Book04> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student04 = {" +
                 id +
                "," + name +
                ", " + grade +
                ", bookList=" + bookList +
                '}';
    }
}
