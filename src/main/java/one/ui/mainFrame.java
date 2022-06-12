package one.ui;


import one.bean.StuScore;

import one.bean.Stuinfo;
import one.component.Frame_Dome1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;


public class mainFrame {
    private static JPanel person_message_panel_top;
    public static String ACC;
    private static ArrayList Array = new ArrayList();
    public static ArrayList <Stuinfo>arrayList = new ArrayList();
    private static String[] strings;
    private static JComboBox szxy;

    public static void main(String[] args) {
        String t = "1";
        setTure(t);
    }

    public static void setTure(String account) {

        mainFrame jf = new mainFrame();
        ACC = account;
        System.out.println(ACC + "账户");
        jf.c1(account);
    }


    /**
     * @param account 当前账户对象
     */
    void c1(String account) {


        DefaultMutableTreeNode my_status = new DefaultMutableTreeNode("学生退宿申请查看");//主节点
        DefaultMutableTreeNode home_difficult = new DefaultMutableTreeNode("学生个人信息查看");//主节点
        DefaultMutableTreeNode Attendance = new DefaultMutableTreeNode("学生成绩管理");//主节点
        DefaultMutableTreeNode leave_application = new DefaultMutableTreeNode("请假信息查看/批准");//主节点
        /**
         * 请假部分代码
         */


        DefaultMutableTreeNode all_ = new DefaultMutableTreeNode("淄博职业学院学工系统");

        all_.add(my_status);
        all_.add(home_difficult);
        all_.add(Attendance);
        all_.add(leave_application);


        JTree tree = new JTree(all_);

        JFrame jf = new JFrame();
        jf.setTitle("学工系统");
        jf.setSize(1280, 720);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        System.out.println("当前账户为:" + account);

        //创建分割面板并把分滑动面板添加到分割面板里面
        JSplitPane hSplitPane = new JSplitPane();// 创建一个水平方向的分割面板
        hSplitPane.setLeftComponent(new JScrollPane(tree));// 在面板左侧添加一个组件

        JSplitPane vSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);// 创建一个垂直方向的分割面板
        //vSplitPane.setOneTouchExpandable(true);// 提供UI小部件
        hSplitPane.setRightComponent(vSplitPane);// 将垂直的分割面板添加到水平分割面板的右侧
        hSplitPane.setDividerSize(3);
        vSplitPane.setDividerSize(3);


        jf.add(hSplitPane);
        tree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode note = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            String t = note.toString();
            find_solution(t, account, vSplitPane, hSplitPane);
        });


        jf.setVisible(true);
    }

    /**
     * @param t          当前t值所代表所点击的树节点名称
     * @param account    当前账户账号
     * @param vSplitPane
     * @param hSplitPane
     */
    private void find_solution(String t, String account, JSplitPane vSplitPane, JSplitPane hSplitPane) {

        JPanel person_message_panel_bottom = new JPanel();

        JPanel my_status_panel_bottom = new JPanel();

        JPanel home_difficult_panel_bottom = new JPanel();

        JPanel Attendance_panel_bottom = new JPanel();
        hSplitPane.setDividerLocation(150);
        vSplitPane.setDividerLocation(80);

        switch (t) {
            case "学生成绩管理":
                try {
                    person_message_panel(account, person_message_panel_bottom, vSplitPane);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "学生个人信息查看":
                my_status_panel(account, my_status_panel_bottom, vSplitPane, hSplitPane);
                break;
            case "请假信息查看/批准":
                home_difficult_panel(account, home_difficult_panel_bottom, vSplitPane, hSplitPane);
                break;
            case "学生退宿申请查看":
                Attendance_panel(account, Attendance_panel_bottom, vSplitPane, hSplitPane);
                break;


            default:

                System.out.println("无\t" + t);

        }

    }


    /**
     * @param account    当前账户对象 直接运行时对象为123
     * @param vSplitPane 水平面板
     * @param hSplitPane 垂直面板
     */

    private void Attendance_panel(String account, JPanel attendance_panel_bottom, JSplitPane vSplitPane, JSplitPane hSplitPane) {
        attendance_panel_bottom.setBackground(new Color(88, 220, 13, 255));
        vSplitPane.setTopComponent(new JScrollPane(person_message_panel_top));
        vSplitPane.setBottomComponent(new JScrollPane(attendance_panel_bottom));

    }

    /**
     * @param account    当前账户对象 直接运行时对象为123
     * @param vSplitPane 水平面板
     * @param hSplitPane 垂直面板
     */

    private void home_difficult_panel(String account, JPanel home_difficult_panel_bottom, JSplitPane vSplitPane, JSplitPane hSplitPane) {

        home_difficult_panel_bottom.setBackground(new Color(255, 196, 0, 255));
        vSplitPane.setTopComponent(new JScrollPane(person_message_panel_top));
        vSplitPane.setBottomComponent(new JScrollPane(home_difficult_panel_bottom));
    }

    /**
     * @param account    当前账户对象
     * @param vSplitPane 水平面板
     * @param hSplitPane 垂直面板
     */
    private void my_status_panel(String account, JPanel my_status_panel_bottom, JSplitPane vSplitPane, JSplitPane hSplitPane) {

        my_status_panel_bottom.setBackground(new Color(0, 246, 232, 255));
        vSplitPane.setTopComponent(new JScrollPane(person_message_panel_top));
        vSplitPane.setBottomComponent(new JScrollPane(my_status_panel_bottom));
        my_status_panel_bottom.setLayout(null);

    }

    /**
     * @param account    当前账户对象
     * @param vSplitPane 水平分割面板
     */
    private void person_message_panel(String account, JPanel person_message_panel_bottom, JSplitPane vSplitPane) throws SQLException {
        vSplitPane.setBottomComponent(new JScrollPane(person_message_panel_bottom));
        person_message_panel_bottom.setLayout(null);
        String[] columns = {"学号", "姓名", "课程名称", "成绩", "学年学期"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable scoreTable = new JTable(tableModel);
        scoreTable.setFont(new Font("宋体", Font.LAYOUT_LEFT_TO_RIGHT, 16));
        scoreTable.setRowHeight(30);
        DefaultTableCellRenderer tableCell = new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isselected, boolean hasfocus,
                                                           int row, int column) {
                if (row % 2 == 0) {
                    setBackground(new Color(238, 255, 255));
                } else {
                    setBackground(new Color(204, 255, 187));
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

        tableJScrollPane.setSize(1000, 400);
        tableJScrollPane.setLocation(0, 100);

        tableJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        tableJScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        person_message_panel_bottom.add(tableHeader);
        person_message_panel_bottom.add(tableJScrollPane);

        tableHeader.setSize(1000, 50);
        tableHeader.setLocation(0, 50);
        JButton btn = new JButton("添加成绩");
        btn.setSize(120, 30);
        btn.setLocation(0, 520);

        person_message_panel_bottom.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame_Dome1.INT();
                Frame_Dome1.btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (Frame_Dome1.cj.getText().trim().equals("") || Frame_Dome1.xh.getText().trim().equals("") || Frame_Dome1.xk.getText().trim().equals("") || Frame_Dome1.xm.getText().trim().equals("") || Frame_Dome1.xq.getText().trim().equals("")) {
                            JOptionPane.showMessageDialog(null, "请您补全信息");
                        } else {

                            try {
                                InsertValue();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }

                        }
                    }
                });
            }
        });


        person_message_panel_bottom.add(tableJScrollPane);


        System.out.println(123);
        ConSQL();

        System.out.println(456);

        if (szxy!=null){szxy.removeAllItems();}
        szxy = new JComboBox(Array.toArray(new String[Array.size()]));

        szxy.setSize(150, 30);
        szxy.setLocation(0, 0);

        szxy.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    tableModel.setRowCount(0);
                    String term = (String) szxy.getSelectedItem();
                    try {
                        SQL(term, tableModel);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
            }

            private void SQL(String term, DefaultTableModel tableModel) throws SQLException {
                if (term.length() > 0) {
                    Connection con = DriverManager.getConnection("jdbc:mysql://mysql.sqlpub.com:3306/jinlesql", "wangjinle",
                            "04cda692db5c6b23");
                    Statement stat = con.createStatement();
                    String sql = "select s.StuNO,s.StuName,CourseName,CourseScore,Term from stuscore left join stuinfo s on stuscore.StuNO = s.StuNo where Term=" + term + ";";
                    ResultSet rs = stat.executeQuery(sql);

                    while (rs.next()) {
                        //System.out.println(rs.getString("C1")+"\t"+rs.getString("C2")+"\t"+ rs.getString("C3")+"\t"+rs.getString("C4")+"\t"+rs.getString("C5"));
                        String RStuNo = rs.getString("StuNO");
                        String RStuName = rs.getString("StuName");
                        String CourseName = rs.getString("CourseName");
                        String CourseScore = rs.getString("CourseScore");
                        String Term = rs.getString("Term");
                        StuScore s = new StuScore(RStuNo, CourseName, CourseScore, Term);


                        strings = new String[]{RStuNo, RStuName, CourseName, CourseScore, Term};
                        tableModel.addRow(strings);
                        System.out.println(Term);
                    }


                    con.close();
                    stat.close();
                    con.close();
                }


            }
        });
        person_message_panel_bottom.add(szxy);
        //person_message_panel_bottom.add(tableHeader);
        person_message_panel_bottom.add(tableHeader);
        person_message_panel_bottom.add(tableCell);


    }

    private void InsertValue() throws SQLException {
        String xuehao = Frame_Dome1.xh.getText().trim();
        String xueke = Frame_Dome1.xk.getText().trim();
        String chengji = Frame_Dome1.cj.getText().trim();
        String xueqi = Frame_Dome1.xq.getText().trim();
        StuScore stuScore=new StuScore(xuehao,xueke,chengji,xueqi);
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
            sqlSession.insert("InsertSCO", stuScore);
            JOptionPane.showMessageDialog(null,"成功添加");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"添加失败");
            e.printStackTrace();
        }
        sqlSession.commit();
        sqlSession.close();
    }









    private void ConSQL() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://mysql.sqlpub.com:3306/jinlesql", "wangjinle", "04cda692db5c6b23");
        Statement stat = con.createStatement();
        String sql = "select Term from jinlesql.stuscore group by Term asc";
        ResultSet rs = stat.executeQuery(sql);


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
