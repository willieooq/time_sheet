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
    public void new_work(String username,String date,String time,String platform,String detail){
        //sql time 格式處理
        time = time+":00";
        //work time builder打包
        WorkTime workTime = new WorkTime().builder()
                .userId(username)
                .date(java.sql.Date.valueOf(date))
                .Time(java.sql.Time.valueOf(time))
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
    //delete record
    public void deleteById(int id){
        workTimeMapper.deleteById(id);
    }
}
