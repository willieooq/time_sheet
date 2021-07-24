package com.timesheet.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MemberController {
    @RequestMapping("/login_page")
    public String login_page(){
        return "login_page";
    }
    @RequestMapping("/hello")
    public String hello(Model m) {
        m.addAttribute("name", "thymeleaf");
        return "hello";
    }
}
