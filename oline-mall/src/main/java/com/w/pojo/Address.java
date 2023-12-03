package com.w.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("mbr_id")
    private Integer mbrId;
    @JsonProperty("default_value")
    private int defaultValue;

}
