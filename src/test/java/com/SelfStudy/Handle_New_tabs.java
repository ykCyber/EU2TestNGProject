package com.SelfStudy;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class Handle_New_tabs {
    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("opera");
        driver.get("https://practice-cybertekschool.herokuapp.com/open_new_tab");
        WebDriverWait wait = new WebDriverWait(driver,10 );
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("msg"))));
        List<String> handles = (List<String>) driver.getWindowHandles();


    }
}
