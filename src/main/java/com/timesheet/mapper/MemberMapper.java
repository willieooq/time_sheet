package com.timesheet.mapper;

import com.timesheet.pojo.Member;
import com.timesheet.utils.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper extends MyMapper<Member> {

    //create member data
    @Insert("insert into member_account (Name,Password) values (#{name},#{pw})")
    public void create(String name,String pw);

    //get member data
    @Select("select * from member_account where Name= #{name} ")
    Optional<Member> findByName(String name);
    //抓取多筆資料時用
    @Select("select * from member_account where NAME = #{name}")
    public List<Member> listMembers(String name);

    //delete data
    @Delete("delete from member_account where Id = #{id}")
    public void deleteById(int id);

    //update login date
    @Update("update member_account set LastLogin = CURDATE() where Name = #{name}")
    public void set_login_date(String name);

    @Select("select * from member_account where Id = #{id} ")
    public Member get(int id);

    @Update("update member_account set Name = #{name} where Id = #{id} ")
    public int update(String name ,int id);


}
