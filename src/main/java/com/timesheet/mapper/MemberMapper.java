package com.timesheet.mapper;

import com.timesheet.pojo.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {

    //create member data
    @Insert("insert into memberaccount (NAME,PASSWORD) values (#{name},#{pw})")
    public void create(String name,String pw);

    //get member data
    @Select("select * from memberaccount where NAME= #{name} ")
    public Member getMemberID(String name);

    //抓取多筆資料時用
    @Select("select * from memberaccount where NAME = #{name}")
    public List<Member> listMembers(String name);

    //delete data
    @Delete("delete from memberaccount")
    public void delete(int id);

    //update password
    @Update("update memberaccount set PASSWORD = #{pw} where ID = #{id}")
    public void update_password(int id, String pw);

    //update login date
    @Update("update memberaccount set LAST_LOGIN = NOW() where ID = #{id}")
    public void set_login_date(int id);

    @Select("select * from memberaccount where ID = #{id} ")
    public Member get(int id);

    @Update("update memberaccount set NAME = #{name} where ID = #{id} ")
    public int update(String name ,int id);

}
