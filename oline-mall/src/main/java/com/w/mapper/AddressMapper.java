package com.w.mapper;


import com.w.pojo.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AddressMapper {


    @Select("select * from shops.address")
    List<Address> list();

    @Select("select * from shops.address where mbr_id = #{memberId}")
    List<Address> findByMemberId(Integer memberId);

    @Insert("insert into shops.address values(null, #{contact}, #{mobile}, #{street}, #{zipcode}, #{mbr_id}, #{default_value})")
    void addAddress(Address address);

    @Select("select * from shops.address where id = #{parseInt}")
    Address findById(int parseInt);
}
