package com.cybertek.tests.day08_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicElements {
    @Test
    public void test() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("opera");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement userNameInput = driver.findElement(By.id("username"));
        Assert.assertFalse(userNameInput.isDisplayed(), " isDisplayed");
        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();
        Thread.sleep(500);
        WebElement loadImg = driver.findElement(By.cssSelector("#loading>img"));
        Thread.sleep(500);
        Assert.assertTrue(loadImg.isDisplayed(),"verify load img is displayed");
        Thread.sleep(8000);

        Assert.assertTrue(userNameInput.isDisplayed(), " verify isDisplayed");

        driver.quit();

    }
}
