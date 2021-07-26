//廢棄
//package com.timesheet.member;
//
//import com.timesheet.mapper.MemberMapper;
//import com.timesheet.pojo.Member;
//import com.timesheet.pojo.MemberDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.sql.DataSource;
//import java.util.List;
//
//public class MemberJDBCTemplate implements MemberMapper {
//
//
//    @Autowired
//    private DataSource dataSource;
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    @Override
//    public void create(String name, String password) {
//        String sql = "insert into memberaccount (NAME,PASSWORD) values (?,?)";
//        jdbcTemplate.update(sql,name,password);
//        System.out.println("新建成功 用戶名稱: "+ name);
//        return;
//    }
//
//    @Override
//    public Member getMemberID(String name) {
//        String sql = "select * from memberacount where NAME = ?";
//        Member member = (Member) jdbcTemplate.queryForObject(sql,new Object[]{name},new MemberDTO());
//        return member;
//    }
//
//    @Override
//    public List<Member> listMembers(String name) {
//        String sql = "select * from memberaccount  where NAME = ?";
//        List<Member> members = (List<Member>) jdbcTemplate.query(sql,new Object[]{name},new MemberDTO());
//        return members;
//    }
//
//    @Override
//    public void delete(int id) {
//        String sql = "delete from memberaccount";
//        jdbcTemplate.update(sql,id);
//        System.out.println("已刪除此帳號");
//    }
//
//    @Override
//    public void update_password(int id, String pw) {
//        String sql = "update memberaccount set PASSWORD = ? where ID = ?";
//        jdbcTemplate.update(sql,pw,id);
//        System.out.println("變更密碼成功");
//    }
//
//    @Override
//    public void set_login_date(int id) {
//        String sql = "update memberaccount set LAST_LOGIN = NOW() where ID =?";
//        jdbcTemplate.update(sql,id);
//    }
//
//    private void close() {
//    }
//
//}