package com.example.mylink_10.gameRelated;

import android.graphics.Point;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    private Board b;
    private final int dx[] = {0, 0, -1, 1}, dy[] = {-1, 1, 0, 0};
    private boolean vis[][];
    private int step[][];

    public Game() {
        startNewGame();
    }

    public void startNewGame() {
        b = new Board();
        b.setBoard();
        vis = new boolean[GameConf.Y+2][GameConf.X+2];
        step = new int[GameConf.Y+2][GameConf.X+2];
    }

    public Board getBoard() {
        return b;
    }

    public Piece getDst(float x, float y) {
        int idxX = (int)(x - GameConf.START_X + GameConf.PIECE_WIDTH) / GameConf.PIECE_WIDTH;
        int idxY = (int)(y - GameConf.START_Y + GameConf.PIECE_HEIGHT) / GameConf.PIECE_HEIGHT;
        return getBoard().getPiece(idxX, idxY);
    }

    private boolean inBound(int x, int y) {
        if(x >= 0 && x < GameConf.X + 2 && y >= 0 && y < GameConf.Y + 2) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isBound(int x, int y) {
        if(inBound(x, y) && (x == 0 || x == GameConf.X + 1 || y == 0 || y == GameConf.Y + 1)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean inBoard(int x, int y) {
        if(x >= 1 && x <= GameConf.X && y >= 1 && y <= GameConf.Y) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEnd(int x, int y, Piece e) {
        if(e.getX() == x && e.getY() == y) {
            return true;
        } else {
            return false;
        }
    }

    public List<Point> getAccess(Piece s, Piece e) {
        if(!isSame(s, e) || s == e) {
            return null;
        }
        clearVis();
        clearStep();
        Queue<MyNode> q = new LinkedList<>();
        vis[s.getY()][s.getX()] = true;
        q.add(new MyNode(s.getX(), s.getY(), 0, -1, 0, null));
        LinkedList<MyNode> list = new LinkedList<>();
        while(!q.isEmpty()) {
            MyNode n = q.remove();
            list.add(n);
            Log.i("?", String.format("get (%d, %d)", n.getX(), n.getY()));
            if(isEnd(n.getX(), n.getY(), e)) {
                Log.i("?", "flag is true");
                s.del();
                e.del();
                return getTuringPoints(list);
            }
            for(int i = 0; i < 4; i ++) {
                int nx = n.getX() + dx[i];
                int ny = n.getY() + dy[i];
                if(inBound(nx, ny) && (n.getStep() + 1 <= step[ny][nx] || vis[ny][nx] == false)) {//优化路径用的，重复
                    if(isBound(nx, ny) || (inBoard(nx, ny) && getBoard().getPiece(nx, ny).isDel()) || isEnd(nx, ny, e)) {// 路径合法
                        vis[ny][nx] = true;
                        step[ny][nx] = n.getStep() + 1;
                        if(n.getDir() == i) {//没转向
                            q.add(new MyNode(nx, ny, n.getCnt(), i, n.getStep() + 1, n));
                        } else if(n.getCnt() + 1 <= 3) { // 转向并且转向次数没用完
                            q.add(new MyNode(nx, ny, n.getCnt() + 1, i, n.getStep() + 1, n));
                        }
                    }
                }
            }
        }
        return null;
    }

    private List<Point> getTuringPoints(LinkedList<MyNode> list) {
        // 根据每个节点的pre值找到路径，判断出转折点并保存
        MyNode node = list.get(list.size() - 1);
        int now = node.getDir();
        List<Point> ret = new ArrayList<>();
        ret.add(new Point(node.getX(), node.getY()));
        while(true) {
            if(node.getPre() == null) {
                break;
            }
            node = node.getPre();
            if(node.getDir() != now) {
                ret.add(new Point(node.getX(), node.getY()));//添加转折点
            }
            now = node.getDir();
        }
        return ret;
    }

    public void clearVis() {
        for(int i = 0; i < vis.length; i++) {
            for(int j = 0; j < vis[i].length; j++) {
                vis[i][j] = false;
            }
        }
    }

    public void clearStep() {
        for(int i = 0; i < step.length; i++) {
            for(int j = 0; j < step[i].length; j++) {
                step[i][j] = 1;
            }
        }
    }

    public boolean isSame(Piece p1, Piece p2) {
        return p1.getPieceImage().getId() == p2.getPieceImage().getId();
    }
}
