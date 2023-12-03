package com.w.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News implements java.io.Serializable {

    private Integer id;
    private String title;
    private String thumbnail;
    private String content;
    private Integer top;
    private Integer hits;
    private Date pub_time;

}
