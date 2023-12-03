package com.w.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category implements java.io.Serializable{

    private Integer id;
    private String name;
    private String alias;


}
