package com.cybertek.tests.day03_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class googleLocation {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com");
        String location = driver.findElement(By.xpath("//span[@class='Q8LRLc']")).getText();
        System.out.printf("location = ", location.toString());
        driver.quit();
    }
}
