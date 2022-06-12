package one.service;

import java.sql.SQLException;
import java.text.ParseException;

public interface MainService {

    void YanZheng(String stuNO, String stuName, String StuSex, String StuBirthday, String StuNation,String Grader, String byg, StringBuilder StuPlace, String StuMobile, String StuEmail, String StuDept, String StuPro, String StuClass) throws SQLException;

    void AddData(String stuNO, String askStart, String askEnd, String askType, String askReason, String askDestination) throws ParseException;

    String GETR(String RStuNo);
}
