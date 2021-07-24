package com.timesheet.member;

import org.apache.ibatis.annotations.Mapper;

import javax.sql.DataSource;
import java.util.List;

@Mapper
public interface MemberDAO {
    //初始化 database resource
    public void setDataSource(DataSource ds);
    //create member data
    public void create(String name,String password);
    //get member data
    public MemberBean getMemberID(String name);
    //抓取多筆資料時用
    public List<MemberBean> listMembers(String name);
    //delete data
    public void delete(int id);
    //update password
    public void update_password(int id, String pw);
    //update login date
    public void set_login_date(int id);
}
