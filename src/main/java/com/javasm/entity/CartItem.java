package com.javasm.entity;


public class CartItem {

  private String cartItemId;
  private String cartId;
  private String prodId;
  private long prodNum;
  private double prodMoney;



  public String getCartItemId() {
    return cartItemId;
  }

  public void setCartItemId(String cartItemId) {
    this.cartItemId = cartItemId;
  }


  public String getCartId() {
    return cartId;
  }

  public void setCartId(String cartId) {
    this.cartId = cartId;
  }


  public String getProdId() {
    return prodId;
  }

  public void setProdId(String prodId) {
    this.prodId = prodId;
  }


  public long getProdNum() {
    return prodNum;
  }

  public void setProdNum(long prodNum) {
    this.prodNum = prodNum;
  }


  public double getProdMoney() {
    return prodMoney;
  }

  public void setProdMoney(double prodMoney) {
    this.prodMoney = prodMoney;
  }

  @Override
  public String toString() {
    return "CartItem{" +
            "cartItemId='" + cartItemId + '\'' +
            ", cartId='" + cartId + '\'' +
            ", prodId='" + prodId + '\'' +
            ", prodNum=" + prodNum +
            ", prodMoney=" + prodMoney +
            '}';
  }
}
