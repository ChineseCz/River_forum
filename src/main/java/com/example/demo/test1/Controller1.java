package com.example.demo.test1;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller1 {

    @PostMapping("/get-from-body")
    public String getParamsFromBody(@RequestBody Map<String, String> data) {
        // 从请求体中获取参数
        String name = data.get("name");
        String type = data.get("type");

        // 将参数以 name-type 的形式返回
        return name + "-" + type + " from body";
    }
}
