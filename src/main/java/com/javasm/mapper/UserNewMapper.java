package com.javasm.mapper;


import com.javasm.entity.UserNew;

import java.util.List;

public interface UserNewMapper {

    //根据id查询数据
    UserNew queryByUserNewId(Integer userId);

    //查询所有符合条件的数据
    List<UserNew> queryUserNew(UserNew userNew);
}
