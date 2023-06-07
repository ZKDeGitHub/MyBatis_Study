package com.javasm;

import com.javasm.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserTest {
    private InputStream inputStream;
    private SqlSession sqlSession;


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

    /**
     * 根据id查询单个
     */
    @Test
    public void selectById(){
        User user = sqlSession.selectOne("namespaceTest.selectById", 1);
        System.out.println("user = " + user);
    }

    /**
     * 查询所有
     */
    @Test
    public void selectAllUser(){
        //查询所有的用户数据，并放入集合
        List<User> userList = sqlSession.selectList("namespaceTest.selectAllUser");

        //lamada表达式输出
        userList.forEach(user -> System.out.println(user));
    }

    /**
     * 插入
     */
    @Test
    public void insert(){
        User user = new User();
        user.setName("小李子");
        user.setAge(12);
        user.setAddress("青楼");
        user.setSex("男");
        sqlSession.insert("namespaceTest.addUser",user);
        //mybatis中是默认开启事务的，因此对表进行非查询操作需要提交事务
        sqlSession.commit();
        System.out.println("user = " + user);
    }

    /**
     * 修改
     */
    @Test
    public void updateById(){
        User user = new User();
        user.setId(28);
        user.setBirthday(new Date());
        user.setName("李桑");
        user.setAge(22);
        user.setAddress("勾栏");
        user.setSex("女");
        sqlSession.update("namespaceTest.updateById",user);
        sqlSession.commit();
    }

    /**
     * 删除
     */
    @Test
    public void deleteById(){
        sqlSession.delete("namespaceTest.deleteById",28);
    }
}
