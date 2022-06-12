package one.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class NEWFRAME {
    public static JButton btn = new JButton("提交");
    public static JTextField field = new JTextField();
    public static JTextArea area = new JTextArea();

    public static void main(String[] args) {
        INT();
    }

    public static void INT() {
        JFrame frame = new JFrame();
        field.setSize(100, 30);
        field.setLocation(140, 500);
        frame.add(field);
        field.setText("请输入所在宿舍");
        frame.setSize(400, 700);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JLabel label = new JLabel("退宿申请理由");
        label.setSize(150, 30);
        label.setLocation(146, 30);
        frame.add(btn);
        btn.setSize(80, 30);
        btn.setLocation(146, 550);
        frame.add(label);

        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                field.setSelectionStart(0);
            }
        });

        area.setColumns(22);
        area.setLineWrap(true);
        area.setFont(new Font("宋体", Font.LAYOUT_RIGHT_TO_LEFT, 18));
        label.setFont(new Font("宋体", Font.LAYOUT_RIGHT_TO_LEFT, 18));
        area.setSize(380, 400);
        area.setLocation(1, 100);
        frame.add(area);


        frame.setVisible(true);
    }
}
