package com.w.controller;


import com.w.pojo.CartItem;
import com.w.pojo.Product;
import com.w.pojo.Result;
import com.w.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@RequestMapping("/cart")
@RestController //自动将方法的返回值转为json响应回去
public class CateController extends BaseServlet {

    @Autowired
    private ProductService productService;

    @Autowired
    private HttpServletRequest request;

//    @Autowired
//    private CateService cateService;


    @PostMapping("/addCart")
    public Result addCart(String productId, String number) {

        //获取到前台传过来的商品编号和数量
        int productId1 = Integer.parseInt(productId);

        int number1 = Integer.parseInt(number);

        //创建一个购物车项对象（商品+数量）
        Product product = productService.findById(productId1);
        CartItem cartItem = new CartItem(product, number1);

        //获取购物车
        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {     //用户是第一次购物，session中并没有存放购物车，此时应该创建一个购物
            cart = new ArrayList<>();
        }
        cart.add(cartItem);    //将购物车项装进购物车中
        session.setAttribute("cart", cart);
        return Result.success("添加成功");
    }


    @GetMapping("/viewCart")
    public Result viewCart() {

        //获取Session
        HttpSession session = request.getSession();

        //从session中取出购物车对象（List）
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (cart == null) {
            return Result.error("购物车为空");
        } else {
            return Result.success("查询成功",cart);
        }
    }

}
