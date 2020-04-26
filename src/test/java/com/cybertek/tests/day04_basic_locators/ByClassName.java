package com.cybertek.tests.day04_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.management.StandardMBean;
import java.util.List;

public class ByClassName {
    @Test
     public void test(){
        WebDriver driver = WebDriverFactory.getDriver("opera");

        driver.get("https://stackoverflow.com");
        driver.manage().window().fullscreen();
        driver.findElement(By.name("q")).sendKeys("Test Automation");

        driver.findElement(By.name("q")).sendKeys(Keys.TAB);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement result = driver.findElement(By.className("fs-body3"));
        System.out.println(result.getText());

        driver.quit();
    }
}
