package com.example.mylink_10.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mylink_10.pojo.User;

import java.sql.Connection;

public class UserDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "user.db";
    private static final int DB_VERSION = 1;
    private static final String TB_NAME = "user_info";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/user";
    private static final String USER = "";
    private static final String PASSWORD = "";
    private static Connection connection = null;
    private static UserDBHelper mDBHelper = null;
    private static SQLiteDatabase mRDB = null;
    private static SQLiteDatabase mWDB = null;

    public UserDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public SQLiteDatabase openReadLink() {
        if (mRDB == null || !mRDB.isOpen()) {
            mRDB = mDBHelper.getReadableDatabase();
        }
        return mRDB;
    }

    public SQLiteDatabase openWriteLink() {
        if (mWDB == null || !mWDB.isOpen()) {
            mWDB = mDBHelper.getWritableDatabase();
        }
        return mWDB;
    }

    public void closeLink() {
        if (mRDB != null && mRDB.isOpen()) {
            mRDB.close();
            mRDB = null;
        }
        if (mWDB != null && mWDB.isOpen()) {
            mWDB.close();
            mWDB = null;
        }
    }

    public static UserDBHelper getInstance(Context context) {
        if (mDBHelper == null) {
            mDBHelper = new UserDBHelper(context);
        }
        return mDBHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TB_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "user_name VARCHAR NOT NULL," +
                "password VARCHAR NOT NULL," +
                "age INTEGER NOT NULL," +
                "gender VARCHAR NOT NULL);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
//
//    public long insert(User user) {
//        ContentValues values = new ContentValues();
//        values.put("id",user.getId());
//        values.put("user_name",user.getUserName());
//        values.put("password",user.getPassword());
//        values.put("gender",user.getGender());
//        return mWDB.insert(TB_NAME,null,values);
//    }
//
//    public long deleteById(String userName) {
//        return mWDB.delete(TB_NAME,"user_name = ?",new String[] {userName});
//    }
}
