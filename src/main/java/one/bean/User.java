package one.bean;

public class User {
    private String UserName ;
    private String UserPwd;
    private String StuNO;
    public User(){

    }
    public User(String userNam, String userPwd, String stuNO) {
        UserName = userNam;
        UserPwd = userPwd;
        StuNO = stuNO;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userNam) {
        UserName = userNam;
    }

    public String getUserPwd() {
        return UserPwd;
    }

    public void setUserPwd(String userPwd) {
        UserPwd = userPwd;
    }

    public String getStuNO() {
        return StuNO;
    }

    public void setStuNO(String stuNO) {
        StuNO = stuNO;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserNam='" + UserName + '\'' +
                ", UserPwd='" + UserPwd + '\'' +
                ", StuNO='" + StuNO + '\'' +
                '}';
    }
}
