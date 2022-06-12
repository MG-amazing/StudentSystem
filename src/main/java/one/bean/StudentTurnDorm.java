package one.bean;

public class StudentTurnDorm {

    private String StuNO;
    private String StuDorm;
    private String StuReason;

    public StudentTurnDorm(String stuNO, String stuDorm, String stuReason) {
        StuNO = stuNO;
        StuDorm = stuDorm;
        StuReason = stuReason;
    }

    public String getStuNO() {
        return StuNO;
    }

    public void setStuNO(String stuNO) {
        StuNO = stuNO;
    }

    public String getStuDorm() {
        return StuDorm;
    }

    public void setStuDorm(String stuDorm) {
        StuDorm = stuDorm;
    }

    public String getStuReason() {
        return StuReason;
    }

    public void setStuReason(String stuReason) {
        StuReason = stuReason;
    }

    @Override
    public String toString() {
        return "StudentTurnDorm{" +
                "StuNO='" + StuNO + '\'' +
                ", StuDorm='" + StuDorm + '\'' +
                ", StuReason='" + StuReason + '\'' +
                '}';
    }
}
