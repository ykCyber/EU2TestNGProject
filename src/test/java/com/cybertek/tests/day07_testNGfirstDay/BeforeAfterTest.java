package com.cybertek.tests.day07_testNGfirstDay;

import org.testng.annotations.*;

public class BeforeAfterTest {
    @BeforeMethod
    public void setUp() {
        System.out.println("open browsers");
    }

    @AfterMethod
    public void tearDown() {
        System.err.println("close browser");
    }

    @BeforeClass
    public void
    setupClass() {
        System.out.println("before class");
    }

    @AfterClass
    public void
    afterClass () {
        System.out.println("after class");
    }

    @Test

    public void test1() {

        System.err.println("This is my test 1");

    }

    @Test
    public void test2() {

        System.err.println("This is my test 2");

    }
}
