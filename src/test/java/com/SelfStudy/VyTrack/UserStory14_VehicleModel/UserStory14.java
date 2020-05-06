package com.SelfStudy.VyTrack.UserStory14_VehicleModel;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory14 {
    WebDriver driver = WebDriverFactory.getManuelDriver("chrome");

    @DataProvider
    public static Object[][] truckDriverredentails() {
        return new Object[][]{{"user18","UserUser123"}};
    }

    @BeforeMethod
    public void setUp(){
        driver.get("https://qa1.vytrack.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void afterMethod () throws InterruptedException{
        Thread.sleep(2000);
    }
    @Test(dataProvider = "truckDriverredentails")
    //Acceptance Criteria 2: Verify that Store manager or Sales manager should be able to create new Vehicle model
    public void ac2 (String userName,String password) throws InterruptedException {
        login(userName,password);

        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Vehicles Model')]")).click();
        String actualResult = driver.getTitle();
        String expectedResult = "Vehicles Model";
        System.out.println("driver.getTitle() = " + driver.getTitle());
        Assert.assertFalse(actualResult.contains(expectedResult));
    }
    public void login(String userName,String password){
        driver.findElement(By.id("prependedInput")).sendKeys(userName);
        driver.findElement(By.id("prependedInput2")).sendKeys(password, Keys.ENTER);
        WebDriverWait wait =new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        Assert.assertTrue(driver.getTitle().contentEquals("Dashboard"),"Page title is \"Dashboard\""+" "+driver.getTitle());
    }
}
