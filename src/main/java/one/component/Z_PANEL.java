package one.component;

import one.bean.StudentTurnDorm;
import one.bean.Stuinfo;

import one.service.ServiceIpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;


public class Z_PANEL {
    public static Stuinfo Y;

    public static void main(String[] args) {
        INUIN();
    }

    public static Component INUIN() {
        JFrame login = new JFrame("");
        login.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setSize(700, 600);
        JPanel p1 = new JPanel();
        login.setLocationRelativeTo(null);
       // login.setVisible(true);
        p1.setLayout(null);

        JLabel l1 = new JLabel("学号", JLabel.CENTER);
        l1.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
        l1.setSize(100, 30);
        l1.setLocation(80, 40);
        p1.add(l1);
        JLabel l2 = new JLabel("姓名", JLabel.CENTER);
        l2.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
        l2.setSize(100, 30);
        l2.setLocation(80, 75);
        p1.add(l2);
        JLabel l3 = new JLabel("学期", JLabel.CENTER);
        l3.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
        l3.setSize(100, 30);
        l3.setLocation(80, 110);
        p1.add(l3);
        JLabel l4 = new JLabel("性别", JLabel.CENTER);
        l4.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
        l4.setSize(100, 30);
        l4.setLocation(80, 145);
        p1.add(l4);
        JLabel l5 = new JLabel("联系电话", JLabel.CENTER);
        l5.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
        l5.setSize(100, 30);
        l5.setLocation(80, 180);
        p1.add(l5);
        JLabel l6 = new JLabel("学院班级", JLabel.CENTER);
        l6.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
        l6.setSize(100, 30);
        l6.setLocation(80, 215);
        p1.add(l6);

        JLabel l7 = new JLabel("学号", JLabel.CENTER);
        l7.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
        l7.setSize(260, 30);
        l7.setLocation(200, 40);
        p1.add(l7);
        JLabel l8 = new JLabel("姓名", JLabel.CENTER);
        l8.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
        l8.setSize(260, 30);
        l8.setLocation(200, 75);
        p1.add(l8);
        JLabel l9 = new JLabel("学期", JLabel.CENTER);
        l9.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
        l9.setSize(260, 30);
        l9.setLocation(200, 110);
        p1.add(l9);
        JLabel l10 = new JLabel("性别", JLabel.CENTER);
        l10.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
        l10.setSize(260, 30);
        l10.setLocation(200, 145);
        p1.add(l10);
        JLabel l11 = new JLabel("联系电话", JLabel.CENTER);
        l11.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
        l11.setSize(260, 30);
        l11.setLocation(200, 180);
        p1.add(l11);
        JLabel l12 = new JLabel("学院班级", JLabel.CENTER);
        l12.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
        l12.setSize(260, 30);
        l12.setLocation(200, 215);
        p1.add(l12);
        //login.setVisible(false);

//        JLabel l13 = new JLabel("请假理由", JLabel.CENTER);
//        l13.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
//        l13.setSize(80, 30);
//        l13.setLocation(80, 290);
//        p1.add(l13);

        JButton button = new JButton("新建申请");
        button.setSize(120, 30);

        button.setLocation(80, 290);
        p1.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NEWFRAME.INT();
                NEWFRAME.btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String Text = NEWFRAME.area.getText().trim();
                        System.out.println(Text);

                        String s = ServiceIpl.USER.getStuNO();
                        String Dom=NEWFRAME.field.getText().trim();
                        String Reason=NEWFRAME.area.getText().trim();
                        try {
                            ConnSQL(s,Dom,Reason);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
            }
        });


        try {
            getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String xh = null;
        String xm = null;
        String xq = null;
        String xb = null;
        String dh = null;
        String cl = null;
        try {
            xh = Y.getStuNo();
            xm = Y.getStuName();
            xq = Y.getStudentGrade();
            xb = Y.getStuSex();
            dh = Y.getStuMobile();
            cl = Y.getStuDept() + Y.getStuClass();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"您的基本信息未提交,无法使用该面板");
            p1.setVisible(false);
            login.setVisible(false);
        }
        l7.setText(xh);
        l8.setText(xm);
        l9.setText(xq);
        l10.setText(xb);
        l11.setText(dh);
        l12.setText(cl);

        login.setVisible(false);
        login.add(p1);
        return p1;
    }

    private static void ConnSQL(String s, String dom, String reason) throws SQLException {
        if (!dom.equals("")||!reason.equals("")||dom.length()>10||reason.length()>150){
            //封装
            StudentTurnDorm studentTurnDorm=new StudentTurnDorm(s,dom,reason);
            //进入数据库验证阶段
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
                sqlSession.insert("InsertSTD", studentTurnDorm);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"您未提交个人信息,或重复提交请假申请");
            }
            sqlSession.commit();
            sqlSession.close();

        }else {
            JOptionPane.showMessageDialog(null,"您当前未输入任何数据或您输入的数据过多");
        }
    }

    private static void getConnection() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://mysql.sqlpub.com:3306/jinlesql", "wangjinle", "04cda692db5c6b23");
        Statement stat = con.createStatement();
        String sql = "select *from jinlesql.stuinfo where StuNo=" + ServiceIpl.USER.getStuNO() + "";
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
            Stuinfo stuinfo = new Stuinfo(RStuNo, RStuName, RStuSex, RStuBirthday, RStuNation, RStuPlace, RStuMobile, RStuEmail, RStuDept, RStuPro, RStudentGrade, RStuClass);
            System.out.println(stuinfo);
            Y = stuinfo;


        }
        con.close();
        stat.close();
        con.close();
    }

}
