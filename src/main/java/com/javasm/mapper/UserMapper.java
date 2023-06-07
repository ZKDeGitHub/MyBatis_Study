package com.javasm.mapper;

import com.javasm.entity.User;
import com.javasm.entity.UserExtend;

import java.util.List;

public interface UserMapper {

    //根据id查询数据
    User queryUserById(Integer id);

    //按照年龄排序，查询所有的用户数据
    List<User> queryUserListOrderByAge();

    //查询姓张的user
    List<User> queryUserListByFamilyName(String familyNmae);

    //根据姓名和年龄查询
    List<User> queryUserListByFamilyNameAndAge(UserExtend userExtend);
}
