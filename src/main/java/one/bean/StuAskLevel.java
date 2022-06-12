package one.bean;

import java.util.Date;

public class StuAskLevel {
    private String StuNO;
    private Date askStart;
    private Date askEnd;
    private String askType;
    private String askReason;
    private String askDestination;
    public StuAskLevel(){

    }

    public StuAskLevel(String stuNO, Date askStart, Date askEnd, String askType, String askReason, String askDestination) {
        StuNO = stuNO;
        this.askStart = askStart;
        this.askEnd = askEnd;
        this.askType = askType;
        this.askReason = askReason;
        this.askDestination = askDestination;
    }

    public String getStuNO() {
        return StuNO;
    }

    public void setStuNO(String stuNO) {
        StuNO = stuNO;
    }

    public Date getAskStart() {
        return askStart;
    }

    public void setAskStart(Date askStart) {
        this.askStart = askStart;
    }

    public Date getAskEnd() {
        return askEnd;
    }

    public void setAskEnd(Date askEnd) {
        this.askEnd = askEnd;
    }

    public String getAskType() {
        return askType;
    }

    public void setAskType(String askType) {
        this.askType = askType;
    }

    public String getAskReason() {
        return askReason;
    }

    public void setAskReason(String askReason) {
        this.askReason = askReason;
    }

    public String getAskDestination() {
        return askDestination;
    }

    public void setAskDestination(String askDestination) {
        this.askDestination = askDestination;
    }

    @Override
    public String toString() {
        return "StuAskLevel{" +
                "StuNO='" + StuNO + '\'' +
                ", askStart=" + askStart +
                ", askEnd=" + askEnd +
                ", askType='" + askType + '\'' +
                ", askReason='" + askReason + '\'' +
                ", askDestination='" + askDestination + '\'' +
                '}';
    }
}
