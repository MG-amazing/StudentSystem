package one.ui;


import one.bean.User;
import one.component.*;

import one.util.PathUtils;
import one.util.ScreenUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class ManagerInterface {
    public User USER;
    JFrame jf = new JFrame("欢迎" + "进入系统");

    final int WIDTH = 1000;
    final int HEIGHT = 600;

    //组装视图
    public void init(User u) throws IOException {
        USER =u;
        JOptionPane.showMessageDialog(null,"欢迎"+u.getStuNO()+"进入系统");
        MainInterface.LOGGER.error(u.getUserName()+"登录系统");
        //
        System.out.println(u);
        //给窗口设置属性
        jf.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
        try {
            jf.setIconImage(ImageIO.read(new File(PathUtils.getRealPath("ico.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        jf.setResizable(false);


        //设置菜单栏
        JMenuBar jmb = new JMenuBar();
        JMenu jMenu = new JMenu("设置");
        JMenuItem m1 = new JMenuItem("切换账号");
        JMenuItem m2 = new JMenuItem("退出程序");
        m1.addActionListener(e -> {
            try {
                new MainInterface().init();
                jf.dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        m2.addActionListener(e -> System.exit(0));
        jMenu.add(m1);
        jMenu.add(m2);
        jmb.add(jMenu);

        jf.setJMenuBar(jmb);

        //设置分割面板
        JSplitPane sp = new JSplitPane();

        //支持连续布局
        sp.setContinuousLayout(true);
        sp.setDividerLocation(150);
        sp.setDividerSize(7);

        //设置左侧内容
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("系统管理");
        DefaultMutableTreeNode MyPersonalInformation = new DefaultMutableTreeNode("我的个人信息");
        DefaultMutableTreeNode MyStudentStatus = new DefaultMutableTreeNode("宿舍信息/退宿申请");
        DefaultMutableTreeNode FamilyFinancialHardshipApplication = new DefaultMutableTreeNode("我的家庭经济困难申请");
        DefaultMutableTreeNode MyAttendanceInformation = new DefaultMutableTreeNode("我的考勤信息");
        DefaultMutableTreeNode AttendanceInformation = new DefaultMutableTreeNode("我的请假申请");
        DefaultMutableTreeNode MyQualityDevelopmentEvaluation = new DefaultMutableTreeNode("我的质量发展评价");

        root.add(MyPersonalInformation);
        root.add(MyStudentStatus);
        root.add(FamilyFinancialHardshipApplication);
        root.add(MyAttendanceInformation);
        root.add(AttendanceInformation);
        root.add(MyQualityDevelopmentEvaluation);

        Color color = new Color(203, 220, 217);
        JTree tree = new JTree(root);
        MyRenderer myRenderer = new MyRenderer();
        myRenderer.setBackgroundNonSelectionColor(color);
        myRenderer.setBackgroundSelectionColor(new Color(140, 140, 140));
        tree.setCellRenderer(myRenderer);

        tree.setBackground(color);
        //设置当前tree
        tree.setSelectionRow(2);
        //当条目选中变化后，这个方法会执行
        tree.addTreeSelectionListener(e -> {
            //得到当前选中的结点对象
            Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();

            if (MyPersonalInformation.equals(lastPathComponent)) {
                sp.setRightComponent(MainPanel.INUI());
                sp.setDividerLocation(150);
            } else if (MyStudentStatus.equals(lastPathComponent)) {
                sp.setRightComponent(Z_PANEL.INUIN());
                sp.setDividerLocation(150);
            } else if (FamilyFinancialHardshipApplication.equals(lastPathComponent)) {
                sp.setRightComponent(new JLabel("本面板未开发"));
                sp.setDividerLocation(150);
            } else if (MyAttendanceInformation.equals(lastPathComponent)) {
                sp.setRightComponent(new JLabel("我的考勤信息..."));
                sp.setDividerLocation(150);
            } else if (AttendanceInformation.equals(lastPathComponent)) {
                sp.setRightComponent(NewPanel.INTUI());
                sp.setDividerLocation(150);
            } else if (MyQualityDevelopmentEvaluation.equals(lastPathComponent)) {
                try {
                    sp.setRightComponent(PANEL_DOME1.INUI());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                sp.setDividerLocation(150);
            }

        });
        sp.setRightComponent(PanelNEW.INUI());
        sp.setLeftComponent(tree);
        jf.add(sp);
        jf.setVisible(true);
    }


    //自定义结点绘制器
    private static class MyRenderer extends DefaultTreeCellRenderer {
        private ImageIcon rootIcon = null;
        private ImageIcon MyPersonalInformationIcon = null;
        private ImageIcon MyStudentStatusIcon = null;
        private ImageIcon FamilyFinancialHardshipApplicationIcon = null;
        private ImageIcon MyAttendanceInformationIcon = null;
        private ImageIcon AttendanceInformationIcon = null;
        private ImageIcon MyQualityDevelopmentEvaluationIcon = null;

        public MyRenderer() {
            rootIcon = new ImageIcon(PathUtils.getRealPath(""));
            MyPersonalInformationIcon = new ImageIcon(PathUtils.getRealPath(""));
            MyStudentStatusIcon = new ImageIcon(PathUtils.getRealPath(""));
            FamilyFinancialHardshipApplicationIcon = new ImageIcon(PathUtils.getRealPath(""));
            MyAttendanceInformationIcon = new ImageIcon(PathUtils.getRealPath(""));
            AttendanceInformationIcon = new ImageIcon(PathUtils.getRealPath(""));
            MyQualityDevelopmentEvaluationIcon = new ImageIcon(PathUtils.getRealPath(""));

        }

    }
}
