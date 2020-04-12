package com.cybertek.tests.day07_testNGfirstDay;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledButtons {
    @Test
    public void radioTest1() {
        WebDriver driver = WebDriverFactory.getDriver("opera");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        WebElement greenButton = driver.findElement(By.id("green"));
        System.out.println("greenButton.isEnabled() = " + greenButton.isEnabled());
        Assert.assertFalse(greenButton.isEnabled(),"Green Button Disen");
    }
}

