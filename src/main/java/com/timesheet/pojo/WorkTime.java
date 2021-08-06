package com.timesheet.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Proxy(lazy = false)
@Entity
@Table(name = "worktime")
public class WorkTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    //reference member_account username
    @Column(name = "USER_ID")
    private String USER_ID;
    //Date YYYY/MM/DD
    private Date DATE;
    //Start time hh/mm
    @Column(name = "START_TIME")
    private Time START_TIME;
    //End time hh/mm
    @Column(name = "END_TIME")
    private Time END_TIME;
    //Platform
    private String PLATFORM;
    //Detail
    private String DETAIL;
}
