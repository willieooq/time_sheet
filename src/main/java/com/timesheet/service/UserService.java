package com.timesheet.service;

import com.timesheet.mapper.WorkTimeMapper;
import com.timesheet.pojo.WorkTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    WorkTimeMapper workTimeMapper;

    @Autowired
    private void setWorkTimeMapper(WorkTimeMapper workTimeMapper){
        this.workTimeMapper = workTimeMapper;
    }
    public void new_work(String username,String date,String start_time,String end_time,String platform,String detail){
        //sql time 格式處理
        start_time = start_time+":00";
        end_time = end_time+":00";
        //work time builder打包
        WorkTime workTime = new WorkTime().builder()
                .USER_ID(username)
                .DATE(java.sql.Date.valueOf(date))
                .START_TIME(java.sql.Time.valueOf(start_time))
                .END_TIME(java.sql.Time.valueOf(end_time))
                .PLATFORM(platform)
                .DETAIL(detail).build();
        try {
            System.out.println(workTime);
            //新增工作
            if(workTimeMapper!=null)
//            workTimeMapper.create(workTime);
                workTimeMapper.insert(workTime);
            else throw new NullPointerException("空指標") ;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
