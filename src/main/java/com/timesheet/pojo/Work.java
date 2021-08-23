package com.timesheet.pojo;

import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Proxy(lazy = false)
@Entity
@Table(name = "work")
public class Work {

    //reference member_account username
    @Id
    @Column(name = "Platform")
    private String platform;
    @Column(name = "Detail")
    private String detail;
    @Column(name = "PcCode")
    private String pcCode;
    @Column(name = "Description")
    private String description;
    @Column(name = "CreatedBy")
    private String createdBy;
    //Date YYYY/MM/DD
    @Column(name = "CreationDate")
    private Date creationDate;
    @Column(name = "ModifiedBy")
    private String modifiedBy;
    //Date YYYY/MM/DD
    @Column(name = "ModificationDate")
    private Date modificationDate;
}
