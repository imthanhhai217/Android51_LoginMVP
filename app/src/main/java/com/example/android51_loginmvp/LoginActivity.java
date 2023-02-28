package com.example.android51_loginmvp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    @BindView(R.id.edtUserName)
    EditText edtUserName;
    @BindView(R.id.edtPassword)
    EditText edtPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.btnRegister)
    Button btnRegister;
    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        ButterKnife.bind(this);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                login();
                break;

            case R.id.btnRegister:
                register();
                break;
        }
    }

    private void register() {
        String userName = edtUserName.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        loginPresenter.register(userName, password);
    }

    private void login() {
        String userName = edtUserName.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        loginPresenter.login(userName, password);
    }

    private void gotoHome() {
        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    public void loginSuccess() {
        Log.d("TAG", "loginSuccess: ");
        gotoHome();
    }

    @Override
    public void loginFailed() {
        Log.d("TAG", "loginFailed: ");
        Toast.makeText(this, "Login failed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUserNameError(String message) {
        edtUserName.setError(message);
    }

    @Override
    public void onPasswordError(String message) {
        edtPassword.setError(message);
    }

    @Override
    public void showLoading() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void registerSuccess(String userName) {
        Toast.makeText(this, "Register " + userName + " success ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerFailed() {

    }
}