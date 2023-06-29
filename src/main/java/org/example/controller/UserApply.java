package org.example.controller;

import org.example.dao.RoomDelete;
import org.example.dao.RoomInsert;
import org.example.dao.RoomSelect;
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
public class UserApply {
    @Autowired
    private RoomSelect roomSelect;
    @Autowired
    private RoomInsert roomInsert;
    @Autowired
    private RoomDelete roomDelete;
    @RequestMapping("/apply")
    public String userApply(HttpServletRequest req,  Model model){
        String roomName=req.getParameter("roomName");
        String year = req.getParameter("year");
        String month = req.getParameter("month");
        String day = req.getParameter("day");
        String startHour = req.getParameter("startHour");
        String startMinute = req.getParameter("startMinute");
        String endHour = req.getParameter("endHour");
        String endMinute = req.getParameter("endMinute");
        String message = req.getParameter("message");
        if(StringUtil.isNotEmpty(roomName)&&!new RoomSelect().selectRoomName(roomName).isEmpty()){
            if (IsInteger.isInteger(year) && IsInteger.isInteger(month) && IsInteger.isInteger(day) && IsInteger.isInteger(startHour) &&
                    IsInteger.isInteger(startMinute) && IsInteger.isInteger(endHour) && IsInteger.isInteger(endMinute) && new StringUtil().isNotEmpty(message)){

                String startTime = year+"-"+month+"-"+day+"-"+startHour+"-"+startMinute;
                String endTime = year+"-"+month+"-"+day+"-"+endHour+"-"+endMinute;
                Calendar startCalendar = Calendar.getInstance();
                Calendar endCalendar = Calendar.getInstance();
                try {
                    startCalendar.setTime(new SimpleDateFormat("yyyy-MM-dd-HH-mm").parse(startTime));
                    endCalendar.setTime(new SimpleDateFormat("yyyy-MM-dd-HH-mm").parse(endTime));
                    List<Room> list = roomSelect.selectRoomName(roomName);
                    if(startCalendar.getTimeInMillis() >= endCalendar.getTimeInMillis())  {
                        model.addAttribute("errorMsg", "结束时间必须晚于开始时间");

                    } else {
                        boolean flag = true;
                        for (int i = 0; i < list.size(); i ++) {
                            if(list.get(i).getRoomStart() != 0) {
                                if(startCalendar.getTimeInMillis() <= list.get(i).getRoomEnd() &&
                                        endCalendar.getTimeInMillis() >= list.get(i).getRoomStart()) {
                                    flag = false;
                                    model.addAttribute("errorMsg", "预约时间段已被占用");

                                }
                            }
                        }
                        if(flag) {
                            roomDelete.deleteNull(roomName);
                            roomInsert.insert(roomName,message,startCalendar.getTimeInMillis(),endCalendar.getTimeInMillis());
                            return "successPage";
                        }
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                model.addAttribute("errorMsg", "日期时间或预约信息参数格式错误");

            }

        } else {
            model.addAttribute("errorMsg", "房间不存在");

        }
        return "userPage";
            }

}

