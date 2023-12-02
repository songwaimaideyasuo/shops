package com.w.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
//    private Integer code;//响应码，1 代表成功; 0 代表失败
//    private String msg;  //响应信息 描述字符串
//    private Object data; //返回的数据

    private boolean flag;//后端返回结果正常为true，返回false
    private String msg;//发生异常的错误消息
    private Object data;//后端返回结果数据对象


    //增删改 成功响应
    public static Result success(){
        return new Result(true,"success",null);
    }
    //查询 成功响应
    public static Result success(Object data){
        return new Result(true,"success",data);
    }

    public static Result success(String msg, Object data){
        return new Result(true,msg,data);
    }

    public static Result success(String msg){
        return new Result(true,msg,null);
    }

    //失败响应
    public static Result error(String msg){
        return new Result(false,msg,null);
    }
}
