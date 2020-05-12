package com.cybertek.tests.day14_properties_driver_tests;

import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class SingletonTest {

    @Test
    public void test() {
        String instance = Singleton.getInstance();
        String instance2 = Singleton.getInstance();
        String instance3 = Singleton.getInstance();
        String instance4 = Singleton.getInstance();
        String instance5 = Singleton.getInstance();
        String instance6 = Singleton.getInstance();
    }
}
