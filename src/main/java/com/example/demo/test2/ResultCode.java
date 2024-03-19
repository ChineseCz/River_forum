package com.example.demo.test2;
import lombok.Getter;


//用enum类封装状态码、信息
@Getter
public enum ResultCode {
    //成功返回结果
    SERVICE_SUCCESS(200,"请求成功"),
    //返回失败结果
    SERVICE_ERR(500,"服务器端错误"),
    //返回找不到结果
    SERVICE_NOTFOUND(404,"没有找到资源"),
    //
    SERIVCE_BadRequest(400,"错误的请求");

    private final String msg;
    private final int code;

    ResultCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}