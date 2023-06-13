package com.javasm.mapper;

import com.javasm.entity.Cart;

import java.util.List;

public interface CartMapper {

    //查询Cart与CartItem
    List<Cart> queryCartAndCartItem();

    //根据id查询cart
    Cart queryCartById();
}
