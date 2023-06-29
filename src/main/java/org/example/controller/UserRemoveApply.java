package org.example.controller;
import org.example.dao.RoomSelect;
import org.example.dao.RoomUpdate;
import org.example.model.Room;
import org.example.util.IsInteger;
import org.example.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Controller
public class UserRemoveApply {
    @Autowired
    private RoomSelect roomSelect;
    @Autowired
    private RoomUpdate roomUpdate;

@RequestMapping("/userRemoveApply")
    public String userApply(HttpServletRequest req, Model model){
    String roomName=req.getParameter("roomName");
    String year=req.getParameter("year");
    String month = req.getParameter("month");
    String day = req.getParameter("day");
    String startHour = req.getParameter("startHour");
    String startMinute = req.getParameter("startMinute");
        if(StringUtil.isNotEmpty(roomName)) {
            List<Room> result = roomSelect.selectRoomName(roomName);
            if(!result.isEmpty()) {
                if(IsInteger.isInteger(year) && IsInteger.isInteger(month) && IsInteger.isInteger(day) &&
                        IsInteger.isInteger(startHour) && IsInteger.isInteger(startMinute)) {
                    String startTime = year+"-"+month+"-"+day+"-"+startHour+"-"+startMinute;
                    Calendar startCalendar = Calendar.getInstance();
                    try {
                        startCalendar.setTime(new SimpleDateFormat("yyyy-MM-dd-HH-mm").parse(startTime));
                        int updateResult = roomUpdate.update(roomName,startCalendar.getTimeInMillis());
                        if(updateResult > 0) {
                            model.addAttribute("errorMsg1", "预约成功！");
                        } else {
                            model.addAttribute("errorMsg1", "更新失败");
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else {
                    model.addAttribute("errorMsg1", "日期时间参数格式错误");
                }
            } else {
                model.addAttribute("errorMsg1", "房间不存在");
            }
        } else {
            model.addAttribute("errorMsg1", "请输入房间名");
        }
        return "userPage";
    }


}
