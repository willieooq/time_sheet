package com.timesheet.service;

import com.github.pagehelper.PageHelper;
import com.timesheet.mapper.WorkTimeMapper;
import com.timesheet.pojo.WorkTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    WorkTimeMapper workTimeMapper;

    @Autowired
    private void setWorkTimeMapper(WorkTimeMapper workTimeMapper){
        this.workTimeMapper = workTimeMapper;
    }
    //新增工作
    public void new_work(String username,String date,String start_time,String end_time,String platform,String detail){
        //sql time 格式處理
        start_time = start_time+":00";
        end_time = end_time+":00";
        //work time builder打包
        WorkTime workTime = new WorkTime().builder()
                .userId(username)
                .date(java.sql.Date.valueOf(date))
                .startTime(java.sql.Time.valueOf(start_time))
                .endTime(java.sql.Time.valueOf(end_time))
                .platform(platform)
                .detail(detail).build();
        //新增工作
        try {
            System.out.println(workTime);
            //新增工作
            if(workTimeMapper!=null)
                workTimeMapper.create(workTime);
            else throw new NullPointerException("空指標") ;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //list all record
    public List<WorkTime> listByAll(){
        return workTimeMapper.selectAll();
    }
    public List<WorkTime> getList(int pageNum, int pageSize) throws Exception {
        //使用分頁外掛,核心程式碼就這一行
        PageHelper.startPage(pageNum, pageSize);
        // 獲取
        List<WorkTime> workTimes = workTimeMapper.selectAll();
        return workTimes;
    }
}
