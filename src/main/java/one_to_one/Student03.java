package one_to_one;

import jakarta.persistence.*;

@Entity
public class Student03 {
    @Id
    private int id;

    @Column(name="std_name")
    private String name;

    //you won't see this part in table thank to @Transit annotation
    //@Transient
    private int grade;

    @OneToOne(mappedBy="student")
    private Diary diary;

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

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    @Override
    public String toString() {
        return "Student03{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
