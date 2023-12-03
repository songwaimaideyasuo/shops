package com.w.controller;


import com.w.pojo.*;
import com.w.service.AddressService;
import com.w.service.OrderService;
import com.w.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Slf4j
@RequestMapping("/order")
@RestController //自动将方法的返回值转为json响应回去
public class OrderController extends BaseServlet {

    @Autowired
    ProductService productService;
    @Autowired
    AddressService addressService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OrderService orderService;

    @PostMapping("/confirmOrder")
    public Result confirmOrder(String ids, String amounts) {
        log.info("结算页面--显示商品id和数量");

        String[] ids1 = ids.split(",");
        String[] amounts1 = amounts.split(",");

        //构造一个集合，将订单项的信息显示到前台
        List<CartItem> orderList = new ArrayList<>();

        for (int i = 0; i < ids1.length; i++) {
            String id = ids1[i];   //商品编号
            String amount = amounts1[i];    //获取数量
            Product product = productService.findById(Integer.parseInt(id));
            CartItem cartItem = new CartItem(product,Integer.parseInt(amount));
            orderList.add(cartItem);
        }
        return Result.success("查询成功",orderList);
    }

    @PostMapping("/submitOrder")
    public Result submitOrder() {
        log.info("结算页面--提交订单，数据库后台生成订单");

        //获取前台传过来的地址编号
        String address_id = request.getParameter("address_id");

        //获取商品的编号和数量
        String[] ids = request.getParameterValues("ids");
        String[] amounts = request.getParameterValues("amounts");

        //获取买家的留言
        String remark = request.getParameter("remark");

        //创建一个订单对象
        Orders orders = new Orders();
        orders.setStatus(0);        //0：表示未付款，1：表示已付款  2：表示未发货
        //产生订单号
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String orderNumber = sdf.format(new Date());
        orders.setNumber(orderNumber);

        //获取订单地址信息
        Address address = addressService.findById(Integer.parseInt(address_id));
        orders.setConcat(address.getContact());
        orders.setZipcode(address.getZipcode());
        orders.setStreet(address.getStreet());
        orders.setMobile(address.getMobile());
        //设置买的编号
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("member");
        orders.setBuyer_id(member.getId());
        //设置备注
        orders.setRemark(remark);
        //设置订单生效日期
        orders.setCreate_time(new Date());

        int totalAmout=0;   //总数量
        double totalPrice=0;  //总价格
        double totalPayPrice=0; //实际支付的总价格
        //获取商品信息
        for(int i=0; i<ids.length; i++){
            Product product = productService.findById(Integer.parseInt(ids[i]));
            int amount = Integer.parseInt(amounts[i]);
            totalAmout+=amount;
            totalPrice+=product.getPrice()*amount;
            totalPayPrice+=product.getSalePrice()*amount;
        }
        orders.setPayment_price(totalPayPrice);
        orders.setTotal_price(totalPrice);
        orders.setTotal_amount(totalAmout);


        //添加订单
        orderService.add(orders,ids,amounts);

        return Result.success("订单生成成功!",orders);

    }

}


