package org.example.user;

import org.example.dao.Select;
import org.example.dao.UserInsert;
import org.example.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class Register {
    @RequestMapping("/register")
    public String register(HttpServletRequest req, Model model)  {
        String userName = req.getParameter("userName");
        String userPwd = req.getParameter("userPwd");
        String userPwd1 = req.getParameter("userPwd1");
        if (StringUtil.isNotEmpty(userName) && StringUtil.isNotEmpty(userPwd) && new Select().select(userName) == null && userPwd.equals(userPwd1)) {
            if (new UserInsert().insert(userName, userPwd) > 0) {
                return "/successPage";
            } else {
                model.addAttribute("errorMsg4", "注册错误");
                return "/registerPage";
            }
        } else {
            model.addAttribute("errorMsg4", "重复输入密码错误，请重新输入");
            return "/registerPage";
        }
    }
}

