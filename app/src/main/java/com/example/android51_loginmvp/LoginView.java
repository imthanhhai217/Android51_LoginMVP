package com.example.android51_loginmvp;

public interface LoginView {

    void loginSuccess();

    void loginFailed();

    void onUserNameError(String message);

    void onPasswordError(String message);

    void showLoading();

    void hideLoading();

    void registerSuccess(String userName);

    void registerFailed();

}
