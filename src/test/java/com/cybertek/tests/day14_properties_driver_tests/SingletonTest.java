package com.cybertek.tests.day14_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static java.lang.Thread.sleep;

public class SingletonTest {

    @Test
    public void test() throws FileNotFoundException {

        WebDriver driver = Driver.get();
        WebDriver driver1 = Driver.get();
        WebDriver driver2 = Driver.get();
        WebDriver driver3 =   Driver.get();
        WebDriver driver4 = Driver.get();
        WebDriver driver5 = Driver.get();
        WebDriver driver6 = Driver.get();
        System.out.println(driver1.hashCode());
        System.out.println(driver2.hashCode());
        System.out.println(driver3.hashCode());
        System.out.println(driver4.hashCode());
        System.out.println(driver5.hashCode());


    }
}
