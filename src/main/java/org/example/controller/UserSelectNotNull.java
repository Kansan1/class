package org.example.controller;

import org.example.dao.RoomSelect;
import org.example.model.Room;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserSelectNotNull {
    @RequestMapping("/userSelectNotNull")
    public String userSelectNotNull(HttpServletRequest request){
        List<Room> list= new RoomSelect().selectNotNull();
        HttpSession session=request.getSession();
        session.setAttribute("list",list);
        return "userPage";
    }
}
