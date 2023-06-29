package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    private String dbUrl = "jdbc:mysql://localhost:3306/mybatis?userSSL=false";
    private String dbUserName = "root";
    private String dbUserPwd = "gt040311";

    //获取数据库的连接
    public Connection getConn() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbUrl,dbUserName,dbUserPwd);
        return conn;
    }
}
