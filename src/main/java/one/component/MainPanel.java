package one.component;


import com.eltima.components.ui.DatePicker;
import one.service.MainService;
import one.service.MainServiceIpl;
import one.service.ProvinceCityConstant;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.ParseException;

import java.util.Date;
import java.util.Locale;


//个人信息维护面板
public class MainPanel  {

    private static JComboBox<String> areaCombo; // 区域名称组合框
    private static JComboBox<String> cityCombo; // 城市名称组合框
    private static JComboBox<String> provinceCombo; // 省份名称组合框

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
        p1.setSize(700, 600);
        p1.setLocation(0, 0);
        p1.setLayout(null);



        login.setLocationRelativeTo(null);
        JButton button=new JButton("保存");
        button.setSize(70,30);
        login.add(button);
        p1.add(button);
        JLabel l1=new JLabel("学生基本信息");
        l1.setSize(80,30);
        l1.setLocation(80,50);
        p1.add(l1);
        JLabel l2=new JLabel("学号");
        JTextField xh=new JTextField();
        xh.setSize(80,25);
        xh.setLocation(180,85);
        p1.add(xh);

        l2.setSize(80,30);
        l2.setLocation(150,80);
        p1.add(l2);
        JLabel l3=new JLabel("姓名");
        JTextField xm=new JTextField();
        xm.setSize(80,25);
        xm.setLocation(435,85);
        p1.add(xm);
        l3.setSize(80,30);
        l3.setLocation(400,80);
        p1.add(l3);
        JLabel gLabel = new JLabel("性    别：");
        gLabel.setSize(80,30);
        gLabel.setLocation(150,110);
        JRadioButton maleBtn = new JRadioButton("男", true);
        maleBtn.setSize(50,20);
        maleBtn.setLocation(200,115);
        JRadioButton femaleBtn = new JRadioButton("女", false);
        femaleBtn.setSize(50,20);
        femaleBtn.setLocation(250,115);
        ButtonGroup bg = new ButtonGroup();
        bg.add(maleBtn);
        bg.add(femaleBtn);




        p1.add(maleBtn);
        p1.add(femaleBtn);
        p1.add(gLabel);

        JLabel l4=new JLabel("出生日期");
        //防止出Bug所以这样写
        final DatePicker datepick;
        datepick = getDatePicker();
        datepick.setSize(100,30);
        datepick.setLocation(470,110);

        p1.add(datepick);



        l4.setSize(80,30);
        l4.setLocation(400,110);
        p1.add(l4);
        String mZ="汉族、蒙古族、回族、藏族、维吾尔族、苗族、彝族、壮族、布依族、朝鲜族、满族、侗族、瑶族、白族、土家族、哈尼族、哈萨克族、傣族、黎族、僳僳族、佤族、畲族、" +
                "高山族、拉祜族、水族、东乡族、纳西族、景颇族、柯尔克孜族、土族、达斡尔族; 仫佬族、羌族、布朗族、撒拉族、毛南族、仡佬族、锡伯族、阿昌族、普米族、塔吉克族、怒族、" +
                "乌孜别克族、俄罗斯族、鄂温克族、德昂族、保安族、裕固族、京族、塔塔尔族、独龙族、鄂伦春族、赫哲族、门巴族、珞巴族、基诺族。";
        String [] a = {"汉族","蒙古族","回族","藏族","维吾尔族","苗族","彝族","壮族","布依族","朝鲜族"};
        JComboBox<String> jcombo = new JComboBox<>(a);                                                //实例化下拉列 表

        JLabel l5=new JLabel("民族");
        l5.setSize(80,30);
        l5.setLocation(150,140);
        jcombo.setSize(80,30);
        jcombo.setLocation(400,140);

        p1.add(jcombo);
        p1.add(l5);
        JLabel l6=new JLabel("入学时间");
        l6.setSize(80,30);
        l6.setLocation(150,170);
        p1.add(l6);
        final DatePicker datepick2;
        datepick2 = getDatePicker();
        datepick2.setSize(100,30);
        datepick2.setLocation(210,170);
        p1.add(datepick2);
        JLabel jg=new JLabel("籍贯");
        jg.setSize(80,30);
        jg.setLocation(400,170);
        JTextField jgf=new JTextField();
        jgf.setSize(80,20);
        jgf.setLocation(430,175);
        p1.add(jgf);
        p1.add(jg);

        JLabel sYd=new JLabel("生源地");
        sYd.setSize(80,30);
        sYd.setLocation(150,210);

        initCombo();
        p1.add(provinceCombo);
        provinceCombo.setSize(100,30);
        provinceCombo.setLocation(210,210);
        p1.add(cityCombo);
        cityCombo.setSize(100,30);
        cityCombo.setLocation(320,210);
        p1.add(areaCombo);
        areaCombo.setSize(100,30);
        areaCombo.setLocation(430,210);

//        JComboBox s=new JComboBox(key1);
//        JComboBox s2=new JComboBox(values1);
//        s.setSize(80,30);
//        s.setSize(100,30);
//        s.setLocation(210,210);
//        s2.setSize(100,30);
//        s2.setLocation(400,210);
//        p1.add(s2);
//
//        p1.add(s);
        p1.add(sYd);
        JLabel k=new JLabel("本人电话:");
        k.setSize(80,30);
        k.setLocation(150,240);
        p1.add(k);
        JTextField dh=new JTextField();
        dh.setSize(100,25);
        dh.setLocation(220,245);
        p1.add(dh);
        JLabel m=new JLabel("电子邮件");
        m.setSize(80,30);
        m.setLocation(400,245);
        p1.add(m);
        JTextField yj=new JTextField();
        yj.setLocation(450,245);
        yj.setSize(100,30);
        p1.add(yj);
        JLabel xy=new JLabel("所在学院");
        xy.setSize(100,30);
        xy.setLocation(150,295);
        p1.add(xy);


        String []s1=new String[]{"人工智能与大数据学院"};
        String[]s4=new String[]{"人工智能技术应用P01","物联网技术应用P01",
                "物联网技术应用校企合作P01","物联网技术应用校企合作P02"};

        JComboBox<String> szxy=new JComboBox<>(s1);
        szxy.setSize(150,30);
        szxy.setLocation(205,295);
        p1.add(szxy);
        JLabel label=new JLabel("所在专业");
        label.setSize(80,30);
        label.setLocation(400,295);
        p1.add(label);
        JComboBox<String> szxy2=new JComboBox<>(s4);
        szxy2.setSize(170,30);
        szxy2.setLocation(450,295);
        p1.add(szxy2);
        button.addActionListener(new ActionListener() {
            void getText() throws ParseException {
                String stuNO= xh.getText().trim();
                String stuName=xm.getText().trim();
                String gender = bg.isSelected(maleBtn.getModel()) ? maleBtn.getText() : femaleBtn.getText();
                String csrq= String.valueOf(datepick.getText());
                String mz= (String) jcombo.getSelectedItem();
                String rx=String.valueOf(datepick2.getText());
                String jg=jgf.getText().trim();
                StringBuilder sb=new StringBuilder();
                String a1= (String) provinceCombo.getSelectedItem();
                String a2= (String) cityCombo.getSelectedItem();
                String a3= (String) areaCombo.getSelectedItem();
                sb.append(a1);
                sb.append("/");
                sb.append(a2);
                sb.append("/");
                sb.append(a3);
                String pdh=dh.getText().trim();
                String j= yj.getText().trim();
                String z= (String) szxy.getSelectedItem();
                String cl= (String) szxy2.getSelectedItem();
                String pro=cl.substring(0,cl.indexOf("P"));
                MainService service=new MainServiceIpl();
                try {
                    service.YanZheng(stuNO,stuName,gender,csrq,mz,rx,jg,sb,pdh,j,z,pro,cl);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getText();
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }



            }
        });












        login.add(p1);//
        login.setResizable(false);//设置窗口大小不可变


        //login.setVisible(true);//开发时用的到
        //login.setVisible(false);
        return p1;
    }

    private static DatePicker getDatePicker() {
        final DatePicker datepick;
        // 格式
        String DefaultFormat = "yyyy-MM-dd ";
        // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        Dimension dimension = new Dimension(177, 24);

        int[] hilightDays = { 1, 3, 5, 7 };

        int[] disabledDays = {  };

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





    /**
     * 组合框初始化方法
     */
    private static void initCombo(){
        areaCombo = new JComboBox<String>(); // 创建区域名称组合框

        for (int i = 0; i < ProvinceCityConstant.districts.get("北京市").length; i++) {
            areaCombo.addItem(ProvinceCityConstant.districts.get("北京市")[i]);
        } // 往组合框内添加相关内容

        cityCombo = new JComboBox<>(); // 创建城市名称组合框
        cityCombo.addItem("北京市");
        cityCombo.addItemListener(arg0 -> {
            String city = (String) cityCombo.getSelectedItem(); // 获取当前城市名称
            String[] districts = ProvinceCityConstant.districts.get(city); // 获取当前城市的区镇信息

            if (city != null) {
                areaCombo.removeAllItems(); // 清除组合框内的所有选项
                for (String district : districts) {
                    areaCombo.addItem(district);
                } // 添加区镇信息选项
            }
        }); // 添加选项更改监听器，当城市名称改变时，更改区镇组合框的信息

        provinceCombo = new JComboBox<String>(); // 创建省份名称组合框
        for (int i = 0; i < ProvinceCityConstant.provinces.length; i++) {
            provinceCombo.addItem(ProvinceCityConstant.provinces[i]);
        }
        provinceCombo.addItemListener(arg0 -> {
            String province = (String) provinceCombo.getSelectedItem(); // 获取当前省份名称
            String[] cities = ProvinceCityConstant.cities.get(province); //获取当前省份的城市信息

            if (province != null) {
                cityCombo.removeAllItems();
                for (String city : cities) {
                    cityCombo.addItem(city);
                }
            }
        }); // 添加选项更改监听器，当省份名称改变时，更改城市组合框的信息
    }




}
