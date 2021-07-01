package com.example.appcatrung;

public class LoginPresenter {
    private ILogin login;

    public LoginPresenter(ILogin login) {
        this.login = login;
    }
    public void onLogin(String username, String password){
        if(username.equals("Admin") && password.equals("123456")){
            login.onLoginSuccesfull("Login thanh cong");
        }
        else {
            login.onLoginError("Login khong thanh cong");
        }
    }
}
