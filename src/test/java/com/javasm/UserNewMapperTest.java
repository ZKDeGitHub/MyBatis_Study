package com.javasm;

import com.javasm.entity.UserNew;
import com.javasm.mapper.UserMapper;
import com.javasm.mapper.UserNewMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserNewMapperTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private UserNewMapper userNewMapper;



    /**
     * 添加@Before注解：
     * 当前测试方法会在所有的测试方法执行之前执行
     * @throws IOException
     */
    @Before
    public void before() throws IOException {
        // 加载MyBatis的核心配置文件
        String resource = "mybatis-config.xml";

        // 把文件读取到了字节输入流
        inputStream = Resources.getResourceAsStream(resource);

        // 获取SqlSessionFactory对象,以便获取SqlSession对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession对象(辅助CRUD操作)
        // 参数设置为true时，增删改操作自动提交，查询忽略
        sqlSession = sqlSessionFactory.openSession(true);

        userNewMapper = sqlSession.getMapper(UserNewMapper.class);

        //userMapper.getClass()：class com.sun.proxy.$Proxy9
        System.out.println("UserNewMapper.getClass()：" + userNewMapper.getClass());

    }

    /**
     * 添加@After注解：
     * 当前测试方法会在所有的测试方法执行之后执行
     * @throws IOException
     */
    @After
    public void after() throws IOException {
        // 资源关闭
        sqlSession.close();
        inputStream.close();
    }
    @Test
    public void queryByUserNew(){
        System.out.println("user_new：" + userNewMapper.queryByUserNewId(1));
    }

    @Test
    public void queryUserNew(){
        UserNew userNew = new UserNew();
        userNew.setUserName("张");
        List<UserNew> userNewList = userNewMapper.queryUserNew(userNew);
        userNewList.forEach(user1 -> System.out.println(user1));
    }

}