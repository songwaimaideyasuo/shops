package com.w.service.impl;


import com.w.mapper.ItemMapper;
import com.w.mapper.OrderMapper;
import com.w.mapper.ProductMapper;
import com.w.pojo.Item;
import com.w.pojo.Orders;
import com.w.pojo.Product;
import com.w.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ItemMapper itemMapper;


    @Override
    public void add(Orders order, String[] ids, String[] amounts) {
        //添加订单，同时将订单的id返回
        int orderId = orderMapper.add(order);

        //添加订单项
        for(int i=0; i<ids.length; i++){
            //创建订单项对象
            Item item = new Item();
            item.setOrder_id(orderId);          //设置订单id
            item.setProduct_id(Integer.parseInt(ids[i])); //设置商品id
            item.setAmount(Integer.parseInt(amounts[i])); //设置当前订单项的数量

            Product product = productMapper.findById(Integer.parseInt(ids[i]));
            item.setTotal_price(product.getPrice()* Integer.parseInt(amounts[i]));
            item.setPayment_price(product.getSalePrice()* Integer.parseInt(amounts[i]));
            itemMapper.add(item);
        }
    }

    @Override
    public void update(int status, String orderNumber) {
        orderMapper.update(status,orderNumber);
    }
}
