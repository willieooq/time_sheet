package com.timesheet.member;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "member")
public class MemberBean {
    private int id  = 0;
    //member name
    private String name = "";
    //member password
    private String password = "";
    //最後登陸時間
    private String last_login = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLast_login() { return last_login; }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }
}
