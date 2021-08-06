package com.timesheet.service;

import com.timesheet.mapper.MemberRepo;
import com.timesheet.pojo.Member;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MemberDAO {

    private final MemberRepo memberRepo;

    public List<String> getAllUserNames() {
        return memberRepo.findAll().stream()
                .map(Member::getName)
                .collect(Collectors.toList());
    }

    public Optional<Member> getByUsername(String name) {
        return memberRepo.findByName(name);
    }

//    @PostConstruct
//    void init(){
//        List<Member> userList = List.of(
//                Member.builder()
//                        .name("admin")
//                        .password("1234")
//                        .role("ADMIN").build(),
//                Member.builder()
//                        .name("officer")
//                        .password("123")
//                        .role("OFFICER").build(),
//                Member.builder()
//                        .name("staff")
//                        .password("123")
//                        .role("STAFF").build());
//
//        memberRepo.saveAll(userList);
//    }

}