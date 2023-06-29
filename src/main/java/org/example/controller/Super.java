package org.example.controller;

import org.example.dao.RoomDelete;
import org.example.dao.RoomInsert;
import org.example.dao.RoomSelect;
import org.example.dao.RoomUpdate;
import org.example.model.Room;
import org.example.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class Super {
    @Autowired
    private RoomSelect roomSelect;
    @Autowired
    private RoomDelete roomDelete;
    @Autowired
    private RoomInsert roomInsert;
    @RequestMapping("/superDelete")
    public String SuperDelete(HttpServletRequest request) {
        String roomName = request.getParameter("roomName");
        if (StringUtil.isNotEmpty(roomName)) {
            if (roomDelete.delete(roomName) > 0) {
                return "successPage";  // 返回成功页面
            } else {
                return "errorPage";
            }
        } else {

            return "errorPage";   // 返回错误页面
        }
    }

    @RequestMapping("/superInsert")
    public String SuperInsert(HttpServletRequest request) {
        String roomName = request.getParameter("roomName");
        if (StringUtil.isNotEmpty(roomName) && roomSelect.selectRoomName(roomName).isEmpty()) {
            if (roomInsert.insert(roomName, null, 0, 0) > 0) {
                return "successPage";
            }
        } else {
            return "errorPage";
        }
        return "errorPage";
    }

    @RequestMapping("/superSelectAll")
    public String SuperSelectAll(HttpServletRequest request){
        List<Room> list= new RoomSelect().selectAll();
        HttpSession session=request.getSession();
        session.setAttribute("list",list);
        return "superPage";
    }
    @RequestMapping("/superSelectNotNull")
    public String SuperSelectNotNull(HttpServletRequest request){
        List<Room> list=new RoomSelect().selectNotNull();
        HttpSession session=request.getSession();
        session.setAttribute("list",list);
        return "superPage";
    }
    @RequestMapping("/superSelectNull")
    public String SuperSelectNull(HttpServletRequest request){
        List<Room> list=new RoomSelect().selectNull();
        HttpSession session=request.getSession();
        session.setAttribute("list",list);
        return "superPage";
    }
    @RequestMapping("/superSelectRoomName")
    public String SuperSelectRoomName(HttpServletRequest request){
        String roomName=request.getParameter("roomName");
        List<Room> list=new RoomSelect().selectRoomName(roomName);
        HttpSession session=request.getSession();
        session.setAttribute("list",list);
        return "superPage";
    }
}