package com.cybertek.tests.day03_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NameDemo {

    public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub
      WebDriver driver =   WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://demo.guru99.com/test/ajax.html");

// Find the radio button for “No” using its ID and click on it
        Thread.sleep(9000);
        driver.findElement(By.id("Yes")).click();

//Click on Check Button
        driver.findElement(By.id("buttoncheck")).click();

    }

}