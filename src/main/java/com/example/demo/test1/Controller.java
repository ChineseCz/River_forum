package com.example.demo.test1;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @PostMapping("/get-from-url")
    public String getParamsFromURL(@RequestParam String nam, @RequestParam String type) {
        return nam + "-" + type;
    }

}
