package com.javasm;

import com.javasm.entity.User;
import com.javasm.entity.UserExtend;
import com.javasm.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private UserMapper userMapper;



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

        userMapper = sqlSession.getMapper(UserMapper.class);

        //userMapper.getClass()：c  lass com.sun.proxy.$Proxy9
        System.out.println("userMapper.getClass()：" + userMapper.getClass());

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
     * 根据id查询
     */
    @Test
    public void queryUserById(){
        System.out.println(userMapper.queryUserById(1));
    }

    /**
     * 按照年龄排序，查询所有的用户数据
     */
    @Test
    public void queryUserListOrderByAge(){
        List<User> userList = userMapper.queryUserListOrderByAge();
        userList.forEach(user -> System.out.println(user));
    }

    /**
     * 查询张姓user
     */
    @Test
    public void queryUserListByFamilyName(){
        List<User> UserList = userMapper.queryUserListByFamilyName("张");
        UserList.forEach(user -> System.out.println(user));
    }

    @Test
    public void queryUserListByFamilyNameAndAge(){
        User user = new User();
        user.setAge(18);
        UserExtend userExtend = new UserExtend("张",user);
        List<User> userList = userMapper.queryUserListByFamilyNameAndAge(userExtend);
        userList.forEach(user1 -> System.out.println(user1));
    }

    @Test
    public void queryUserListByFamilyNameAndAddress(){
        Map<String,String> map = new HashMap();
        map.put("familyName","张");
        map.put("address","河南");
        List<User> userList = userMapper.queryUserListByFamilyNameAndAddress(map);
        userList.forEach(user -> System.out.println(user));
    }

    @Test
    public void queryUserListByFamilyNameAndSex(){
        List<User> userList = userMapper.queryUserListByFamilyNameAndSex("小李子", "男");
        userList.forEach(user -> System.out.println(user));
    }
}
