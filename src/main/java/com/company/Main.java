package com.company;

import com.company.task1.ArithHelper;

public class Main {

    public static void main(String[] args) {
        System.out.println(ArithHelper.add(11e-5,1e-5));
        System.out.println(ArithHelper.round(1.5e5,0));
        System.out.println(ArithHelper.round(-5.354323e3,3));
    }
}
