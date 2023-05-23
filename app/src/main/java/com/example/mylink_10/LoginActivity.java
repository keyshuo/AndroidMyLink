package com.example.mylink_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
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

import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String u = "https://www.baidu.com";
    private static final String loginUrl = "http://1.15.76.132:8080/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        findViewById(R.id.btn_login_in).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText et_account_login = findViewById(R.id.et_account_login);
        EditText et_pwd_login = findViewById(R.id.et_pwd_login);
        String account = et_account_login.getText().toString();
        String password = et_pwd_login.getText().toString();
        boolean emptyCondition = "".equals(account) || "".equals(password);
//        if (emptyCondition) {
//            ToastUtil.show(this, "请将所有信息填写完全！");
//        } else {
//            if (account.length() < 11) {
//                ToastUtil.show(this, "账号长度不足，请检查后重新输入！");
//                return;
//            }
//            if (password.length() < 6 || password.length() > 16) {
//                ToastUtil.show(this, "密码长度过短或过长，请检查后重新输入！");
//            }
//        }
        User user = new User();
        user.setAccount("614481987");
        user.setPassword("wx15015990723");
        String response = HttpRequestUtil.sendHttpRequest(RMethod.SyncPost, user, loginUrl);
        Log.d("Login",response);

//        Gson mGson = new Gson();
//        Result result = mGson.fromJson(response, Result.class);
//        Integer code = Integer.parseInt(result.getCode());
//        Log.d("TAG", response);
//        if (code.equals(Code.HTTP_OK)) {
//            ToastUtil.show(this, "注册成功！"+result.getData());
//        }
//        if (code.equals(Code.HTTP_ERR)) {
//            ToastUtil.show(this, "注册失败！详细信息如下：" + result.getError());
//            ToastUtil.show(this, response);
//        }
    }
}