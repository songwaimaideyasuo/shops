package com.w.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements java.io.Serializable {
    private Integer id;
    private String contact;
    private String mobile;
    private String street;
    private String zipcode;
    private Integer mbr_id;
    private int default_value;

}
