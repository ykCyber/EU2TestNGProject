package com.cybertek.tests.day04_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IDlocators {
    public static void main(String[] args) throws InterruptedException {
        /*
        id is always unique
        first locator we are looking for
        refresh page several times if id is static (not changing )
        use it
        */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.manage().window().fullscreen();
        WebElement dontClickButton = driver.findElement(By.id("disappearing_button"));
        dontClickButton.click();
        driver.get("http://practice.cybertekschool.com");
        WebElement signUpPage = driver.findElement(By.xpath("//ul/li[43]/a"));
        signUpPage.click();
        driver.findElement(By.name("full_name")).sendKeys("mike smith");
        Thread.sleep(300);
        driver.findElement(By.name("email")).sendKeys("asd@asd.com");
        Thread.sleep(300);
        driver.findElement(By.xpath("//button")).click();
        String alfa = driver.findElement(By.tagName("h3")).getText();
        System.out.println("alfa = " + alfa);
        if (dontClickButton.isSelected()) {

        }


    }
}
