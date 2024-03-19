package com.example.demo.test1;

import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller4 {
    @GetMapping("/calculate")
    public String test(@RequestParam String str){

        String[] split = str.split(" ", 3);

        double num1 = Double.parseDouble(split[0]);
        double num2 = Double.parseDouble(split[2]);
        char op = split[1].charAt(0);
        Calculate calculate = new Calculate(num1,num2);
        double result=0;

        if (op == '+') result = calculate.add();
        if (op == '-') result = calculate.decrese();
        if (op == '*') result = calculate.multiple();
        if (op == '/') result = calculate.division();

        return Double.toString(result);

    }
}
