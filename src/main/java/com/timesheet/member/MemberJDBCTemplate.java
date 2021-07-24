package com.timesheet.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

public class MemberJDBCTemplate implements MemberDAO{


    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(String name, String password) {
        String sql = "insert into memberaccount (NAME,PASSWORD) values (?,?)";
        jdbcTemplate.update(sql,name,password);
        System.out.println("新建成功 用戶名稱: "+ name);
        return;
    }

    @Override
    public MemberBean getMemberID(String name) {
        String sql = "select * from memberacount where NAME = ?";
        MemberBean member = (MemberBean) jdbcTemplate.queryForObject(sql,new Object[]{name},new MemberMapper());
        return member;
    }

    @Override
    public List<MemberBean> listMembers(String name) {
        String sql = "select * from memberaccount  where NAME = ?";
        List<MemberBean> members = (List<MemberBean>) jdbcTemplate.query(sql,new Object[]{name},new MemberMapper());
        return members;
    }

    @Override
    public void delete(int id) {
        String sql = "delete from memberaccount";
        jdbcTemplate.update(sql,id);
        System.out.println("已刪除此帳號");
    }

    @Override
    public void update_password(int id, String pw) {
        String sql = "update memberaccount set PASSWORD = ? where ID = ?";
        jdbcTemplate.update(sql,pw,id);
        System.out.println("變更密碼成功");
    }

    @Override
    public void set_login_date(int id) {
        String sql = "update memberaccount set LAST_LOGIN = NOW() where ID =?";
        jdbcTemplate.update(sql,id);
    }

    private void close() {
    }

}
