package com.cybertek.tests.day07_testNG;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.accessibility.AccessibleSelection;

public class radioButtons {
@Test
    public void radioTest1(){
    WebDriver driver = WebDriverFactory.getDriver("opera");
    driver.get("http://practice.cybertekschool.com/radio_buttons");
    driver.manage().window().maximize();
    WebElement blueRadioButton = driver.findElement(By.cssSelector("#blue"));
    WebElement redRadioButton = driver.findElement(By.id("red"));
    Assert.assertTrue(blueRadioButton.isSelected(),"Verify Blue is selected");
    Assert.assertFalse(redRadioButton.isSelected(),"Verify Res is not selected");
    redRadioButton.click();
    Assert.assertTrue(blueRadioButton.isSelected(),"Verify Blue is selected");
    Assert.assertFalse(redRadioButton.isSelected(),"Verify Res is not selected");

    driver.quit();
}
}
