package com.javasm.mapper;

import com.javasm.entity.User;
import com.javasm.entity.UserExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //根据id查询数据
    User queryUserById(Integer id);

    //按照年龄排序，查询所有的用户数据
    List<User> queryUserListOrderByAge();

    //查询姓张的user
    List<User> queryUserListByFamilyName(String familyNmae);

    //根据姓名和年龄查询
    List<User> queryUserListByFamilyNameAndAge(UserExtend userExtend);

    //根据姓名和地址查询，参数为Map类型
    List<User> queryUserListByFamilyNameAndAddress(Map<String,String> param);

    //根据姓名和性别查询，参数设置为2个
    //MyBatis中，默认只能设置一个参数，若需要设置多个参数，使用@Param("")
    List<User> queryUserListByFamilyNameAndSex(@Param("userName") String name,@Param("userSex") String sex);


}
