package com.cybertek.tests.day08_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.cybertek.utilities.WebDriverFactory.getDriver;

public class SelectClassTest {
    @Test
    public void test() {
        WebDriver driver = getDriver("opera");
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement element = driver.findElement(By.id("state"));
        Select stateDropdown = new Select(element);
        List<WebElement> options = stateDropdown.getOptions();
        for (WebElement option : options) {
            System.out.println("option.getText() = " + option.getText());
        }
        System.out.println("options.size() = " + options.size());

    }

    @Test
    public void test2() {
        WebDriver driver = getDriver("opera");
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement element = driver.findElement(By.id("state"));
        Select stateDropdown = new Select(element);

        stateDropdown.getFirstSelectedOption();
        Assert.assertEquals(stateDropdown.getFirstSelectedOption().getText(), "Select  State");

    }

}
