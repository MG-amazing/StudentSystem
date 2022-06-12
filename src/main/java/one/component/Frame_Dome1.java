package one.component;

import javax.swing.*;
import java.awt.*;


public class Frame_Dome1 {
    public static JButton btn=new JButton("提交");

    public static JTextField xh=new JTextField();
    public static JTextField xm=new JTextField();
    public static JTextField xk=new JTextField();
    public static JTextField cj=new JTextField();
    public static JTextField xq=new JTextField();

    public static void main(String[] args) {
        INT();
    }

    public static void INT() {
        JFrame frame=new JFrame();

        frame.setSize(400,700);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JLabel label=new JLabel("成绩添加");
        label.setSize(150,30);
        label.setLocation(146,30);
        frame.add(btn);
        btn.setSize(80,30);
        btn.setLocation(146,550);
        frame.add(label);
        JLabel label1=new JLabel("学号");
        JLabel label2=new JLabel("姓名");
        JLabel label3=new JLabel("学科");
        JLabel label4=new JLabel("成绩");
        JLabel label5=new JLabel("学期");
        label1.setSize(80,30);
        label2.setSize(80,30);
        label3.setSize(80,30);
        label4.setSize(80,30);
        label5.setSize(80,30);
        label1.setLocation(100,100);
        label2.setLocation(100,200);
        label3.setLocation(100,300);
        label4.setLocation(100,400);
        label5.setLocation(100,500);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);


        label.setFont(new Font("宋体",Font.LAYOUT_RIGHT_TO_LEFT,18));

        label1.setFont(new Font("宋体",Font.LAYOUT_RIGHT_TO_LEFT,18));
        label2.setFont(new Font("宋体",Font.LAYOUT_RIGHT_TO_LEFT,18));
        label3.setFont(new Font("宋体",Font.LAYOUT_RIGHT_TO_LEFT,18));
        label4.setFont(new Font("宋体",Font.LAYOUT_RIGHT_TO_LEFT,18));
        label5.setFont(new Font("宋体",Font.LAYOUT_RIGHT_TO_LEFT,18));


        xh.setSize(120,30);
        xm.setSize(120,30);
        xk.setSize(120,30);
        cj.setSize(120,30);
        xq.setSize(120,30);
        xh.setLocation(180,100);
        xm.setLocation(180,200);
        xk.setLocation(180,300);
        cj.setLocation(180,400);
        xq.setLocation(180,500);
        frame.add(xh);
        frame.add(xm);
        frame.add(xk);
        frame.add(cj);
        frame.add(xq);

        frame.setVisible(true);
    }
}
