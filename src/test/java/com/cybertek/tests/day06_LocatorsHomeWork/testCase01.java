package com.cybertek.tests.day06_LocatorsHomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class testCase01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://ebay.com");
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
        Thread.sleep(300);
        searchBox.sendKeys("airpods");
        driver.findElement(By.id("gh-btn")).click();
        System.out.println(driver.findElement(By.xpath("//h1/span")).getText());
    }
}