package org.example.user;

import org.example.dao.UserSelect;
import org.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Login {
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request) {
        String username = request.getParameter("userName");
        String password = request.getParameter("userPwd");

        User user=new UserSelect().select(username,password);
        ModelAndView modelAndView = new ModelAndView();

        if (user != null) {
            if (user.getUserPower() == 0) {
                modelAndView.setViewName("/superPage");
            } else {
                modelAndView.setViewName("/userPage");
            }
        } else {
            modelAndView.setViewName("/errorPage");
        }

        return modelAndView;
    }


}
