package com.cybertek.tests.day10_syncy;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExpicilityWait {

    WebDriver driver = WebDriverFactory.getDriver("chrome");

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMetgod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test

    public void test() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        ExpectedConditions.invisibilityOf(driver.findElement(By.id("#loading")));

        driver.findElement(By.id("username")).sendKeys("Mike Smith");
        //driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

    }


}
