package com.w.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member implements java.io.Serializable{

    private Integer id;
    private String mobile;
    private String pwd;
    private String nick_name;
    private String real_name;
    private String email;
    private int gender;

    //@JsonProperty("registerTime")
    private LocalDateTime register_time;


}
