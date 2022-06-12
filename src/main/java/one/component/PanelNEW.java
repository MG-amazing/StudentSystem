package one.component;


import one.util.PathUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class PanelNEW {
    public static void main(String[] args) {
        INUI();
    }
    public static JPanel INUI() {
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
        p1.setBackground(Color.white);
        p1.setSize(700, 600);
        p1.setLocation(0, 0);
        p1.setLayout(null);
        login.setLocationRelativeTo(null);
        login.add(p1);//
        login.setResizable(false);//设置窗口大小不可变
        JButton button=new JButton();
        button.setSize(50,50);
        button.setLocation(80,90);
        button.setIcon(new ImageIcon(PathUtils.getRealPath("01.jpg")));
        //button.setBorderPainted(false);
        p1.add(button);
        JLabel label=new JLabel("我的宿舍信息");
        label.setSize(80,30);
        label.setLocation(70,140);
        p1.add(label);
        JButton bt1=new JButton();
        bt1.setSize(50,50);
        bt1.setLocation(160,90);
        bt1.setIcon(new ImageIcon(PathUtils.getRealPath("02.jpg")));

        p1.add(bt1);
        JLabel l1=new JLabel("床位调换申请");
        l1.setSize(80,30);
        l1.setLocation(150,140);
        p1.add(l1);

        JButton bt2=new JButton();
        bt2.setSize(50,50);
        bt2.setLocation(240,90);
        bt2.setIcon(new ImageIcon(PathUtils.getRealPath("03.jpg")));

        p1.add(bt2);
        JLabel l2=new JLabel("设备保修申请");
        l2.setSize(80,30);
        l2.setLocation(230,140);
        p1.add(l2);

        JButton bt3=new JButton();
        bt3.setSize(50,50);
        bt3.setLocation(320,90);
        bt3.setIcon(new ImageIcon(PathUtils.getRealPath("04.jpg")));

        p1.add(bt3);
        JLabel l3=new JLabel("退宿申请");
        l3.setSize(80,30);
        l3.setLocation(320,140);
        p1.add(l3);

        JButton bt4=new JButton();
        bt4.setSize(50,50);
        bt4.setLocation(400,90);
        bt4.setIcon(new ImageIcon(PathUtils.getRealPath("05.jpg")));

        p1.add(bt4);
        JLabel l4=new JLabel("我的学籍");
        l4.setSize(80,30);
        l4.setLocation(400,140);
        p1.add(l4);

        JButton bt5=new JButton();
        bt5.setSize(50,50);
        bt5.setLocation(480,90);
        bt5.setIcon(new ImageIcon(PathUtils.getRealPath("06.jpg")));

        p1.add(bt5);
        JLabel l5=new JLabel("服兵役学费");
        l5.setSize(80,30);
        l5.setLocation(470,140);
        p1.add(l5);

        JButton bt7=new JButton();
        bt7.setSize(50,50);
        bt7.setLocation(80,180);
        bt7.setIcon(new ImageIcon(PathUtils.getRealPath("07.jpg")));

        p1.add(bt7);
        JLabel l7=new JLabel("个人荣誉");
        l7.setSize(80,30);
        l7.setLocation(80,230);
        p1.add(l7);

        JButton b8=new JButton();
        b8.setSize(50,50);
        b8.setLocation(160,180);
        b8.setIcon(new ImageIcon(PathUtils.getRealPath("08.jpg")));

        p1.add(b8);
        JLabel l8=new JLabel("个人荣誉");
        l8.setSize(80,30);
        l8.setLocation(160,230);
        p1.add(l8);

        JButton b9=new JButton();
        b9.setSize(50,50);
        b9.setLocation(240,180);
        b9.setIcon(new ImageIcon(PathUtils.getRealPath("09.jpg")));

        p1.add(b9);
        JLabel l9=new JLabel("我的勤工");
        l9.setSize(80,30);
        l9.setLocation(240,230);
        p1.add(l9);

        JButton b10=new JButton();
        b10.setSize(50,50);
        b10.setLocation(320,180);
        b10.setIcon(new ImageIcon(PathUtils.getRealPath("10.jpg")));

        p1.add(b10);
        JLabel l10=new JLabel("工资发放情况");
        l10.setSize(80,30);
        l10.setLocation(308,230);
        p1.add(l10);
        JButton b11=new JButton();
        b11.setSize(50,50);
        b11.setLocation(400,180);
        b11.setIcon(new ImageIcon(PathUtils.getRealPath("11.jpg")));

        p1.add(b11);
        JLabel l11=new JLabel("班级管理");
        l11.setSize(80,30);
        l11.setLocation(400,230);
        p1.add(l11);


        JButton b12=new JButton();
        b12.setSize(50,50);
        b12.setLocation(480,180);
        b12.setIcon(new ImageIcon(PathUtils.getRealPath("12.jpg")));

        p1.add(b12);
        JLabel l12=new JLabel("班级管理");
        l12.setSize(80,30);
        l12.setLocation(480,230);
        p1.add(l12);



        //login.setVisible(true);//开发时用的到

        return p1;
    }

}
