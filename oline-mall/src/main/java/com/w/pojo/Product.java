package com.w.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("cateId")
    private Integer cate_id;
    private String thumbnail;
    private Integer inventory;
    @JsonProperty("sales_volume")
    private Integer salesVolume;

    private double price;
    @JsonProperty("sale_price")
    private double salePrice;
    @JsonProperty("detail_description")
    private String detailDescription;
    @JsonProperty("selling_description")
    private String sellingDescription;
    @JsonProperty("create_time")
    private Date createTime;
    @JsonProperty("sale_time")
    private Date saleTime;

}
