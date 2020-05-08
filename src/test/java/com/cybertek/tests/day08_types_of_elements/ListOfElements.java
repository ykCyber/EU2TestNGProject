package com.cybertek.tests.day08_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {
    @Test
     public void test(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.manage().window().maximize();
        List<WebElement> buttons = driver.findElements(By.tagName("buttons"));
        for (WebElement button : buttons) {
            
        }
        Assert.assertTrue(buttons.size() == 6);
        for (WebElement element : buttons) {
            //buttons.get().click();
        }


    }
}
