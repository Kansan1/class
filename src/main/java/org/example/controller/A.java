package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class A {
    @RequestMapping("/")
    public String A(){
return "/index.jsp";
    }
    @RequestMapping("/tologin")
    public String Tologin(){
        return "/loginPage";
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register() {
        return "/registerPage"; // 视图名称
    }


}
