package com.w.mapper;


import com.w.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AddressMapper {


    @Select("select * from shops.address")
    List<Address> list();
}