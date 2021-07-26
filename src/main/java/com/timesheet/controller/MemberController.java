package com.timesheet.controller;

import com.timesheet.mapper.MemberMapper;
import com.timesheet.pojo.Member;
import com.timesheet.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MemberController {

    MemberMapper memberMapper;
    MemberService memberService;

    @Autowired
    public void setMemberMapper(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }
    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("/login_page")
    public String login_page(Model m) throws Exception{
        int id =1;
        Member member= memberMapper.get(id);
        m.addAttribute("m", member);
        return "login_page";
    }

    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam(value = "username")String username, @RequestParam(value = "password")String password) {
        memberService.login(username,password);
        return "redirect:login_page";
    }
    @ResponseBody
    @RequestMapping("/test")
    public Member test(){
        Member member = new Member();
        member.setId(90);
        member.setName("nm");
        return member;
    }
}
