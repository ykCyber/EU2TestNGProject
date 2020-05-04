package com.cybertek.tests.day13;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Arrays;
import java.util.List;

public class Dp {

    private String a;

    public Object[][] dp1() {
        return new Object[][]{
                new Object[]{"a", "b"},
                new Object[]{"c", "d"},
        };
    }

    public Object[][] dp2() {

        return new Object[][]{
                new Object[]{"e", "f"},
                new Object[]{"g", "h"},
        };
    }

    @DataProvider
    public Object[][] dp() {
        List<Object[]> result = Lists.newArrayList();
        result.addAll(Arrays.asList(dp1()));
        result.addAll(Arrays.asList(dp2()));
        return result.toArray(new Object[10][]);
    }

    @Test(dataProvider = "dp")
    public void f(String a, String b,String j) {
        this.a = a;
        System.out.println("f " + a + " " + b+" "+j);
        
    }
}