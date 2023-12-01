package com.w.controller;


import com.w.pojo.Address;
import com.w.pojo.Result;
import com.w.service.AddressService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@Slf4j
@RequestMapping("/address")
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public Result list(){

        log.info("查询全部地址");
        List<Address> deptList =  addressService.list();
        return Result.success(deptList);
    }


}
