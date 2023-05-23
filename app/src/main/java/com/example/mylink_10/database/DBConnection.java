package com.example.mylink_10.database;

import com.example.mylink_10.pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/android";
    private static final String userName = "root";
    private static final String password = "password";
    private static Connection connection = null;
    private static final String driver = "com.mysql.jdbc.Driver";

    public DBConnection() {
        try {
            Class.forName(driver);
            connection = (Connection) DriverManager.getConnection(url,userName,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public boolean insert(User user) {
//        String sql = "insert into tb_user (user_name,password,gender) values (?,?,?)";
//        try {
//            PreparedStatement psmt = connection.prepareStatement(sql);
//            psmt.setString(1,user.getUserName());
//            psmt.setString(2,user.getPassword());
//            psmt.setString(3,user.getGender());
//            psmt.execute();
//            return true;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
