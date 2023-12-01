package com.w.service;


import com.w.pojo.Member;

public interface MemberService {

    //public Member login(String mobile, String pwd);

    public Member login(Member member);

    void add(Member member);

}
