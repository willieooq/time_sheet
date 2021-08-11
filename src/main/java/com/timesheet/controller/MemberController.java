package com.timesheet.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.timesheet.mapper.MemberMapper;
import com.timesheet.pojo.WorkTime;
import com.timesheet.service.LoginService;
import com.timesheet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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
    private String recordWork(Model model){
        auth = SecurityContextHolder.getContext().getAuthentication();
        if(loginService!=null){
            System.out.println("not null login service");
            loginService.userLoginDate(auth.getName());
        }
        memberMapper.set_login_date(auth.getName());
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
    @RequestMapping("/select-delete")
    private String Select(WorkTime w,Model m)throws Exception{
        m.addAttribute("worktimes", userService.listByAll());
        return "select-delete";
    }
    //返回翻頁數據
    @ResponseBody
    @RequestMapping("getListPage")
    public String listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        m.addAttribute("worktimes", userService.listByAll());
        PageHelper.startPage(start,size,"id desc");
        List<WorkTime> cs=userService.listByAll();
        PageInfo<WorkTime> page = new PageInfo<>(cs);
        m.addAttribute("page", page);
        return "listCategory";
    }
    @ResponseBody
    @RequestMapping(value = "/getGoodsTypeList")
    public List<WorkTime> getGoodsTypeList(Model model,
                                           @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                                           @RequestParam(defaultValue="5",value="pageSize")Integer pageSize )throws Exception {
//        Map<String, Object> map = new HashMap<String, Object>();
        //為了程序的嚴謹性，判斷非空：
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
        model.addAttribute("pageInfo",pageInfo);
        // 呼叫業務邏輯,返回資料
        return userService.getList(pageNum,pageSize);
    }
    @RequestMapping("/deleteRecord")
    private String deleteRecord(){
        return "redirect:/select-delete";
    }
    @RequestMapping("/register")
    private String register(Model m){
        return "register";
    }

}
