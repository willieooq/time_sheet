package com.timesheet.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MemberMapper implements RowMapper {
    public MemberBean mapRow(ResultSet rs, int rowNum) throws SQLException {
        MemberBean member = new MemberBean();
        member.setId(rs.getInt("ID"));
        member.setName(rs.getString("NAME"));
        member.setPassword(rs.getString("PASSWORD"));
        member.setLast_login(rs.getString("LAST_LOGIN"));
        return member;
    }
}
