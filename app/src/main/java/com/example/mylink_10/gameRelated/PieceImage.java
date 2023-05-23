package com.example.mylink_10.gameRelated;

import android.graphics.Bitmap;

public class PieceImage {
    private int id;
    private Bitmap bm;

    public PieceImage(int id, Bitmap bm) {
        this.id = id;
        this.bm = bm;
    }

    public int getId() {
        return id;
    }

    public Bitmap getBm() {
        return bm;
    }
}
