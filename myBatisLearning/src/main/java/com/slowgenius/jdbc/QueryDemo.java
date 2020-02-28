package com.slowgenius.jdbc;

import com.slowgenius.bean.User;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author slowgenius
 * @date 2/23/2020 10:51 PM
 * @description
 */
public class QueryDemo {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/exercise?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true";

    static final String USER = "root";
    static final String PASSWORD = "123456";

    @Test
    public void QueryStatementDemo() {
        Connection conn = null;
        Statement stmt = null;

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
            stmt = conn.createStatement();

            String userName = "slowgenius";
            String sql = "select * from user where user_name = '" + userName + "'";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(stmt.toString());

            while (rs.next()) {
                System.out.println("==================");

                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("user_name"));
                user.setRealName(rs.getString("real_name"));
                user.setSex(rs.getInt("sex"));
                user.setMobile(rs.getString("mobile"));
                user.setEmail(rs.getString("email"));
                user.setNote(rs.getString("note"));
                user.setPositionId(rs.getInt("id"));
                System.out.println(user);
                users.add(user);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void QueryPreparedStatementDemo() {
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
            String sql = "select * from user where user_name = ?;";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            ResultSet rs = pstmt.executeQuery();
            System.out.println(pstmt.toString());

            while (rs.next()) {
                System.out.println("==================");

                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("user_name"));
                user.setRealName(rs.getString("real_name"));
                user.setSex(rs.getInt("sex"));
                user.setMobile(rs.getString("mobile"));
                user.setEmail(rs.getString("email"));
                user.setNote(rs.getString("note"));
                user.setPositionId(rs.getInt("id"));
                System.out.println(user);
                users.add(user);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
