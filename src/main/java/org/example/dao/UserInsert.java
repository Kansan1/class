package org.example.dao;



import org.example.util.CloseUtil;
import org.example.util.DbUtil;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Component
public class UserInsert {
    public int insert(String userName,String userPwd) {
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        try {
            conn = dbUtil.getConn();
            String sql = "insert into user values (null,?,?,?)";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, userName);
            pst.setString(2, userPwd);
            pst.setString(3, "1");
            return pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            new CloseUtil().close(conn);
        }
        return 0;
    }
}
