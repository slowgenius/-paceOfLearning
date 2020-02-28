package com.slowgenius.jdbc;

import com.slowgenius.bean.User;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author slowgenius
 * @date 2/23/2020 11:37 PM
 * @description
 */
public class UpdateDemo {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/exercise?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true";

    static final String USER = "root";
    static final String PASSWORD = "123456";


    @Test
    public void updateDemo() {

        Connection conn = null;
        PreparedStatement pstmt = null;

        List<User> users = new ArrayList<>();

        try {
            //导包
            //注册驱动
            Class.forName(JDBC_DRIVER);


            //获取连接
            System.out.println("connection to database .........");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            //创建查询
            System.out.println("creating statement .........");


            String userName = "slowgenius";
            String sql = "update user set position_id = 2 where user_name = ?;";

            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            int i  = pstmt.executeUpdate();
            System.out.println("result = " + i);
            conn.commit();


            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
