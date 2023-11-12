package com.prg1203.package2;
import com.prg1203.package1.Class1;

public class Class4 extends Class1{

    Class4(){
        super();
    }
    public static void main(String[] args) {
        Class4 c4 = new Class4();
        c4.test1 = 10;
        // c4.test2 = 10;
        // c4.test3 = 10;
        c4.test4 = 10;
        System.out.println(c4.test1);
        // System.out.println(c4.test2);
        // System.out.println(c4.test3);
        System.out.println(c4.test4);

    }

    
}
