package com.timesheet.controller;

import com.timesheet.mapper.MemberMapper;
import com.timesheet.pojo.WorkTime;
import com.timesheet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;


//@RolesAllowed({"ADMIN","MEMBER"})
@Controller
public class MemberController{
    UserService userService;
    Authentication auth;
    MemberMapper memberMapper;

    @Autowired
    public void setMemberMapper(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    private String redirect(){
        return "redirect:/login";
    }
    @RequestMapping("/login")
    private String login_page(HttpServletRequest request, Model m) throws Exception{
        auth = SecurityContextHolder.getContext().getAuthentication();
//        if (!auth.getPrincipal().equals("anonymousUser")) {
//            return "record_working";
//        }
        return "login";
    }

    @RequestMapping("/record_working")
    private String recordWork(Model model){
        auth = SecurityContextHolder.getContext().getAuthentication();
//        if(memberMapper!=null){
//            System.out.println("not null");
//            memberMapper.set_login_date(auth.getName());
//        }
//        memberMapper.set_login_date(auth.getName());
        model.addAttribute("username", auth.getName())
                .addAttribute("roles", auth.getAuthorities());

        System.out.println(auth.getName());
//        redirectAttributes.addAttribute("param", auth.getAuthorities().toString());
        return "record_working";
    }
    @RequestMapping("/record")
    private String insert(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") String date,
                          @RequestParam("start_time") @DateTimeFormat(pattern = "HH:mm") String start_time,
                          @RequestParam("end_time") @DateTimeFormat(pattern = "HH:mm") String end_time,
                          @RequestParam("platform") String platform,
                          @RequestParam("detail") String detail,
                          Model m) throws Exception {
        if(memberMapper!=null)
            System.out.println("not null member");
        if(userService!=null) {
            System.out.println("not null UserService");
            userService.new_work(auth.getName(), date, start_time, end_time, platform, detail);
        }
        m.addAttribute("insert","success");
        return "redirect:/record_working";
    }
    @RequestMapping("/register")
    private String register(Model m){
        return "register";
    }

}
