package com.cybertek.tests.day12.actions_jsExecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class hoverTest {
    WebDriver driver = WebDriverFactory.getDriver("opera");

    @BeforeMethod
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        sleep(2000);
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com/status_codes");
        Actions actions = new Actions(driver);
        WebElement elementnt;
        elementnt = driver.findElement(By.linkText("404"));
        actions.moveToElement(elementnt).perform();
        Thread.sleep(3000);
        actions.click().perform();
    }
}
