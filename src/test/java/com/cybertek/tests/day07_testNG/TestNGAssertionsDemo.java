package com.cybertek.tests.day07_testNG;

import com.google.gson.internal.bind.util.ISO8601Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {
    @Test
    public void test1(){
        System.out.println("Assertion");
        Assert.assertEquals("tile","title");
        String expectedTitle= "Cyb";
        String actualTitle = "Cybertek";
        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"Verify Starts with");



    }

}
