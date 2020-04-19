package com.cybertek.tests.day07_types_of_elements;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.junit.ArrayAsserts;

public class TestNGAssertionsDemo {
    @Test
    public void test1(){
        System.out.println("Assertion");
        Assert.assertEquals("tile","title");
        String expectedTitle= "Cyb";
        String actualTitle = "Cybertek";Assert.assertTrue(actualTitle.startsWith(expectedTitle),"Verify Starts with");
        Assert.assertEquals(actualTitle.contains("alfa"),actualTitle,"");

    }

}
