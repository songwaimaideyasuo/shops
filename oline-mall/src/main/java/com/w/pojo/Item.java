package com.w.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item implements java.io.Serializable {

    private Integer id;
    private Integer order_id;
    private Integer product_id;
    private Integer amount;
    private Double total_price;
    private Double payment_price;

}
