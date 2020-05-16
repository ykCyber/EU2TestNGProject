package com.SelfStudy.VyTrack.UserStory14_VehicleModel;

import com.cybertek.utilities.Base;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class JavaScriptClick {
    WebDriver driver = WebDriverFactory.getDriver("chrome");


    @AfterMethod
    public void afterMethod() throws InterruptedException {
        sleep(2000);
    }

    @Test
    public void test() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://qa1.vytrack.com");
        Base.login(driver, "salesmanager116");
        driver.findElement(By.xpath("//span[contains(text(),'Fleet')]")).click();
        Thread.sleep(200);

        driver.findElement(By.xpath("//span[contains(.,'Vehicle Costs')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='loader-frame']"))));


        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement lineTREE = driver.findElement(By.cssSelector(".grid-row:nth-child(3) .dropdown-toggle"));
        js.executeScript("arguments[0].click();", lineTREE);
        WebElement element = driver.findElement(By.xpath("(//li//ul[@class='nav nav-pills icons-holder launchers-list']/li/a)[1]"));
        js.executeScript("arguments[0].click();", element);//


    }
}
