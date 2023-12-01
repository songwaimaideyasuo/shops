package com.w.service.impl;


import com.w.mapper.AddressMapper;
import com.w.pojo.Address;
import com.w.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> list() {
       return addressMapper.list();
    }
}
