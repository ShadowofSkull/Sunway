package com.prg1203.package2;

import com.prg1203.package1.Class1;

public class Class3 {
    public static void main(String[] args) {
        Class1 c1 = new Class1();
        setValueTen(c1);
        System.out.println(c1.test1);
        // System.out.println(c1.test2);
        System.out.println(c1.test3);
        System.out.println(c1.test4);
    }


    public static void setValueTen(Class1 c1){
        c1.test1 = 10;
        // c1.test2 = 10;
        c1.test3 = 10;
        c1.test4 = 10;
    }
}
