package org.example.dao;


import org.example.model.Room;
import org.example.model.User;
import org.example.util.CloseUtil;
import org.example.util.DbUtil;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoomSelect {
    public List<Room> selectRoomName(String roomName) {
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        List<Room> list = new ArrayList<>();
        try {
            conn = dbUtil.getConn();
            //创建Sql命令
            String sql = "select * from room where roomName = ?";
            //创建Sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1,roomName);
            rs = ps.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setRoomID(rs.getInt("roomID"));
                room.setRoomName(rs.getString("RoomName"));
                room.setRoomEven(rs.getString("roomEven"));
                room.setRoomStart(rs.getLong("roomStart"));
                room.setRoomEnd(rs.getLong("roomEnd"));
                list.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new CloseUtil().close(conn);
        }
        return list;
    }


    public List<Room> selectAll() {
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        List<Room> list = new ArrayList<>();
        try {
            conn = dbUtil.getConn();
            //创建Sql命令
            String sql = "select * from room";
            //创建Sql命令对象
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setRoomID(rs.getInt("roomID"));
                room.setRoomName(rs.getString("RoomName"));
                room.setRoomEven(rs.getString("roomEven"));
                room.setRoomStart(rs.getLong("roomStart"));
                room.setRoomEnd(rs.getLong("roomEnd"));
                list.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new CloseUtil().close(conn);
        }
        return list;
    }

    public List<Room> selectNull() {
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        List<Room> list = new ArrayList<>();
        try {
            conn = dbUtil.getConn();
            //创建Sql命令
            String sql = "select * from room where roomStart = 0 and roomEnd = 0;";
            //创建Sql命令对象
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setRoomID(rs.getInt("roomID"));
                room.setRoomName(rs.getString("RoomName"));
                room.setRoomEven(rs.getString("roomEven"));
                room.setRoomStart(rs.getLong("roomStart"));
                room.setRoomEnd(rs.getLong("roomEnd"));
                list.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new CloseUtil().close(conn);
        }
        return list;
    }

    public List<Room> selectNotNull() {
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        List<Room> list = new ArrayList<>();
        try {
            conn = dbUtil.getConn();
            //创建Sql命令
            String sql = "select * from room where roomStart != 0 and roomEnd != 0;";
            //创建Sql命令对象
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setRoomID(rs.getInt("roomID"));
                room.setRoomName(rs.getString("RoomName"));
                room.setRoomEven(rs.getString("roomEven"));
                room.setRoomStart(rs.getLong("roomStart"));
                room.setRoomEnd(rs.getLong("roomEnd"));
                list.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new CloseUtil().close(conn);
        }
        return list;
    }
}
