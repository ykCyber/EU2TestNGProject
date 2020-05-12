package com.cybertek.tests.day14_properties_driver_tests;

public class Singleton {
    private static String str;

    public static String getInstance() {
        if (str == null) {
            System.out.println(str);
            str = "someValue";
        }
        else{
            System.out.println(str);
        }
        return str;
    }
}
