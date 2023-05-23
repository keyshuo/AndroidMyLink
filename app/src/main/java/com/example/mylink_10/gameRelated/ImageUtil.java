package com.example.mylink_10.gameRelated;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.mylink_10.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImageUtil {
    private static List<Integer> resValues = getResValues();
    private static Bitmap CHECKBOX;

    private static List<Integer> getResValues() {
        Field[] drawableFields = R.drawable.class.getFields();
        List<Integer> ret = new ArrayList<>();
        try {
            for(Field f: drawableFields) {
                if(f.getName().startsWith("m_p")) {
                    ret.add(f.getInt(R.drawable.class));
                }
            }
            return ret;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    } // 加载图片（获取所有图片资源值）

    public static List<Integer> selValues() {
        List<Integer> ret = new ArrayList<>();
        int n = GameConf.X * GameConf.Y / 2; // 选board大小的一半
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            ret.add(resValues.get(random.nextInt(resValues.size())));
        }
        ret.addAll(ret);
        return ret;
    }

    public static void attchImages(List<Piece> p, List<Integer> ids) {
        int i = 0;
        for(Integer id: ids) {
            Bitmap bm = BitmapFactory.decodeResource(GameConf.CONTEXT.getResources(), id);
            bm = Bitmap.createScaledBitmap(bm, GameConf.PIECE_WIDTH, GameConf.PIECE_HEIGHT, true);
            p.get(i).setPieceImage(new PieceImage(id, bm));
            i++;
        }
    } // 获取实际的Bitmap并添加到每个piece中

    public static Bitmap getCheck() {
        if(CHECKBOX == null) {
            CHECKBOX = BitmapFactory.decodeResource(GameConf.CONTEXT.getResources(), R.drawable.selected);
            CHECKBOX = Bitmap.createScaledBitmap(CHECKBOX, GameConf.PIECE_WIDTH, GameConf.PIECE_HEIGHT, true);
        }
        return CHECKBOX;
    } // 设置/返回选中框（的图片）

    public static void delCheckBox() {
        CHECKBOX = null;
    }
}
