package com.javasm.mapper;

import com.javasm.entity.User;

public interface UserMapper {
    //根据id查询数据
    User queryUserById(Integer id);
}
