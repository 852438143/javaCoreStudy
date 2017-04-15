package com.database;

import java.sql.*;

/**
 * Created by 85243 on 2017/4/5.
 */
public class DBConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test?user=root&password=123456";
        Statement stat =null;
        Connection conn = null;
        try {
            Class clazz =  Class.forName("com.mysql.jdbc.Driver");
            System.out.println(clazz);
            conn = DriverManager.getConnection(url);
            System.out.println(conn);
            stat = conn.createStatement();
            String  sql = "select * from person";
            System.out.println(stat.execute(sql));
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                String bir = rs.getString(3);
                System.out.println(id +" "+name+ " "+bir);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
