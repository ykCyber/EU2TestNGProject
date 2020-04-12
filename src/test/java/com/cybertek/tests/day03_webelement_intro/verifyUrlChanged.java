package com.cybertek.tests.day03_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlChanged {
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Forgot Password")).click();
        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("alfa@asd.com");
        driver.findElement(By.id("form_submit")).click();
        System.out.println(driver.findElement(By.name("confirmation_message")).getText());
        driver.quit();

    }
}
