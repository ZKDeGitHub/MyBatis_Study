package com.javasm.entity;


import java.util.Date;

public class UserNew {

  private long userId;
  private String userName;
  private java.util.Date userBirthday;
  private long userAge;
  private String userSex;
  private String userAddress;
  //实现一对一，在UserNew中添加Cart对象
  private Cart cart;

  public UserNew() {
  }

  public UserNew(String userName, long userAge) {
    this.userName = userName;
    this.userAge = userAge;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Date getUserBirthday() {
    return userBirthday;
  }

  public void setUserBirthday(Date userBirthday) {
    this.userBirthday = userBirthday;
  }

  public long getUserAge() {
    return userAge;
  }

  public void setUserAge(long userAge) {
    this.userAge = userAge;
  }

  public String getUserSex() {
    return userSex;
  }

  public void setUserSex(String userSex) {
    this.userSex = userSex;
  }

  public String getUserAddress() {
    return userAddress;
  }

  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
  }

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }

  @Override
  public String toString() {
    return "UserNew{" +
            "userId=" + userId +
            ", userName='" + userName + '\'' +
            ", userBirthday=" + userBirthday +
            ", userAge=" + userAge +
            ", userSex='" + userSex + '\'' +
            ", userAddress='" + userAddress + '\'' +
            ", cart=" + cart +
            '}';
  }
}
