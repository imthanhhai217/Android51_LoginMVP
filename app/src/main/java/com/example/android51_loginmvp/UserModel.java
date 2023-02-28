package com.example.android51_loginmvp;

public class UserModel {
    private String userName;
    private String password;

    public UserModel() {
    }

    public UserModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserModel{" + "userName='" + userName + '\'' + ", password='" + password + '\'' + '}';
    }

    public boolean checkLogin() {
        if (userName.equals("imthanhhai217@gmail.com") && password.equals("123456")) {
            return true;
        }
        return false;
    }
}
