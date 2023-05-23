package com.example.mylink_10.gameRelated;

public class MyNode {
    private int x, y; // 所在坐标
    private int cnt; // 已转折次数
    private int dir; // 方向
    private int step; // 步数
    private MyNode pre; // 上一个点

    public MyNode(int x, int y, int cnt, int dir, int step, MyNode pre) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.dir = dir;
        this.step = step;
        this.pre = pre;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getDir() {
        return dir;
    }

    public int getCnt() {
        return cnt;
    }

    public int getStep() {
        return step;
    }

    public MyNode getPre() {
        return pre;
    }
}
