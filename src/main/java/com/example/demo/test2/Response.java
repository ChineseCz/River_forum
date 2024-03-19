
package com.example.demo.test2;

import lombok.Getter;

@Getter
public class Response<T> {
    private final Integer code;
    private final String message;
    private T data;


    public Response(ResultCode apiCode, T data) {
        this.code = apiCode.getCode();
        this.message = apiCode.getMsg();
        this.data = data;
    }

    public Response(ResultCode apiCode) {
        this.code = apiCode.getCode();
        this.message = apiCode.getMsg();
    }

    //返回成功，状态码与信息
    public static Response<Object> success() {
        return new Response<> (ResultCode.SERVICE_SUCCESS);
    }
    //返回成功，状态码、信息、数据
    public static Response<Object> success(Object data) {
        return new Response<> (ResultCode.SERVICE_SUCCESS, data);
    }
    //返回错误类型，以及状态码、信息
    public static Response<Object> error(ResultCode apiCode) {
        return new Response<> (apiCode);
    }


}