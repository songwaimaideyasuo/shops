package com.w.service;

import com.w.pojo.Address;

import java.util.List;

public interface AddressService {

//    public List<Address> findByMemberId(int memberid);
//
//    public void add(Address address);
//
//    public Address findById(int id);



    List<Address> list();

    List<Address> findByMemberId(Integer memberId);
}
