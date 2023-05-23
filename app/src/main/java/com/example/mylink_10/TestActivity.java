package com.example.mylink_10;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mylink_10.util.HttpRequestUtil;

import java.net.MalformedURLException;
import java.net.URL;

public class TestActivity extends AppCompatActivity{
//
//    private TextView tv_test;
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test);
//        findViewById(R.id.btn_test).setOnClickListener(this);
//        tv_test = findViewById(R.id.tv_test);
//    }
//
//    @Override
//    public void onClick(View view) {
//        String res = "";
//        try {
//            res = HttpRequestUtil.sendHttpRequest("GET",null,5000,5000,new URL("https://www.bilibili.com"));
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//        tv_test.setText(res);
//    }
}