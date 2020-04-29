package com.SelfStudy;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Mackolik {
    //WebDriver driver = WebDriverFactory.getDriver("chrome");

//    @BeforeMethod
//    public void setUp() {
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }

//    @AfterMethod
//    public void afterMethod() throws InterruptedException {
//        Thread.sleep(2000);
//    }

    @Test
    public void test() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.mackolik.com/puan-durumu/t%C3%BCrkiye-s%C3%BCper-lig/482ofyysbdbeoxauk19yg7tdt");
        List<WebElement> clubNames = driver.findElements(By.xpath("//tbody//tr//td[3]"));
        List<WebElement> clubPoints = driver.findElements(By.xpath("//tbody//tr//td[12]"));
        for (int i = 0; i < clubNames.size(); i++) {
            System.out.println(clubNames.get(i).getText() + " " + clubPoints.get(i).getText() + "Puan");
        }
    }
}


