package com.cybertek.tests.day14_properties_driver_tests;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;

public class DriverTest {
    public static void main(String[] args) throws FileNotFoundException {
        WebDriver driver = Driver.get();
        WebDriver driver1 = Driver.get();
        WebDriver driver2 = Driver.get();
        WebDriver driver3 = Driver.get();
        WebDriver driver4 = Driver.get();
        WebDriver driver5 = Driver.get();
        WebDriver driver6 = Driver.get();
        System.out.println(driver1.hashCode());
        System.out.println(driver2.hashCode());
        System.out.println(driver3.hashCode());
        System.out.println(driver4.hashCode());
        System.out.println(driver5.hashCode());
        System.out.println(driver6.hashCode());
        System.out.println(driver.hashCode());


    }
}
