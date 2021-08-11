package com.timesheet.mapper;

import com.timesheet.pojo.WorkTime;
import com.timesheet.utils.MyMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface WorkTimeMapper{

    //create member data
    @Insert("insert into work_time (UserId,Date,StartTime,EndTime,Platform,Detail) " +
            "values (#{userId},#{date},#{startTime},#{endTime},#{platform},#{detail})")
    void create(WorkTime record);
    //根據實體類不為null的欄位進行查詢,條件全部使用=號and條件
    List<WorkTime> select(WorkTime record);
    //全選
    @Select("select * from worktime")
    List<WorkTime> selectAll();
    @Select("select * from worktime order by USER_ID desc")
    List<WorkTime> listPages();
    //根據實體類不為null的欄位查詢總數,條件全部使用=號and條件
    int selectCount(WorkTime record);
    //根據主鍵進行查詢,必須保證結果唯一
    //單個欄位做主鍵時,可以直接寫主鍵的值
    //聯合主鍵時,key可以是實體類,也可以是Map
    WorkTime selectByPrimaryKey(Object key);
    //插入一條資料
    //支援Oracle序列,UUID,類似Mysql的INDENTITY自動增長(自動回寫)
    //優先使用傳入的引數值,引數值空時,才會使用序列、UUID,自動增長
    int insert(WorkTime record);
    //插入一條資料,只插入不為null的欄位,不會影響有預設值的欄位
    //支援Oracle序列,UUID,類似Mysql的INDENTITY自動增長(自動回寫)
    //優先使用傳入的引數值,引數值空時,才會使用序列、UUID,自動增長
    int insertSelective(WorkTime record);
    //根據實體類中欄位不為null的條件進行刪除,條件全部使用=號and條件
    int delete(WorkTime key);
    //通過主鍵進行刪除,這裡最多隻會刪除一條資料
    //單個欄位做主鍵時,可以直接寫主鍵的值
    //聯合主鍵時,key可以是實體類,也可以是Map
    int deleteByPrimaryKey(Object key);
    //根據主鍵進行更新,這裡最多隻會更新一條資料
    //引數為實體類
    int updateByPrimaryKey(WorkTime record);
    //根據主鍵進行更新
    //只會更新不是null的資料
    int updateByPrimaryKeySelective(WorkTime record);

}
