package one_to_one;

public class Result {
    private  String studentName;
    private String diaryName;
    private int studentGrade;

    public Result() {
    }

    public Result(String studentName, String diaryName, int studentGrade) {
        this.studentName = studentName;
        this.diaryName = diaryName;
        this.studentGrade = studentGrade;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDiaryName() {
        return diaryName;
    }

    public void setDiaryName(String diaryName) {
        this.diaryName = diaryName;
    }

    public int getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(int studentGrade) {
        this.studentGrade = studentGrade;
    }

    @Override
    public String toString() {
        return "Result[" + studentName +"," + diaryName +"," + studentGrade +']';
    }
}
