package org.example.dao;


import org.example.util.CloseUtil;
import org.example.util.DbUtil;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Component
public class RoomUpdate {
    public int update(String roomName,long startTime) {
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        try {
            conn = dbUtil.getConn();

            String sql = "update room set roomEven = null,roomStart = 0 , roomEnd = 0 where roomName = ? and roomStart = ?";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, roomName);
            pst.setLong(2, startTime);
            return pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            new CloseUtil().close(conn);
        }
        return 0;
    }
}
