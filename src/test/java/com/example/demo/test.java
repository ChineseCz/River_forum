package com.example.demo;

import java.util.Scanner;



public class test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] split = string.split(" ", 3);
        double num1 = Double.parseDouble(split[0]);
        double num2 = Double.parseDouble(split[2]);
        char op = split[1].charAt(0);


        System.out.printf("%.2f %.2f %c", num1, num2, op);
        System.out.println();
        Calculate calculate = new Calculate(num1, num2);


        /**out**/

        double result = 0;

        if (op == '+') result = calculate.add();
        if (op == '-') result = calculate.decrese();
        if (op == '*') result = calculate.multiple();
        if (op == '/') result = calculate.division();

        System.out.printf("%.2f", result);
        System.out.println();

    }
}










class Calculate {
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