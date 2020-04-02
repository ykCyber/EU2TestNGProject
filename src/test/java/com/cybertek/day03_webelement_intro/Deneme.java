package com.cybertek.day03_webelement_intro;

import com.cybertek.utilities.WebDriverManuelSetFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Deneme {
    public static void main(String[] args) {
        WebDriver driver = WebDriverManuelSetFactory.getDriver("chrome");
        driver.get("https://google.com");
        WebElement location = driver.findElement(By.className("Q8LRLc"));
        System.out.println("location.getText() = " + location.getText());
    }
}
