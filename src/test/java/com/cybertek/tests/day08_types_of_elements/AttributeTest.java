package com.cybertek.tests.day08_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import com.google.gson.internal.$Gson$Types;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
     public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("opera");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement radioButton = driver.findElement(By.id("blue"));
        System.out.println(radioButton.getAttribute("type"));
        System.out.println(radioButton.getAttribute("name"));
        System.out.println(radioButton.getAttribute("href"));
        System.out.println(radioButton.getAttribute("outerHTML"));
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement element = driver.findElement(By.xpath("//button[6]"));
        System.out.println(element.getAttribute("outerHTML")+"    value");
        System.out.println("end off code");
        driver.quit();

    }
}
