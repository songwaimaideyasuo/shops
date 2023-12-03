package com.w.service;

import com.w.pojo.Address;

import java.util.List;

public interface AddressService {

    List<Address> list();

    List<Address> findByMemberId(Integer memberId);

    void addAddress(Address address);

    Address findById(int parseInt);
}
