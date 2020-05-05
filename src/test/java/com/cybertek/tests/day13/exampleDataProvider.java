package com.cybertek.tests.day13;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class exampleDataProvider {
    @DataProvider
    public static Object[][] oneParam() {
        return new String[][]{{"ahmet"},{"bilal"},{"caner"},{"davut"},{"erdem"}};
    }

    @DataProvider
    public static Object[][] multiParam() {
        return new Object[][]{{"ahmet","yıldırım","samsun",12},
                {"bilal","yıldırım","mersin",33}};
    }

    @DataProvider
    public static Object[][] userNamePassword() {
        return new Object[][]{{"user16","UserUser123"},{"user17","UserUser123"},{"user18","UserUser123"}};
    }

    @Test (dataProvider = "oneParam")
    public void test1(String name){
        System.out.println(name);
    } @Test (dataProvider = "multiParam")
    public void test2(String name,String surname,String memleket,int yas){
        System.out.println(name+" "+surname+" "+memleket+" "+yas);
    }@Test (dataProvider = "userNamePassword")
    public void test3(String userName,String password){
        System.out.println(userName+" "+password);
    }
}
