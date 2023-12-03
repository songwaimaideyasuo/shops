package com.w.mapper;


import com.w.pojo.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper {

    @Insert("insert into shops.item values(null,#{order_id},#{product_id},#{amount},#{total_price},#{payment_price})")
    public void add(Item item);
}
