package com.example.mylink_10;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.mylink_10.pojo.Code;
import com.example.mylink_10.pojo.RMethod;
import com.example.mylink_10.pojo.Result;
import com.example.mylink_10.pojo.User;
import com.example.mylink_10.util.HttpRequestUtil;
import com.example.mylink_10.util.ToastUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.MalformedURLException;
import java.net.URL;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private static String u = "http://localhost:8080/user";
    private static String bai = "https://www.baidu.com";
    private static String registerUrl = "http://uwna3a.natappfree.cc/user";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        findViewById(R.id.btn_signup_sign).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText et_account_sign = findViewById(R.id.et_account_sign);
        EditText et_username_sign = findViewById(R.id.et_username_sign);
        EditText et_password_sign = findViewById(R.id.et_password_sign);
        EditText et_confirmPwd_sign = findViewById(R.id.et_confirmPwd_sign);
        String account = et_account_sign.getText().toString();
        String username = et_username_sign.getText().toString();
        String password = et_password_sign.getText().toString();
        String confirmPwd = et_confirmPwd_sign.getText().toString();
        boolean emptyCondition = "".equals(account) || "".equals(username) || "".equals(password) || "".equals(confirmPwd);
        boolean pwdDifference = !password.equals(confirmPwd);
        if (emptyCondition) {
            ToastUtil.show(this, "请将所有信息填写完全！");
        } /*else {
            if (account.length() < 11) {
                ToastUtil.show(this, "账号长度不足，请检查后重新输入！");
                return;
            }
            if (password.length() < 6 || password.length() > 16) {
                ToastUtil.show(this, "密码长度过短或过长，请检查后重新输入！");
                return;
            }
            if (pwdDifference) {
                ToastUtil.show(this, "两次密码不同，请检查后重新输入！");
            } */ else {
            User user = new User();
            user.setAccount(account);
            user.setUserName(username);
            user.setPassword(password);
            String response = HttpRequestUtil.sendHttpRequest(RMethod.SyncPost, user, registerUrl);
            ToastUtil.show(this, response);
            //TODO 根据返回码判断是否注册成功
//            Gson mGson = new Gson();
//            Result result = mGson.fromJson(response, Result.class);
//            Integer code = Integer.parseInt(result.getCode());
//            Log.d("MyTag", result.toString());
//            if (code.equals(Code.HTTP_OK)) {
//                ToastUtil.show(this, "注册成功！");
//            }
//            if (code.equals(Code.HTTP_ERR)) {
//                ToastUtil.show(this, "注册失败！详细信息如下：" + result.getError());
//                ToastUtil.show(this, response);
//            }
        }
    }
}