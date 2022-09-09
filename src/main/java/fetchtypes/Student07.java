package fetchtypes;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student07 {

    @Id
    private int id;

    private String name;

    private String grade;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book07>  bookList= new ArrayList<>();

    public List<Book07> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book07> bookList) {
        this.bookList = bookList;
    }

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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' + " , "+bookList+
                '}';
    }
}
