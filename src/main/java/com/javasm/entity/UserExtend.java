package com.javasm.entity;

public class UserExtend {
    private String familyNmae;
    private User user;

    public UserExtend() {
    }

    public UserExtend(String familyNmae, User user) {
        this.familyNmae = familyNmae;
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserExtend{" +
                "familyNmae='" + familyNmae + '\'' +
                ", user=" + user +
                '}';
    }

    public String getFamilyNmae() {
        return familyNmae;
    }

    public void setFamilyNmae(String familyNmae) {
        this.familyNmae = familyNmae;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
