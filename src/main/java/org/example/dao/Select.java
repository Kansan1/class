package org.example.dao;



import org.example.model.User;
import org.example.util.CloseUtil;
import org.example.util.DbUtil;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class Select {
    public User select(String userName) {
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = dbUtil.getConn();
            //创建Sql命令
            String sql = "select * from user where userName = ?";
            //创建Sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1,userName);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setUserID(rs.getInt("userID"));
                user.setUserName(rs.getString("userName"));
                user.setUserPwd(rs.getString("userPwd"));
                user.setUserPower(rs.getInt("userPower"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new CloseUtil().close(conn);
        }
        return user;
    }
}
