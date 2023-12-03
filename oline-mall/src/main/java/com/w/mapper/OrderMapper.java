package com.w.mapper;


import com.w.pojo.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrderMapper {

    //添加订单时需要将订单的id返回，到时添加订单项时需要用到这个id
    @Insert("insert into shops.orders values(null,#{number},#{buyer_id},#{total_amount},#{total_price},#{payment_price},#{remark}," +
            "#{concat},#{mobile},#{street},#{zipcode},#{create_time},#{payment_time},#{delivery_time},#{end_time},#{status})")
    public int add(Orders orders);

    //根据订单号修改订单的状态
    @Update("update shops.orders set status = #{status} where number = #{orderNumber}")
    public void update(int status, String orderNumber);
}
