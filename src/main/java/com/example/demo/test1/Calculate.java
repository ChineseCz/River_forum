package com.example.demo.test1;

public class Calculate {
    double num1, num2;

    public Calculate(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double add() {
        return num1 + num2;
    }

    public double decrese() {
        return num1 - num2;
    }

    public double multiple() {
        return num1 * num2;

    }

    public double division() {
        return num1 / num2;

    }

}