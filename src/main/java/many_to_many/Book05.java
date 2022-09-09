package many_to_many;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book05 {

    @Id
    private int id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "bookList")
    private List<Student05> studentList=new ArrayList<>();

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

    public List<Student05> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student05> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Book05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
