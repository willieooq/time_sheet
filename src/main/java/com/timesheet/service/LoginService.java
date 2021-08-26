package com.timesheet.service;

import com.timesheet.mapper.MemberMapper;
import com.timesheet.pojo.Member;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class LoginService implements UserDetailsService {

    private MemberMapper memberMapper;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public void setMemberMapper(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {this.passwordEncoder = passwordEncoder;}
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

// 封裝成 Spring security 定義的 User 對象
        return getByUsername(username)
                .map(e -> User.withUsername(e.getName())
                        .passwordEncoder(s -> passwordEncoder.encode(e.getPassword()))
                        .roles(e.getRole())
                        .build()).orElse(null);
    }
    public List<String> getAllUserNames() {
        return memberMapper.selectAll().stream()
                .map(Member::getName)
                .collect(Collectors.toList());
    }
    public Optional<Member> getByUsername(String name) {
        return memberMapper.findByName(name);
    }
    //使用者登入設定日期
    public void userLoginDate(String username){
        memberMapper.set_login_date(username);
    }
}

//        return User.builder()
//                .username(username)
//                .passwordEncoder(s -> passwordEncoder.encode(passwd))
//                .authorities(new SimpleGrantedAuthority("admin"))
//                .build();