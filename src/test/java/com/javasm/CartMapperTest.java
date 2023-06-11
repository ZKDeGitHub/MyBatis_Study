package com.javasm;

import com.javasm.entity.Cart;
import com.javasm.mapper.CartMapper;
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

public class CartMapperTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private CartMapper cartMapper;

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
        cartMapper = sqlSession.getMapper(CartMapper.class);
        System.out.println("UserNewMapper.getClass()：" + cartMapper.getClass());

    }

    @After
    public void after() throws IOException {
        // 资源关闭
        sqlSession.close();
        inputStream.close();
    }
    @Test
    public void queryUserAndCart(){
        List<Cart> cartList = cartMapper.queryCartAndCartItem();
        cartList.forEach(cart -> System.out.println(cart));
    }
}
