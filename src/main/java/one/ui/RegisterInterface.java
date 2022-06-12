package one.ui;


import one.code.Code;
import one.component.BackGroundPanel;

import one.service.Service;
import one.service.ServiceIpl;
import one.util.PathUtils;
import one.util.ScreenUtils;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class RegisterInterface {
    JFrame jf = new JFrame("注册");

    final int WIDTH = 500;
    final int HEIGHT = 400;


    //组装视图
    public void init() throws Exception {
        //设置窗口的属性
        jf.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setResizable(false);
        jf.setIconImage(ImageIO.read(new File(PathUtils.getRealPath("ico.png"))));

        BackGroundPanel bgPanel = new BackGroundPanel(null);
        bgPanel.setBounds(0, 0, WIDTH, HEIGHT);


        Box vBox = Box.createVerticalBox();

        //组装用户名
        Box uBox = Box.createHorizontalBox();
        JLabel uLabel = new JLabel("用户名：");
        JTextField uField = new JTextField(15);

        uBox.add(uLabel);
        uBox.add(Box.createHorizontalStrut(20));
        uBox.add(uField);

        //组装密码
        Box pBox = Box.createHorizontalBox();
        JLabel pLabel = new JLabel("密    码：");
        JTextField pField = new JTextField(15);

        pBox.add(pLabel);
        pBox.add(Box.createHorizontalStrut(20));
        pBox.add(pField);

        //组装手机号
        Box tBox = Box.createHorizontalBox();
        JLabel tLabel = new JLabel("手机号：");
        JTextField tField = new JTextField(15);

        tBox.add(tLabel);
        tBox.add(Box.createHorizontalStrut(20));
        tBox.add(tField);

        //组装性别
        Box gBox = Box.createHorizontalBox();
        JLabel gLabel = new JLabel("性    别：");
        JRadioButton maleBtn = new JRadioButton("男", true);
        JRadioButton femaleBtn = new JRadioButton("女", false);

        //实现单选的效果
        ButtonGroup bg = new ButtonGroup();
        bg.add(maleBtn);
        bg.add(femaleBtn);

        gBox.add(gLabel);
        gBox.add(Box.createHorizontalStrut(20));
        gBox.add(maleBtn);
        gBox.add(femaleBtn);
        gBox.add(Box.createHorizontalStrut(120));

        //组装验证码
        Box cBox = Box.createHorizontalBox();
        JLabel cLabel = new JLabel("验证码：");
        JTextField cField = new JTextField(4);
        int r1 = Code.getCode();
        int r2 = Code.getCode();
        int r3 = r1 + r2;

        JLabel c1 = new JLabel("  " + String.valueOf(r1));
        JLabel c4 = new JLabel("     +      ");
        JLabel c2 = new JLabel(String.valueOf(r2));
        JLabel c3 = new JLabel("     =      ");
        c1.setBackground(Color.white);
        c2.setBackground(Color.white);
        c4.setBackground(Color.white);
        c3.setBackground(Color.white);


        cBox.add(cLabel);
        cBox.add(c1);
        cBox.add(c4);
        cBox.add(c2);
        cBox.add(c3);
        cBox.add(Box.createHorizontalStrut(2));

        cBox.add(cField);


        //组装按钮
        Box btnBox = Box.createHorizontalBox();
        JButton registBtn = new JButton("注册");
        JButton backBtn = new JButton("返回登录页面");

        registBtn.addActionListener(new ActionListener() {
            String r = String.valueOf(r3);

            @Override
            public void actionPerformed(ActionEvent e) {
                //获取用户录入的信息
                String username = uField.getText().trim();
                String password = pField.getText().trim();
                String phone = tField.getText().trim();
                String gender = bg.isSelected(maleBtn.getModel()) ? maleBtn.getText() : femaleBtn.getText();
                String checkCode = cField.getText().trim();

                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);
                params.put("phone", phone);
                params.put("gender", gender);
                params.put("checkCode", checkCode);

                if (checkCode.equals(r)) {
                    //进入下一个条件判断
                    boolean flag;
                    //长度6-10位下划线 @ . 构成
                    boolean fl;
                    boolean flg;
                    flg = phone.matches("^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$");
                    fl = password.matches("^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9~!@&%#_]{8,16}$");
                    flag = username.matches("^[1-9][0-9]{6,10}");

                    if (flag) {
                        System.out.println("用户名格式正确");
                        if (fl) {
                            System.out.println("密码格式正确");
                            if (flg) {
                                //通过验证进入系统
                                Service regist=new ServiceIpl();
                                regist.regist(username,password);
                            } else {
                                JOptionPane.showMessageDialog(null, "您输入的手机号码格式不正确");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "您输入的" +
                                    "密码必须包含一" +
                                    "个大写字母和小" +
                                    "写字母且长度必须" +
                                    "在8-16位");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "用户名为数字且长度在6-10位");
                    }

                } else {
                    //给予用户提示
                    System.out.println(r);
                    System.out.println(checkCode);
                    JOptionPane.showMessageDialog(null, "您输入的验证码不正确,请重新输入");
                    //置空文本
                    cField.setText("");
                }
            }

        });

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //返回到登录页面即可
                try {
                    new MainInterface().init();
                    jf.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        btnBox.add(registBtn);
        btnBox.add(Box.createHorizontalStrut(80));
        btnBox.add(backBtn);

        vBox.add(Box.createVerticalStrut(50));
        vBox.add(uBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(pBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(tBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(gBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(cBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(btnBox);

        bgPanel.add(vBox);

        jf.add(bgPanel);

        jf.setVisible(true);
    }


}
