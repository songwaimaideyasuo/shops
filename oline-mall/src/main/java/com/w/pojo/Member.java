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
    @JsonProperty("nick_name")
    private String nickName;
    @JsonProperty("real_name")
    private String realName;
    private String email;
    private int gender;

    @JsonProperty("register_time")
    private LocalDateTime registerTime;


}
