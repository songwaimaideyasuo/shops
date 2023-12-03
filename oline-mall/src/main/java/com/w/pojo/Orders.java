package com.w.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders implements java.io.Serializable {

    private Integer id;
    private String number;
    private Integer buyer_id;
    private Integer total_amount;
    private Double total_price;
    private Double payment_price;
    private String remark;
    private String concat;
    private String mobile;
    private String street;
    private String zipcode;
    private Date create_time;
    private Date payment_time;
    private Date delivery_time;
    private Date end_time;
    private Integer status;


}
