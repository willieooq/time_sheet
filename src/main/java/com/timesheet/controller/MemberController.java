package com.timesheet.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.timesheet.mapper.MemberMapper;
import com.timesheet.pojo.WorkTime;
import com.timesheet.service.LoginService;
import com.timesheet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


//@RolesAllowed({"ADMIN","MEMBER"})
@Controller
public class MemberController{

    private UserService userService;
    private Authentication auth;
    private MemberMapper memberMapper;
    private LoginService loginService;

    @Autowired
    public void setMemberMapper(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("/")
    private String redirect(){
        return "redirect:/login";
    }
    @RequestMapping("/login")
    private String login_page(HttpServletRequest request, Model m) throws Exception{
        return "login";
    }

    @RequestMapping("/record_working")
    private String recordWork(Model m){
        auth = SecurityContextHolder.getContext().getAuthentication();
        if(loginService!=null){
            System.out.println("not null login service");
            loginService.userLoginDate(auth.getName());
        }
        memberMapper.set_login_date(auth.getName());
        m.addAttribute("username", auth.getName())
                .addAttribute("roles", auth.getAuthorities());

        System.out.println(auth.getName());
//        redirectAttributes.addAttribute("param", auth.getAuthorities().toString());
        return "record_working";
    }
    @RequestMapping("/record")
    private String insert(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") String date,
                          @RequestParam("time") @DateTimeFormat(pattern = "HH:mm") String time,
                          @RequestParam("platform") String platform,
                          @RequestParam("detail") String detail,
                          Model m) throws Exception {
        if(memberMapper!=null)
            System.out.println("not null member");
        if(userService!=null) {
            System.out.println("not null UserService");
            userService.new_work(auth.getName(), date, time, platform, detail);
        }
        m.addAttribute("insert","success");
        return "redirect:/record_working";
    }

    @RequestMapping("/LogBook")
    private String Select(WorkTime w,
                          Model m,
                          @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                          @RequestParam(defaultValue="5",value="pageSize")Integer pageSize )throws Exception{
        if(pageNum == null){
            pageNum = 1;   //設置默認當前頁
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 5;    //設置默認每頁顯示的數據數
        }

        //1.引入分頁插件,pageNum是第幾頁，pageSize是每頁顯示多少條,默認查詢總數count
        PageHelper.startPage(pageNum,pageSize);

        //2.緊跟的查詢就是一個分頁查詢-必須緊跟.後面的其他查詢不會被分頁，除非再次調用PageHelper.startPage
//        List<Map<String,Object>> leaveMessageList = leaveMessageService.list(map);

        //3.使用PageInfo包裝查詢後的結果,5是連續顯示的條數,結果list類型是Page<E>
        PageInfo pageInfo = new PageInfo(userService.listByAll(),pageSize);

        //4.使用model/map/model and view等帶回前端
        m.addAttribute("worktime",w);
        m.addAttribute("pageInfo",pageInfo);
        return "LogBook";
    }

    @RequestMapping("/callRecord")
    private ResponseEntity<String> callRecordPost(){
        System.out.println("callRecord");
        Map<String,Object> responseMap = new HashMap<String,Object>();
        responseMap.put("success",true);
        responseMap.put("workTimes",userService.listByAll());
        return new ResponseEntity(responseMap, HttpStatus.OK);
    }

    @RequestMapping("/deleteRecord")
    private String deleteRecord(RedirectAttributes redirectAttributes, @RequestParam(value = "Ids" ) Integer[] selectedId){
        try {
            for (int id : selectedId){
                userService.deleteById(id);
            }
            redirectAttributes.addFlashAttribute("success","Delete Success");
        }catch (Exception e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error","Delete Failed");
        }
        return "redirect:/LogBook";
    }
    @RequestMapping("/register")
    private String register(Model m){
        return "register";
    }

    @RequestMapping("/test")
    private String test(){
        return "test";
    }
}
