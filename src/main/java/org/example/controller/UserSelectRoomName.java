package org.example.controller;

import org.example.dao.RoomSelect;
import org.example.model.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserSelectRoomName {
    @RequestMapping("/userSelectRoomName")
    public String userSelectRoomName(String roomName, HttpSession session, Model model) {
        List<Room> list = new RoomSelect().selectRoomName(roomName);
        if(list.isEmpty()){
            model.addAttribute("errorMsg3", "无此教室！");
            return "userPage";
        }else {
            session.setAttribute("list",list);
            return "userPage";
        }
    }
}
