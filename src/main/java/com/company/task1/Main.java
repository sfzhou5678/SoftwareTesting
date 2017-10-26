package com.company.task1;

public class Main {
    public static void main(String[] args) {

        Calculator cal  = new Calculator();

        String s = "5+12*(3+5)/7";
        double result  = cal.calculate(s);
        System.out.println(result);
        System.out.println(5+12*(3+5)/7.0);

        s="9.5+(3-1)*3+10/2+45";
        result=cal.calculate(s);
        System.out.println(result);
        System.out.println(9.5+(3-1)*3+10/2+45);

        System.out.println(ArithHelper.div(1e0, 2e5,5));
        System.out.println((1e0) / (2e5));
    }
}
