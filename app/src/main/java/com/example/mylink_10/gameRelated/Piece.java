package com.example.mylink_10.gameRelated;

public class Piece {
    private int x, y;
    private boolean d;
    private PieceImage pieceImage;
    private int luX, luY; // left_up_X，屏幕实际像素点坐标

    public Piece(int x, int y) {
        setPos(x, y);
        d = false;
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPieceImage(PieceImage pieceImage) {
        this.pieceImage = pieceImage;
    }

    public void del() {
        d = true;
    }

    public void setLuX(int luX) {
        this.luX = luX;
    }

    public void setLuY(int luY) {
        this.luY = luY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLuX() {
        return luX;
    }

    public int getLuY() {
        return luY;
    }

    public boolean isDel() {
        return d;
    }

    public PieceImage getPieceImage() {
        return pieceImage;
    }

    public void cancelDel() {
        d = false;
    }
}
