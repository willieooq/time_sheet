package com.timesheet.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Proxy(lazy = false)
@Entity
@Table(name = "memberaccount")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //member name
    @Column(unique = true)
    private String name;
    //member password
    private String password;
    //最後登陸時間
    private String last_login;
    //auth
    private String role;

}
