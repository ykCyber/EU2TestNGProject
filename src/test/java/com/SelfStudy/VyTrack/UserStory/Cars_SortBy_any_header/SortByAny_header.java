package com.SelfStudy.VyTrack.UserStory.Cars_SortBy_any_header;

import com.cybertek.utilities.Base;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SortByAny_header {
    WebDriver driver = Driver.get();

    @BeforeMethod
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);


    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://qa1.vytrack.com");
        Base.login(driver,"User16","UserUser123");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]")).click();
        driver.findElement(By.xpath("//li[@class='dropdown-menu-single-item first']//span[@class='title title-level-2'][contains(text(),'Vehicles')]")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement loaderFrame = driver.findElement(By.className("loader-frame"));
        wait.until(ExpectedConditions.invisibilityOf(loaderFrame));
        System.out.println("driver.getTitle() = " + driver.getTitle());
        wait.until(ExpectedConditions.invisibilityOf(loaderFrame));
        driver.findElement(By.xpath("//i[@class='fa-cog hide-text']")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//tbody[1]/tr/td/input"));
        WebElement iconToDrag = driver.findElement(By.xpath("//label[contains(text(),'Tax')]/../..//span//i"));
        //JavascriptExecutor jj = (JavascriptExecutor) driver;
        //jj.executeScript("arguments[0].scrollIntoView();",iconToDrag);

        Actions actions = new Actions(driver);

        actions.moveToElement(iconToDrag).click().build().perform();
        WebElement id = driver.findElement(By.xpath("//tr[1]//td[2]//span[1]//i[1]"));
        Thread.sleep(2000);
        actions.dragAndDrop(iconToDrag, id).click().perform();
        Thread.sleep(2000);
        actions.click().build().perform();
        Thread.sleep(2000);


       // jj.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//label[contains(text(),'Id')]")));
    }
}
