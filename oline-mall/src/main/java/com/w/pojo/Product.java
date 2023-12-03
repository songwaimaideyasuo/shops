package com.w.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements java.io.Serializable {

    private Integer id;
    private String name;
    private Integer cate_id;
    private String thumbnail;
    private Integer inventory;
    private Integer sales_volume;
    private double price;
    private double sale_price;
    private String detail_description;
    private String selling_description;
    private Date create_time;
    private Date sale_time;

}
