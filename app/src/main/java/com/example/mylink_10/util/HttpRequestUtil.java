package com.example.mylink_10.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mylink_10.pojo.RMethod;
import com.example.mylink_10.pojo.Result;
import com.example.mylink_10.pojo.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class HttpRequestUtil {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static String response = "";
    private static Gson mGson;
    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS).build();

//    private static Handler handler = new Handler() {
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//            Bundle data = msg.getData();
//            String value = data.getString("value");
////            response = value;
//        }
//    };

    /**
     * 发送HTTP请求
     *
     * @param method 请求方法
     * @param user   请求数据
     * @param url    请求地址
     * @return 响应数据
     */
    public static String sendHttpRequest(String method, User user, String url) {
        if (RMethod.SyncGet.equals(method)) {
            Request request = new Request.Builder().url(url).build();
            new Thread(() -> {
                try {
                    Thread.sleep(500);
                    Response response1 = okHttpClient.newCall(request).execute();
                    response = response1.body().string();
                    Log.d("IF",response);
                    response1.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
            Log.d("MTAG",response);
        }
        if (RMethod.ASyncGet.equals(method)) {

        }
        if (RMethod.SyncPost.equals(method)) {
            mGson = new Gson();
            String json = mGson.toJson(user);
            Log.d("JSON",json);
            RequestBody requestBody = RequestBody.create(JSON,json);
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();
            new Thread(() -> {
                try {
                    Response response1 = okHttpClient.newCall(request).execute();
                    response = response1.body().string();
                    Log.d("IF",response);
                    response1.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        if (RMethod.ASyncPost.equals(method)) {
        }
        return response;
    }

}

