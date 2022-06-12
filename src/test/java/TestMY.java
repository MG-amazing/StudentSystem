import one.bean.Stuinfo;
import one.mapper.MainInterfaceMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMY {
    public static void main(String[] args) {
        //加载mybatis的核心配置文件,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SQLSession对象 执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取对应的UserMapper接口的代理对象

        MainInterfaceMapper userMapper = sqlSession.getMapper(MainInterfaceMapper.class);
        List<Stuinfo> users = userMapper.SelectStuInfo();

        //System.out.println(users);
    }
}
