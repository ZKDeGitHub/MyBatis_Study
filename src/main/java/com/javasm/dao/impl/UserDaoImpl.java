package com.javasm.dao.impl;

import com.javasm.dao.UserDao;
import com.javasm.entity.User;
import org.apache.ibatis.session.SqlSession;

public class UserDaoImpl implements UserDao {

    //获取SqlSession对象
    private SqlSession sqlSession;
    public UserDaoImpl(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    public User quaryById(Integer id) {
        return sqlSession.selectOne("namespaceTest.selectById",id);
    }
}
