package com.w.mapper;


import com.w.pojo.Item;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemDao {

    public void add(Item item);
}
