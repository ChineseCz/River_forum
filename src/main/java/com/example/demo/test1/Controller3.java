package com.example.demo.test1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class Controller3 {

    @GetMapping("/getData")
    public ApiResponse<String> getData() {
        // 模拟从数据库或其他数据源获取数据
        String result = "cdc-lol";

        // 创建并返回一个ApiResponse对象
        ApiResponse<String> response = new ApiResponse<>(200, "Success", result);
//        return new ResponseEntity<>(post, HttpStatus.OK);
        return response;
    }
}

