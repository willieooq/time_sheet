package com.timesheet.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MemberDTO{
    public Member mapRow(ResultSet rs, int rowNum) throws Exception {
        Member member = new Member();
        member.setId(rs.getInt("ID"));
        member.setName(rs.getString("NAME"));
        member.setPassword(rs.getString("PASSWORD"));
        member.setLast_login(rs.getString("LAST_LOGIN"));
        member.setRole("ROLE");
        return member;
    }
}
