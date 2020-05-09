package com.SelfStudy.MacKolik;

import org.testng.annotations.Test;

public class DataProvider {

    @org.testng.annotations.DataProvider
    public static Object[][] information() {

        return new Object[][]{{true,"ali", 123456789, 80.05,"istabul"}, {false,"abdulrezzak", 99, 60.99D,"samsun"}};
    }

    @org.testng.annotations.DataProvider
    public static Object[] onlyName() {
        return new Object[]{"sinan"};
    }

    @Test(dataProvider = "information")
    public void test(boolean martial, String name, int age, double weight, String city) {

//        System.out.printf("Name:%20syaş = %d  kilo =%10.1f  \n", name, age, weight);
        System.out.printf("Name: %-12s yaş = %-10d kilo =%5.1f   \n", name, age, weight);
//        System.out.printf("Name:%-25syaş = %d  kilo =%8.1f   \n", name, age, weight);




    }@Test(dataProvider = "onlyName")
    public void oneParam(String name) {

    }


}
