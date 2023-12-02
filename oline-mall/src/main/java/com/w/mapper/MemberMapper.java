package com.w.mapper;


import com.w.pojo.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {

//    public Member findByMobileAndPwd(String mobile, String pwd);
//
//    public Member findByMobile(String mobile);
//
//    public void add(Member member);

    @Select("select * from shops.member where mobile = #{mobile} and pwd = #{pwd}")
    Member login(Member member);

    @Insert("insert into shops.member(mobile, pwd, register_time) " +
            "values(#{mobile},#{pwd},#{register_time})")
    void add(Member member);

    @Select("select * from shops.member where mobile = #{mobile}")
    void findByMobile(String mobile);
}
