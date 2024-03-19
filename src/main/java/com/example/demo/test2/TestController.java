package com.example.demo.test2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/test0")
    public Response<Object> test() {
        //模拟取得的数据
        Map<String,Integer> map= new HashMap<>();
        map.put("cdc",100);
        map.put("test2",200);
//        return new Response<>(ResultCode.SERVICE_ERR,data);
        return Response.success(map);
    }

    @GetMapping("/test1")
    public Response<Object> test1() {
        return Response.success();
    }
    @GetMapping("/test2")
    public Response<Object> test2() {
        return Response.error(ResultCode.SERVICE_NOTFOUND);
    }
    @GetMapping("/test3")
    public Response<Object> test3() {
        return Response.error(ResultCode.SERIVCE_BadRequest);
    }

    @GetMapping("/test4")
    public Response<Object> test4(){
        return Response.error(ResultCode.SERVICE_ERR);
    }



}