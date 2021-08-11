package com.timesheet.service;

import com.timesheet.mapper.MemberMapper;
import com.timesheet.pojo.Member;
import lombok.AllArgsConstructor;
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

@AllArgsConstructor
@Service
public class LoginService implements UserDetailsService {

    private MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public void setMemberMapper(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return getByUsername(username)
                .map(e -> User.withUsername(e.getName())
                        .passwordEncoder(s -> passwordEncoder.encode(e.getPassword()))
//                        .password("{noop}" + e.getPassword())
                        .roles(e.getRole())
                        .build()).orElse(null);

        // 封裝成 Spring security 定義的 User 對象
//        return User.builder()
//                .username(username)
//                .passwordEncoder(s -> passwordEncoder.encode(passwd))
//                .authorities(new SimpleGrantedAuthority("admin"))
//                .build();
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
