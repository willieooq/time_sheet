package com.timesheet.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Proxy(lazy = false)
@Entity
@Table(name = "member_account")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    //member name
    @Column(name = "Name",unique = true)
    private String name;
    //member password
    @Column(name = "Password")
    private String password;
    //最後登陸時間
    @Column(name = "LastLogin")
    private String lastLogin;
    //auth
    @Column(name = "Role")
    private String role;

}
