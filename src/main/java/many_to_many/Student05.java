package many_to_many;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student05 {

    @Id
    private int id;

    @Column(name ="std_name")
    private String name;

    private String grade;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Student05_Book05", joinColumns={@JoinColumn(name = "std_id")}, inverseJoinColumns ={@JoinColumn(name = "book_id")})
    private List<Book05> bookList=new ArrayList<>();


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

    public List<Book05> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book05> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
