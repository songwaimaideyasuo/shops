package com.w.controller;


import com.w.pojo.Address;
import com.w.pojo.Member;
import com.w.pojo.Result;
import com.w.service.AddressService;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/address")
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/findByMember")
    public Result findByMember(HttpSession session) {

        log.info("查询会员地址");
        //获取会员的id
        Member member = (Member)session.getAttribute("member");
        Integer memberId = member.getId();

        //调用业务层根据会员id获取对应的address集合
        List<Address> addressList = addressService.findByMemberId(memberId);

        return Result.success("查询成功",addressList);
    }


    //保存新增的地址
    @PostMapping("/saveAddress")
    public Result saveAddress(HttpSession session) {
        log.info("新增地址");

        //获取前台传过来的地址信息，并将其它保存到一个Address对象中
        Map<String, String[]> parameterMap = request.getParameterMap();
        Address address = new Address();
        try {
            //作用是直接将map转换为一个类的对象
            BeanUtils.populate(address,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //为地址设置对应的会员的id
        Member member = (Member)session.getAttribute("member");
        address.setMbr_id(member.getId());

        addressService.addAddress(address);

        return Result.success("添加成功");

    }


}
