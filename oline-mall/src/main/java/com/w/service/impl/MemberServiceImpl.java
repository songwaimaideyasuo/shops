package com.w.service.impl;


import com.w.mapper.MemberMapper;
import com.w.pojo.Member;
import com.w.pojo.Result;
import com.w.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Member login(Member member) {
        return memberMapper.login(member);
    }

    @Override
    public void add(Member member) {

        //判断手机号码是否存在
//        Member mobile = memberMapper.findByMobile(member.getMobile());
//        if (mobile!=null){
//            //Result.error("注册失败");
//            //return;
//        }

        member.setRegisterTime(LocalDateTime.now());
        memberMapper.add(member);

    }


//    @Override
//    public boolean regist(Member member) {
//        //判断手机号码是否存在
//        Member mobile = memberDao.findByMobile(member.getMobile());
//        if (mobile!=null){
//            return false;
//        }
//
//        memberDao.add(member);
//        return true;
//    }
}
