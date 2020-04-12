package com.cybertek.tests.day06_LocatorsHomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class testCase03 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        String searchKey ="selenium webdriver";
        searchBox.sendKeys(searchKey);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button/i[1]")).click();
        driver.findElement(By.xpath("//a[@title='Selenium (software)']")).click();
        String testURL = driver.getCurrentUrl();
        String result = testURL.split("wiki/")[1];
        System.out.println("result = " + result);
        System.out.println("result = " + result);


    }
}
