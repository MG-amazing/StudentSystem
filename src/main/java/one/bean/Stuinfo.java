package one.bean;

public class Stuinfo {
    private String StuNo;
    private String StuName;
    private String StuSex;
    private String StuBirthday;
    private String StuNation;
    private String StuPlace;
    private String StuMobile;
    private String StuEmail;
    private String StuDept;
    private String StuPro;
    private String StudentGrade;
    private String StuClass;

    public Stuinfo() {
    }

    public Stuinfo(String stuNo, String stuName, String stuSex, String stuBirthday, String stuNation, String stuPlace, String stuMobile, String stuEmail, String stuDept, String stuPro, String studentGrade, String stuClass) {
        StuNo = stuNo;
        StuName = stuName;
        StuSex = stuSex;
        StuBirthday = stuBirthday;
        StuNation = stuNation;
        StuPlace = stuPlace;
        StuMobile = stuMobile;
        StuEmail = stuEmail;
        StuDept = stuDept;
        StuPro = stuPro;
        StudentGrade = studentGrade;
        StuClass = stuClass;
    }

    public Stuinfo(String rStuNo) {
        StuNo = rStuNo;
    }

    public String getStuNo() {
        return StuNo;
    }

    public void setStuNo(String stuNo) {
        StuNo = stuNo;
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public String getStuSex() {
        return StuSex;
    }

    public void setStuSex(String stuSex) {
        StuSex = stuSex;
    }

    public String getStuBirthday() {
        return StuBirthday;
    }

    public void setStuBirthday(String stuBirthday) {
        StuBirthday = stuBirthday;
    }

    public String getStuNation() {
        return StuNation;
    }

    public void setStuNation(String stuNation) {
        StuNation = stuNation;
    }

    public String getStuPlace() {
        return StuPlace;
    }

    public void setStuPlace(String stuPlace) {
        StuPlace = stuPlace;
    }

    public String getStuMobile() {
        return StuMobile;
    }

    public void setStuMobile(String stuMobile) {
        StuMobile = stuMobile;
    }

    public String getStuEmail() {
        return StuEmail;
    }

    public void setStuEmail(String stuEmail) {
        StuEmail = stuEmail;
    }

    public String getStuDept() {
        return StuDept;
    }

    public void setStuDept(String stuDept) {
        StuDept = stuDept;
    }

    public String getStuPro() {
        return StuPro;
    }

    public void setStuPro(String stuPro) {
        StuPro = stuPro;
    }

    public String getStudentGrade() {
        return StudentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        StudentGrade = studentGrade;
    }

    public String getStuClass() {
        return StuClass;
    }

    public void setStuClass(String stuClass) {
        StuClass = stuClass;
    }

    @Override
    public String toString() {
        return "Stuinfo{" +
                "StuNo='" + StuNo + '\'' +
                ", StuName='" + StuName + '\'' +
                ", StuSex='" + StuSex + '\'' +
                ", StuBirthday='" + StuBirthday + '\'' +
                ", StuNation='" + StuNation + '\'' +
                ", StuPlace='" + StuPlace + '\'' +
                ", StuMobile='" + StuMobile + '\'' +
                ", StuEmail='" + StuEmail + '\'' +
                ", StuDept='" + StuDept + '\'' +
                ", StuPro='" + StuPro + '\'' +
                ", StudentGrade='" + StudentGrade + '\'' +
                ", StuClass='" + StuClass + '\'' +
                '}';
    }
}
