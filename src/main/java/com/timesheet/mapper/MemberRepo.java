package com.timesheet.mapper;

import com.timesheet.pojo.Member;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {

    Optional<Member> findByName(String username);
    //update login date
//    @Update("update memberaccount set LAST_LOGIN = CURDATE() where NAME = #{name}")
//    public void set_login_date(String name);

}
