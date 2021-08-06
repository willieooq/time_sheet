package com.timesheet.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.RolesAllowed;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @RolesAllowed("ADMIN")
    @RequestMapping("/all")
    public String register(){
        return "register";
    }
}
