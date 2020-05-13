package com.SelfStudy.VyTrack.UserStory14_VehicleModel;

import static com.cybertek.utilities.Base.*;

import com.cybertek.utilities.Base;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Edit_delete_view {
    WebDriver driver = Driver.get();

    WebDriverWait wait = new WebDriverWait(driver,10);
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        sleep(2000);
    }

    @Test
    public void test() {
        driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
        driver.get("https://qa1.vytrack.com");
        Base.login(driver, "salesmanager116", "UserUser123");
        driver.findElement(By.xpath("//span[contains(text(),'Fleet')]")).click();
        driver.findElement(By.xpath("//span[contains(.,'Vehicle Costs')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(""))));

        driver.findElement(By.xpath("(//tr[@class='grid-row row-click-action']//td)[6]")).click();

    }
}
