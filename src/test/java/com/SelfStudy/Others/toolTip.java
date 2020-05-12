package com.SelfStudy.Others;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class toolTip {
    WebDriver driver = WebDriverFactory.getManuelDriver("chrome");
    @BeforeMethod
    public void setUp(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void afterMethod () throws InterruptedException{
        Thread.sleep(2000);
    }
    @Test
    public void test() throws AWTException {
        driver.get("http://demo.guru99.com/test/tooltip.html");
        WebElement download = driver.findElement(By.id("download_now"));
        Robot robot = new Robot();
        Actions actions = new Actions(driver);
        actions.moveToElement(download).build().perform();
        WebElement result = driver.findElement(By.cssSelector("[class^='tooltip']>a"));
        System.out.println("result.getText() = " + result.getText());
    }
}
