package one.bean;

public class StuScore {
    public String StuNO;
    public String CourseName;
    public String CourseScore;
    public String Term;

    public StuScore(String stuNO, String courseName, String courseScore, String term) {
        StuNO = stuNO;
        CourseName = courseName;
        CourseScore = courseScore;
        Term = term;
    }

    public String getStuNO() {
        return StuNO;
    }

    public void setStuNO(String stuNO) {
        StuNO = stuNO;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getCourseScore() {
        return CourseScore;
    }

    public void setCourseScore(String courseScore) {
        CourseScore = courseScore;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String term) {
        Term = term;
    }

    @Override
    public String toString() {
        return "StuScore{" +
                "StuNO='" + StuNO + '\'' +
                ", CourseName='" + CourseName + '\'' +
                ", CourseScore='" + CourseScore + '\'' +
                ", Term='" + Term + '\'' +
                '}';
    }
}
