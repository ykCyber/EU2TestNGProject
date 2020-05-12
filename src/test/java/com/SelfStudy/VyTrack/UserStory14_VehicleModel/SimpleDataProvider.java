package com.SelfStudy.VyTrack.UserStory14_VehicleModel;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SimpleDataProvider {

    @DataProvider
    public static Object[][] cridentals() {
        return new Object[][]{{"user16","UserUserUser123"}};
    }

    @Test (dataProvider = "cridentals")


    public void test(String userName, String password ) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getManuelDriver("chrome");
        driver.get("http://qa1.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys(userName);
        Thread.sleep(2500);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        Thread.sleep(2500);
        driver.findElement(By.id("_submit")).click();
        Assert.assertTrue(driver.getTitle().contains("Dashboard"),"UsurName "+ userName);
    }
}