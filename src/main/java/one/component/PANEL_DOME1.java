package one.component;


import one.bean.StuScore;
import one.service.MainService;
import one.service.MainServiceIpl;
import one.service.ServiceIpl;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class PANEL_DOME1 {
    private static ArrayList Array = new ArrayList();

    public static void main(String[] args) {

        try {
            INUI();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static JPanel INUI() throws SQLException {

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
        p1.setSize(700, 600);
        p1.setLocation(0, 0);
        p1.setLayout(null);
        login.setLocationRelativeTo(null);
        login.add(p1);//
        login.setResizable(false);//设置窗口大小不可变

        JLabel label = new JLabel("我的个人成绩");
        label.setSize(80, 30);
        label.setLocation(80, 60);
        p1.add(label);

        String[] columns = {"学号", "姓名", "课程名称", "成绩", "学年学期"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable scoreTable = new JTable(tableModel);
        scoreTable.setFont(new Font("宋体", Font.LAYOUT_LEFT_TO_RIGHT, 16));
        scoreTable.setRowHeight(30);
        DefaultTableCellRenderer tableCell = new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isselected, boolean hasfocus,
                                                           int row, int column) {
                if (row % 2 == 0) {
                    setBackground(new Color(138, 191, 224));
                } else {
                    setBackground(new Color(181, 222, 174));
                }
                return super.getTableCellRendererComponent(table, value, isselected, hasfocus, row, column);
            }
        };
        tableCell.setHorizontalAlignment(SwingConstants.CENTER);
        scoreTable.setDefaultRenderer(Object.class, tableCell);
        JTableHeader tableHeader = scoreTable.getTableHeader();
        tableHeader.setFont(new Font("宋体", Font.LAYOUT_LEFT_TO_RIGHT, 16));
        tableHeader.setBackground(Color.cyan);
        tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 30));
        JScrollPane tableJScrollPane = new JScrollPane(scoreTable);
        tableJScrollPane.setSize(700, 400);
        tableJScrollPane.setLocation(0, 100);
        tableJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        tableJScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        p1.add(tableHeader);

        String XueHao = ServiceIpl.USER.getStuNO();
        p1.add(tableJScrollPane);


        System.out.println(123);
        CONNECT(XueHao);

        System.out.println(456);
        System.out.println(Array);


        JComboBox szxy = new JComboBox(Array.toArray(new String[Array.size()]));
        szxy.setSize(150, 30);
        szxy.setLocation(0, 0);
        p1.add(tableHeader);
        p1.add(szxy);
        szxy.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    tableModel.setRowCount(0);
                    String term = (String) szxy.getSelectedItem();
                    try {
                        SQL(term, XueHao,tableModel);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
            }

            private void SQL(String term, String xueHao, DefaultTableModel tableModel) throws SQLException {
                if (term.length() > 0) {
                    Connection con = DriverManager.getConnection("jdbc:mysql://mysql.sqlpub.com:3306/jinlesql", "wangjinle", "04cda692db5c6b23");
                    Statement stat = con.createStatement();
                    String sql = "select * from jinlesql.stuscore where StuNO=" + xueHao + " and Term="+term+" order by Term LIMIT 501";
                    ResultSet rs = stat.executeQuery(sql);



                    while (rs.next()) {
                        //System.out.println(rs.getString("C1")+"\t"+rs.getString("C2")+"\t"+ rs.getString("C3")+"\t"+rs.getString("C4")+"\t"+rs.getString("C5"));
                        String RStuNo = rs.getString("StuNO");
                        MainService ser=new MainServiceIpl();

                        String RName= ser.GETR(RStuNo);
                        String CourseName = rs.getString("CourseName");
                        String CourseScore = rs.getString("CourseScore");
                        String Term = rs.getString("Term");
                        StuScore s=new StuScore(RStuNo,CourseName,CourseScore,Term);
                        String[]strings=new String[]{RStuNo,RName,CourseName,CourseScore,Term};
                        tableModel.addRow(strings);
                        System.out.println(Term);
                    }


                    con.close();
                    stat.close();
                    con.close();
                }


            }
        });


        //login.setVisible(true);//开发时用的到
        return p1;
    }

    private static void CONNECT(String xueHao) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://mysql.sqlpub.com:3306/jinlesql", "wangjinle", "04cda692db5c6b23");
        Statement stat = con.createStatement();
        String sql = "select Term from jinlesql.stuscore where StuNO=" + xueHao + " group by Term asc ";
        ResultSet rs = stat.executeQuery(sql);


        Array.add("");
        while (rs.next()) {
            //System.out.println(rs.getString("C1")+"\t"+rs.getString("C2")+"\t"+ rs.getString("C3")+"\t"+rs.getString("C4")+"\t"+rs.getString("C5"));
            String RTerm = rs.getString("Term");
            System.out.println(RTerm);


            Array.add(RTerm);

        }


        con.close();
        stat.close();
        con.close();
    }
}
