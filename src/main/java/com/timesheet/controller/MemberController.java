package com.timesheet.controller;

import com.timesheet.mapper.MemberMapper;
import com.timesheet.pojo.Member;
import com.timesheet.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class MemberController extends SessionController{

    //TODO 測試用記得刪
    MemberMapper memberMapper;
    MemberService memberService;

    private Authentication auth;

    @Autowired
    public void setMemberMapper(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }
    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("/login")
    private String login_page(HttpServletRequest request, Model m) throws Exception{
//        auth = SecurityContextHolder.getContext().getAuthentication();
//        if (!auth.getPrincipal().equals("anonymousUser")) {
//            return "record_working";
//        }
        return "login";
    }

//    @RequestMapping("/doLogin")
    private String doLogin(Model model){
//        memberService.login(username,password);
//        auth = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("username", auth.getName())
//                .addAttribute("roles", auth.getAuthorities());
        return "redirect:record_working";
    }

    @RequestMapping("/record_working")
    private String recordWork(Model model){
//        auth = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("username", auth.getName())
//                .addAttribute("roles", auth.getAuthorities());
        return "record_working";
    }
    @ResponseBody
    @RequestMapping("/test")
    private Member test(){
        Member member = new Member();
        member.setId(90);
        member.setName("nm");
        return member;
    }
}
