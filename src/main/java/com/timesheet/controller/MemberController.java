package com.timesheet.controller;

import com.timesheet.mapper.MemberMapper;
import com.timesheet.mapper.MemberRepo;
import com.timesheet.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;

@RolesAllowed({"ADMIN","MEMBER"})
@Controller
public class MemberController{

    UserService userService;
    private MemberMapper memberMapper;
    private Authentication auth;
    private MemberRepo memberRepo;

    @Autowired
    public void setMemberMapper(MemberMapper memberMapper){
        this.memberMapper = memberMapper;
    }
    @Autowired
    public void setMemberRepo(MemberRepo memberRepo){
        this.memberRepo = memberRepo;
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
    private String recordWork(RedirectAttributes redirectAttributes, Model model){
        auth = SecurityContextHolder.getContext().getAuthentication();
//        if(memberMapper!=null){
//            System.out.println("not null");
//            memberMapper.set_login_date(auth.getName());
//        }
//        memberMapper.set_login_date(auth.getName());
//        memberRepo.set_login_date(auth.getName());
        model.addAttribute("username", auth.getName())
                .addAttribute("roles", auth.getAuthorities());

        System.out.println(auth.getName());
//        redirectAttributes.addAttribute("param", auth.getAuthorities().toString());
        return "record_working";
    }

    @RequestMapping("/register")
    private String register(Model m){
        return "register";
    }

}
