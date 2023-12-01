package com.w.mapper;


import com.w.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {

    //添加订单时需要将订单的id返回，到时添加订单项时需要用到这个id
    public int add(Orders orders);

    //根据订单号修改订单的状态
    public void update(int status, String orderNumber);
}
