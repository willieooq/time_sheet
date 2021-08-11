package com.timesheet.pojo;

import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Proxy(lazy = false)
@Entity
@Table(name = "work_time")
public class WorkTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    //reference member_account username
    @Column(name = "UserId")
    private String userId;
    //Date YYYY/MM/DD
    @Column(name = "Date")
    private Date date;
    //Start time hh/mm
    @Column(name = "StartTime")
    private Time startTime;
    //End time hh/mm
    @Column(name = "EndTime")
    private Time endTime;
    //Platform
    @Column(name = "Platform")
    private String platform;
    //Detail
    @Column(name = "Detail")
    private String detail;
}
