package com.SelfStudy.Others;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
public class SingletonConfiguration {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }
    @Test
    public void test1() throws InterruptedException, AWTException {
        //https://qa3.vytrack.com run this page.
        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.xpath("//input[@id='prependedInput']")).sendKeys(ConfigurationReader.get("salesmanager_username"));
        driver.findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys(ConfigurationReader.get("salesmanager_password"));
        driver.findElement(By.id("_submit")).click();
        System.out.println(driver.getTitle());
        //open new tab
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_T);
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        Thread.sleep(3000);
        //switch to new tab
        driver.switchTo().window(windowHandles.get(1));
        Thread.sleep(2000);
        //turn back
        driver.switchTo().window(windowHandles.get(0));
        //Click Vehicle costs on the Fleet module
        String str="//span[@class='title title-level-1'][contains(text(),'Fleet')]";
        WebElement element = driver.findElement(By.xpath(str));
        Actions actions=new Actions(driver);
        actions.moveToElement(element).perform();
        System.out.println("driver.findElement(By.xpath(\"//span[contains(text(),'Vehicle Costs')]\")).getAttribute(\"href\") = " + driver.findElement(By.xpath("//span[contains(text(),'Vehicle Costs')]")).getAttribute("href"));
        Thread.sleep(2000);
        //do it Vehicle costs page on new Tab; Question is I could not do it on new tab ???
        String windowHandle = driver.getWindowHandle();
        for (String handle : windowHandles) {
            if(!handle.equals(windowHandle)){
                driver.switchTo().window(handle);
            }
        }
    }
}