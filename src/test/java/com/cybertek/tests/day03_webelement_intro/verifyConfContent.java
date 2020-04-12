package com.cybertek.tests.day03_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfContent {
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Forgot Password")).click();
        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("test@asd.com");
        String actualaEmail = emailInputBox.getAttribute("value");
        System.out.println("actualaEmail = " + actualaEmail);
        if (actualaEmail.contentEquals("test@asd.com")) {
            System.out.println(" test PASS");
        }
        driver.quit();
    }
}

