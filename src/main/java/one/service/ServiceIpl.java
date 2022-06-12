package one.service;

import one.bean.User;


import one.ui.ManagerInterface;
import one.ui.mainFrame;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;

import java.util.List;

public class ServiceIpl implements Service {
    //当前登录用户
    public static User USER;
    public static boolean flag;

    public static List<User> ALL_USERS = new ArrayList<>();

    /**
     *
     * @param logger 日志
     * @param uFT 账号
     * @param pFT 密码
     * @param jf 当前面板
     * @return
     * @throws IOException
     */
    @Test
    public User login(Logger logger, String uFT, String pFT, JFrame jf) throws IOException {

        //加载mybatis的核心配置文件,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SQLSession对象 执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取对应的UserMapper接口的代理对象
        //MainInterfaceMapper userMapper = sqlSession.getMapper(MainInterfaceMapper.class);
        List<User>users=sqlSession.selectList("test.LoginVerification");
        ALL_USERS = users;
        User u = getUserByLoginName(uFT);
        if (u!=null){
            //判断用户名是否等于密码
            if (u.getUserPwd().equals(pFT)){
                USER=u;
                if (!u.getStuNO().equals("1")){
                    //指向普通用户
                    flag=true;
                    new ManagerInterface().init(u);
                    jf.dispose();
                }else {
                    //指向Root用户
                    mainFrame.setTure(u.getStuNO());
                    jf.dispose();
                    flag=false;
                }
            }else {
                JOptionPane.showMessageDialog(null,"密码错误!");
            }
        }else {
            JOptionPane.showMessageDialog(null,"用户名错误!");
        }

        sqlSession.close();
        return USER;
    }

    @Test
    public void regist(String uField, String pField) {
        User user=new User();
        user.setUserName(uField);
        user.setUserPwd(pField);
        user.setStuNO(uField);

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
            sqlSession.insert("Registration",user);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"用户已存在");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    private User getUserByLoginName(String uFT) {
        for (User allUser : ALL_USERS) {
            if (allUser.getStuNO().equals(uFT)) {
                return allUser;
            }
        }
        return null;
        //查无此账户
    }
}
