package com.example.mylink_10.gameRelated;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.view.Display;

public class GameConf {
    public static int PIECE_WIDTH, PIECE_HEIGHT; // 方块大小
    public static int X, Y; // 行列数
    public static int START_X, START_Y; // board的起始位置
    public static Context CONTEXT;
    private static int screenWidth, screenHeight;
    private static float scale;
    private static int n; // 游戏难度

    public static void init(Activity a, Context context) {
        // 获取手机的信息，屏幕宽度高度等。。。
        CONTEXT = context;
        Display display = a.getWindowManager().getDefaultDisplay();
        Point siz = new Point();
        display.getSize(siz);
        screenWidth = siz.x;
        screenHeight = siz.y;
        scale = context.getResources().getDisplayMetrics().density;
        SharedPreferences sharedPreferences = context.getSharedPreferences("option-config", Context.MODE_PRIVATE);
        int dif = sharedPreferences.getInt("dif", 1);
        update(dif); // 默认难度是普通（0， 1， 2）
    }

    public static void update(int difficulty) {
        n = difficulty;
        setBoardSize(); // 设置行列数
        setPieceSize(); // 设置单个方块大小
        setStartPos(); // 设置整个board的左上角起始位置
        ImageUtil.delCheckBox(); // 更新一下选择框的大小
    }

    private static void setPieceSize() {
        if(n == 0) {
            PIECE_WIDTH = PIECE_HEIGHT = 50;
        } else if(n == 2) {
            PIECE_WIDTH = PIECE_HEIGHT = 40;
        } else {
            PIECE_WIDTH = PIECE_HEIGHT = 45;
        }
        PIECE_WIDTH = (int)(PIECE_WIDTH * scale + 0.5f);
        PIECE_HEIGHT = (int)(PIECE_HEIGHT * scale + 0.5f);
    }

    private static void setBoardSize() {
        if(n == 0) {
            X = 6;
            Y = 7;
        } else if(n == 2) {
            X = 8;
            Y = 9;
        } else {
            X = 7;
            Y = 8;
        }
    }

    private static void setStartPos() {
        START_X = (screenWidth - PIECE_WIDTH * X) / 2;
        START_Y = (screenHeight - PIECE_HEIGHT * Y) / 3;
    }
}
