package one.ui;


import one.bean.User;
import one.component.BackGroundPanel;
import one.service.Service;
import one.service.ServiceIpl;
import one.util.PathUtils;
import one.util.ScreenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class MainInterface {
    public static final Logger LOGGER = LoggerFactory.getLogger(MainInterface.class);
    public static User USER ;

    static {
        LOGGER.error("\r ......................阿弥陀佛......................\n" +
                "                       _oo0oo_                      \n" +
                "                      o8888888o                     \n" +
                "                      88\" . \"88                     \n" +
                "                      (| -_- |)                     \n" +
                "                      0\\  =  /0                     \n" +
                "                   ___/‘---’\\___                   \n" +
                "                  .' \\|       |/ '.                 \n" +
                "                 / \\\\|||  :  |||// \\                \n" +
                "                / _||||| -卍-|||||_ \\               \n" +
                "               |   | \\\\\\  -  /// |   |              \n" +
                "               | \\_|  ''\\---/''  |_/ |              \n" +
                "               \\  .-\\__  '-'  ___/-. /              \n" +
                "             ___'. .'  /--.--\\  '. .'___            \n" +
                "         .\"\" ‘<  ‘.___\\_<|>_/___.’>’ \"\".          \n" +
                "       | | :  ‘- \\‘.;‘\\ _ /’;.’/ - ’ : | |        \n" +
                "         \\  \\ ‘_.   \\_ __\\ /__ _/   .-’ /  /        \n" +
                "    =====‘-.____‘.___ \\_____/___.-’___.-’=====     \n" +
                "                       ‘=---=’                      \n" +
                "                                                    \n" +
                "....................佛祖保佑 ,永无BUG...................");
        LOGGER.error("用户打开系统");
    }

    JFrame jf = new JFrame("学工系统登录");

    final int WIDTH = 500;
    final int HEIGHT = 300;

    //组装视图
    public void init() throws IOException {
        //设置窗口相关的属性
        jf.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setResizable(false);

        jf.setIconImage(ImageIO.read(new File(PathUtils.getRealPath("ico.png"))));
        //设置窗口的内容

        BackGroundPanel bgPanel = new BackGroundPanel(ImageIO.read(new File(PathUtils.getRealPath("lg-bg4.jpg"))));
        bgPanel.setBounds(0, 0, WIDTH, HEIGHT);
        //组装登录相关的元素
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
        JPasswordField pField = new JPasswordField(15);

        pBox.add(pLabel);
        pBox.add(Box.createHorizontalStrut(20));
        pBox.add(pField);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //组装按钮
        Box btnBox = Box.createHorizontalBox();
        JButton loginBtn = new JButton("登录");
        JButton registBtn = new JButton("注册");

        loginBtn.addActionListener(e -> {
            String uFT = uField.getText();
            String pFT = pField.getText();
            Service s1 = new ServiceIpl();
            try {
                USER=s1.login(LOGGER,uFT,pFT,jf);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println(USER);

        });

        registBtn.addActionListener(e -> {
            //跳转到注册页面
            try {
                new RegisterInterface().init();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            //当前界面消失
            jf.dispose();
        });


        btnBox.add(loginBtn);
        btnBox.add(Box.createHorizontalStrut(100));
        btnBox.add(registBtn);

        vBox.add(Box.createVerticalStrut(50));
        vBox.add(uBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(pBox);
        vBox.add(Box.createVerticalStrut(40));
        vBox.add(btnBox);

        bgPanel.add(vBox);
        jf.add(bgPanel);
        jf.setVisible(true);
    }

    //客户端程序的入口
    public static void main(String[] args) {
        try {
            new MainInterface().init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
