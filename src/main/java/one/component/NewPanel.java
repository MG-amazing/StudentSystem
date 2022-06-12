package one.component;

import com.eltima.components.ui.DatePicker;
import one.service.MainService;
import one.service.MainServiceIpl;
import one.service.ServiceIpl;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class NewPanel {
    public static void main(String[] args) {
        INTUI();
    }

    public static JPanel INTUI() {
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
        //p1.setBackground(Color.white);
        p1.setSize(700, 600);
        p1.setLocation(0, 0);
        p1.setLayout(null);
        login.setLocationRelativeTo(null);
        login.add(p1);//
        login.setResizable(false);//设置窗口大小不可变
        JLabel l = new JLabel("日常请假申请");
        l.setSize(100, 30);
        l.setLocation(80, 50);
        p1.add(l);

        JLabel l1 = new JLabel("请假信息");
        l1.setLocation(110, 70);
        l1.setSize(100, 30);
        p1.add(l1);

        JLabel l2 = new JLabel("请假时间");
        l2.setLocation(120, 90);
        l2.setSize(100, 30);
        p1.add(l2);
        final DatePicker datepick;
        datepick = getDatePicker();
        datepick.setSize(130, 30);
        datepick.setLocation(180, 90);
        p1.add(datepick);

        JLabel l3 = new JLabel("销假时间");
        l3.setLocation(430, 90);
        l3.setSize(100, 30);
        p1.add(l3);
        final DatePicker datepick1;
        datepick1 = getDatePicker();
        datepick1.setSize(130, 30);
        datepick1.setLocation(490, 90);
        p1.add(datepick1);

        JLabel l4 = new JLabel("请假事由");
        l4.setSize(80, 30);
        l4.setLocation(120, 120);
        p1.add(l4);
        JButton button = new JButton("保存");
        button.setSize(70, 30);
        p1.add(button);

        JRadioButton qz = new JRadioButton("求职", true);
        qz.setSize(50, 20);
        qz.setLocation(180, 125);
        JRadioButton sx = new JRadioButton("实习", false);
        sx.setSize(50, 20);
        sx.setLocation(230, 125);
        JRadioButton fj = new JRadioButton("返家", false);
        fj.setSize(50, 20);
        fj.setLocation(280, 125);
        JRadioButton px = new JRadioButton("培训", false);
        px.setSize(50, 20);
        px.setLocation(330, 125);

        JRadioButton wc = new JRadioButton("外出", false);
        wc.setSize(50, 20);
        wc.setLocation(380, 125);
        JRadioButton bj = new JRadioButton("病假", false);
        bj.setSize(50, 20);
        bj.setLocation(430, 125);

        ButtonGroup bg = new ButtonGroup();
        bg.add(qz);
        bg.add(sx);
        bg.add(fj);
        bg.add(px);
        bg.add(wc);
        bg.add(bj);

        p1.add(qz);
        p1.add(sx);
        p1.add(fj);
        p1.add(px);
        p1.add(wc);
        p1.add(bj);

        JLabel l5 = new JLabel("请假理由");
        l5.setLocation(120, 200);
        l5.setSize(80, 30);
        p1.add(l5);
        JTextArea t1 = new JTextArea();
        t1.setColumns(33);
        t1.setRows(10);
        t1.setLineWrap(true);
        t1.setSize(400, 170);
        t1.setLocation(170, 150);

        JLabel l6 = new JLabel("外出地点");
        l6.setSize(80, 30);
        l6.setLocation(120, 340);
        p1.add(l6);
        JTextField wcdd = new JTextField(50);
        wcdd.setSize(400, 30);
        wcdd.setLocation(170, 340);
        p1.add(wcdd);

        p1.add(t1);
        button.addActionListener(new ActionListener() {
            void getText() {
                String StuNO = ServiceIpl.USER.getStuNO();
                String askStart = datepick.getText();
                String askEnd = datepick1.getText();
                String info = "";
                //通过面板属性名获取到该面板上的所有组件
                System.out.println(info);
                for (Component c : p1.getComponents()) {
                    if (c instanceof JRadioButton) {
                        if (((JRadioButton) c).isSelected()) {
                            info += ((JRadioButton) c).getText();
                        }
                    }
                }
                String askType = info;
                String askReason = t1.getText().trim();
                String askDestination = wcdd.getText().trim();
                MainService service = new MainServiceIpl();
                System.out.println(askDestination);
                try {
                    service.AddData(StuNO, askStart, askEnd, askType, askReason, askDestination);
                } catch (ParseException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void actionPerformed(ActionEvent e) {
                getText();
            }
        });


        //login.setVisible(true);//开发时用的到

        return p1;
    }

    private static DatePicker getDatePicker() {
        final DatePicker datepick;
        // 格式
        String DefaultFormat = "yyyy-MM-dd HH:mm ";
        // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        Dimension dimension = new Dimension(177, 24);

        int[] hilightDays = {1, 3, 5, 7};

        int[] disabledDays = {};

        datepick = new DatePicker(date, DefaultFormat, font, dimension);

        datepick.setLocation(137, 83);
        datepick.setBounds(137, 83, 177, 24);
        // 设置一个月份中需要高亮显示的日子
        datepick.setHightlightdays(hilightDays, Color.red);
        // 设置一个月份中不需要的日子，呈灰色显示
        datepick.setDisableddays(disabledDays);
        // 设置国家
        datepick.setLocale(Locale.CHINA);
        // 设置时钟面板可见
        datepick.setTimePanleVisible(true);
        return datepick;
    }
}
