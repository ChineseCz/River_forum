package com.example.demo.test1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2{

    @GetMapping("/test")
    public String test(@RequestHeader(value = "auth", required = false) String auth,
                       @RequestParam String name, @RequestParam String type){
        if (auth!=null && !auth.isEmpty())//有auth字段咯
            return name+"-"+type;
        else
            return "Invalid User";

    }
}