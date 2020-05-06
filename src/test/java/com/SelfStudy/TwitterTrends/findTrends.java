package com.SelfStudy.TwitterTrends;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class findTrends {
    WebDriver driver = WebDriverFactory.getManuelDriver("chrome");

    @BeforeMethod
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test() {
        driver.get("https://twitter.com/explore");
        List<WebElement> trends = driver.findElements(By.xpath("//section[1]/div[1]/div[1]/div"));
        for (WebElement trend : trends) {
            System.out.println("trend.toString() = " + trend.getText());
        }
    }
}
