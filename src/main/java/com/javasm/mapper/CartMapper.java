package com.javasm.mapper;

import com.javasm.entity.Cart;

import java.util.List;

public interface CartMapper {

    //查询Cart与CartItem
    List<Cart> queryCartAndCartItem();
}
