package com.w.service;


import com.w.pojo.Member;

public interface MemberService {

    //public Member login(String mobile, String pwd);

    Member login(Member member);

    void add(Member member);

}
