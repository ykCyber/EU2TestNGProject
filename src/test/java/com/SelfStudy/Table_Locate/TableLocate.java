package com.SelfStudy.Table_Locate;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TableLocate {
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    @BeforeMethod
    public void setUp(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void afterMethod () throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test() {
        driver.get("http://practice.cybertekschool.com/tables");
        WebElement element = findCell(10, 10);
        System.out.println(element.getText());

    }

    public WebElement findCell(int colNumber, int rowNumber) {
        driver.get("http://practice.cybertekschool.com/tables");
        int totalRawNumber = driver.findElements(By.xpath("(//tbody)[1]//tr")).size();
        int totalColomNumber = driver.findElements(By.xpath(("(//tr)[1]//th"))).size();

        Assert.assertTrue(colNumber<=totalColomNumber,"you entered wrong value for row number"+colNumber +" > "+totalColomNumber);
        Assert.assertTrue(rowNumber<=totalRawNumber,  "you entered wrong value for colom number"+rowNumber +" > "+totalRawNumber);
        int x = ((rowNumber - 1) * totalColomNumber) + colNumber;
        String location = "((//tbody)[2]//td)[" + x + "]";
        return driver.findElement(By.xpath(location));
    }
}
