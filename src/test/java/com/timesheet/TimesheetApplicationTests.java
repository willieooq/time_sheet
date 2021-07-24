package com.timesheet;

import com.timesheet.member.MemberBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TimesheetApplicationTests {

    @Autowired
    MemberBean member;

    @Test
    void contextLoads() {
        System.out.println(member.getName());
    }

}
