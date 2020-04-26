package com.cybertek.tests.day09_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class iframes {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("opera");

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
    driver.get("http://practice.cybertekschool.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("mike smith");
        System.out.printf("frame url\n", driver.getCurrentUrl());
        System.out.println("LAST.getCurrentUrl() = " + driver.switchTo().parentFrame().getCurrentUrl());
    }
}