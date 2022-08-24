package embeddable;



import jakarta.persistence.Embeddable;


@Embeddable
public class Course02 {
    private String elective;
    private String mandatory;

    public String getElective() {
        return elective;
    }

    public void setElective(String elective) {
        this.elective = elective;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

    @Override
    public String toString() {
        return "Course02{" +
                "elective='" + elective + '\'' +
                ", mandatory='" + mandatory + '\'' +
                '}';
    }
}
