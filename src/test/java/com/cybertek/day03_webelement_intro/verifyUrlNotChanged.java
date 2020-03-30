package com.cybertek.day03_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlNotChanged {
    public static void main(String[] args) throws InterruptedException {

        //
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        // WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password"));
        Thread.sleep(5000);
        forgotPasswordLink.click();
        String firstURl = driver.getCurrentUrl();
        Thread.sleep(5000);
        driver.findElement(By.id("form_submit")).click();
        driver.manage().window().fullscreen();
        String lastUrl = driver.getCurrentUrl();
        System.out.println(lastUrl.contentEquals(firstURl));
        driver.quit();


    }
}
























