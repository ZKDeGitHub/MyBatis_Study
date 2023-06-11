package com.javasm.mapper;


import com.javasm.entity.UserNew;

import java.util.List;

public interface UserNewMapper {

    //根据id查询数据
    UserNew queryByUserNewId(Integer userId);

    //查询所有符合条件的数据
    List<UserNew> queryUserNew(UserNew userNew);

    //根据id修改数据
    void updateById(UserNew userNew);

    //插入单条数据
    void insertUserNew(UserNew userNew);

    //插入多条数据
    void insertUserNewList(List<UserNew> userNewList);

    //删除单条数据
    void deleteUserNew(UserNew userNew);

    //根据id删除数据
    void deleteUserNewById(Integer userNewId);

    //根据id批量删除
    void deleteUserNewByIdList(List<Integer> idList);

    //查询用户（UserNew）和购物车（Cart）的数据
    List<UserNew> queryUserAndCart();
}
