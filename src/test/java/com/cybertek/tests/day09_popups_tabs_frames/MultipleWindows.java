package com.cybertek.tests.day09_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("opera");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(6000);
       // driver.quit();
    }

    @Test
    public void switchWindowsTest(){

        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("driver.getWindowHandle()After = " + driver.getWindowHandle());
        System.out.println(driver.getTitle());
    }

}