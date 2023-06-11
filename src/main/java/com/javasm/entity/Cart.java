package com.javasm.entity;


import java.util.List;

public class Cart {

  private String cartId;
  private long userId;
  private long totalNum;
  private double totalMoney;

  //多对一关联之 在一的一方添加多的一方的集合;
  private List<CartItem> cartItemList;

  public String getCartId() {
    return cartId;
  }

  public void setCartId(String cartId) {
    this.cartId = cartId;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public long getTotalNum() {
    return totalNum;
  }

  public void setTotalNum(long totalNum) {
    this.totalNum = totalNum;
  }

  public double getTotalMoney() {
    return totalMoney;
  }

  public void setTotalMoney(double totalMoney) {
    this.totalMoney = totalMoney;
  }

  public List<CartItem> getCartItemList() {
    return cartItemList;
  }

  public void setCartItemList(List<CartItem> cartItemList) {
    this.cartItemList = cartItemList;
  }

  @Override
  public String toString() {
    return "Cart{" +
            "cartId='" + cartId + '\'' +
            ", userId=" + userId +
            ", totalNum=" + totalNum +
            ", totalMoney=" + totalMoney +
            ", cartItemList=" + cartItemList +
            '}';
  }
}
