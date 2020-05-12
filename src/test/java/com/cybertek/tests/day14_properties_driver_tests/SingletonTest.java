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
        String instance = Singleton.getInstance();
        String instance2 = Singleton.getInstance();
        String instance3 = Singleton.getInstance();
        String instance4 = Singleton.getInstance();
        String instance5 = Singleton.getInstance();
        String instance6 = Singleton.getInstance();
        WebDriver driver = Driver.get();
        System.out.println("ConfigurationReader.get(\"browser\") = " + ConfigurationReader.get("browser"));
        driver.get("https://google.com");


    }
}
