package com.example.android51_loginmvp;

import android.os.Handler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginPresenter {

    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void login(String userName, String password) {

        UserModel userModel = new UserModel();
        userModel.setUserName(userName);
        userModel.setPassword(password);

        if (userModel.checkLogin()) {
            loginView.loginSuccess();
        } else {
            loginView.loginFailed();
        }
    }

    public void register(String userName, String password) {
        loginView.showLoading();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginView.hideLoading();
                if (userName == null || userName.isEmpty() || userName.trim().length() == 0) {
                    loginView.onUserNameError("Username is blank");
                    return;
                }
                if (!validate(userName)) {
                    loginView.onUserNameError("Please insert email format");
                    return;
                }
                if (password == null || password.isEmpty() || password.trim().length() == 0) {
                    loginView.onPasswordError("Password is blank");
                    return;
                }
                if (password.length() <= 5) {
                    loginView.onPasswordError("Password > 5 characters");
                    return;
                }

                loginView.registerSuccess(userName);
            }
        }, 2000);
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }
}
