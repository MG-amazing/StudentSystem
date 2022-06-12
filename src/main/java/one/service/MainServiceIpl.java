package one.service;

import one.bean.StuAskLevel;
import one.bean.Stuinfo;
import one.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MainServiceIpl implements MainService {
    private static User user;
    public static ArrayList<Stuinfo> LIST = new ArrayList();
    public static Stuinfo Stuinfo1 = new Stuinfo();
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static Stuinfo Y;



    @Override
    public void YanZheng(String stuNO, String stuName, String StuSex, String StuBirthday, String StuNation, String Grader, String byg, StringBuilder StuPlace, String StuMobile, String StuEmail, String StuDept, String StuPro, String StuClass) throws SQLException {
        user = ServiceIpl.USER;
        System.out.println(stuNO + stuName + StuSex + StuBirthday + StuNation + StuPlace + StuMobile + StuEmail + StuDept + Grader + StuPro + StuClass);
        String Place = String.valueOf(StuPlace);
        if (user.getStuNO().equals(stuNO)) {
            if (stuName.equals("") || StuPlace.equals("") || StuEmail.equals("")) {
                JOptionPane.showMessageDialog(null, "请输入完整数据");
            } else {
                //进入数据库验证阶段
                Y = new Stuinfo(stuNO, stuName, StuSex, StuBirthday, StuNation, Place, StuMobile, StuEmail, StuDept, StuPro, Grader, StuClass);
                System.out.println(Y);
                Connection con = DriverManager.getConnection("jdbc:mysql://mysql.sqlpub.com:3306/jinlesql", "wangjinle", "04cda692db5c6b23");
                Statement stat = con.createStatement();
                String sql = "select *from jinlesql.stuinfo";
                ResultSet rs = stat.executeQuery(sql);
                while (rs.next()) {
                    //System.out.println(rs.getString("C1")+"\t"+rs.getString("C2")+"\t"+ rs.getString("C3")+"\t"+rs.getString("C4")+"\t"+rs.getString("C5"));
                    String RStuNo = rs.getString("StuNo");
                    String RStuName = rs.getString("StuName");
                    String RStuSex = rs.getString("StuSex");
                    String RStuBirthday = rs.getString("StuBirthday");
                    String RStuNation = rs.getString("StuNation");
                    String RStuPlace = rs.getString("StuPlace");
                    String RStuMobile = rs.getString("StuMobile");
                    String RStuEmail = rs.getString("StuEmail");
                    String RStuDept = rs.getString("StuDept");
                    String RStuPro = rs.getNString("StuPro");
                    String RStudentGrade = rs.getString("StudentGrade");
                    String RStuClass = rs.getString("StuClass");
                    Stuinfo1 = new Stuinfo(RStuNo, RStuName, RStuSex, RStuBirthday, RStuNation, RStuPlace, RStuMobile, RStuEmail, RStuDept, RStuPro, RStudentGrade, RStuClass);
                    System.out.println(Stuinfo1);
                    LIST.add(Stuinfo1);

                }
                con.close();
                stat.close();
                con.close();
                boolean flag = false;
                for (one.bean.Stuinfo stuinfo : LIST) {
                    if (stuinfo.getStuNo().equals(user.getStuNO())) {
                        flag = true;
                    }
                }
                System.out.println(flag);
                if (flag == false) {
                    JOptionPane.showMessageDialog(null, "当前不存在此账户信息,正在帮您插入此信息，请稍后~");
                    chan();
                } else {
                    JOptionPane.showMessageDialog(null, "当前数据库中存在当前插入信息，无法重新插入，若想修改您的个人信息请联系管理员");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "您输入的学号不正确！！");
        }
    }

    @Override
    public void AddData(String stuNO, String askStart, String askEnd, String askType, String askReason, String askDestination) throws ParseException {
        if (askReason.equals("") && askDestination.equals("")) {
            JOptionPane.showMessageDialog(null, "请补全信息");
        } else {
            if (askReason.length() > 150 || askDestination.length() > 50) {
                JOptionPane.showMessageDialog(null, "您当前输入的信息太多无法提交");
            } else {
                Date start = sdf.parse(askStart);
                Date end = sdf.parse(askEnd);
                if (end.before(start) || end.equals(start)) {
                    JOptionPane.showMessageDialog(null, "您当前输入的起始日期早于或等于结束日期");
                } else {
                    //进入数据库连接阶段
                    //数据库存在唯一约束不用验证,出现异常直接通知用户即可
                    StuAskLevel s = new StuAskLevel(stuNO, start, end, askType, askReason, askDestination);
                    CSJ(s);

                }
            }

        }


    }

    @Override
    public String GETR(String RStuNo) {
        //加载mybatis的核心配置文件,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SQLSession对象 执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取对应的UserMapper接口的代理对象
        //MainInterfaceMapper userMapper = sqlSession.getMapper(MainInterfaceMapper.class);
        List<Stuinfo>stuinfos=sqlSession.selectList("test.GetName");
        AtomicReference<String> name= new AtomicReference<>("");
        stuinfos.stream().filter(stuinfo -> stuinfo.getStuNo().equals(RStuNo)).forEach(stuinfo -> {
            name.set(stuinfo.getStuName());
        });

        sqlSession.close();
        return name.get();

    }

    private void CSJ(StuAskLevel s) {
        //        加载核心配置文件
        InputStream stream = null;
        try {
            stream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        获得工厂对象
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(stream);
//        获得session对象
        SqlSession sqlSession = build.openSession();
//        参数：namespace+id
        try {
            sqlSession.insert("InsertSAL", s);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "您未提交个人信息,或重复提交请假申请");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    private void chan() {


//        加载核心配置文件
        InputStream stream = null;
        try {
            stream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        获得工厂对象
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(stream);
//        获得session对象
        SqlSession sqlSession = build.openSession();
//        参数：namespace+id
        try {
            sqlSession.insert("InsertVSI", Y);
            System.out.println(Y.getStuSex() + "bbbbb");
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
