package embeddable;

import jakarta.persistence.*;

@Entity
public class Student02 {


        @Id
        private int id;

        /*
         * if you want to rename your columns name you can also change these @Column(name=...) method. Otherwise you will see your
         * column name like variable name.
         * */
        @Column(name= "student_name")
        private String name;

        @Column(name="student_grade")
        private int gender;

        @Embedded
        private Course02 courses;

    public Course02 getCourses() {
        return courses;
    }

    public void setCourses(Course02 courses) {
        this.courses = courses;
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

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }


    @Override
    public String toString() {
        return "Student02[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", courses=" + courses +
                ']';
    }
}

