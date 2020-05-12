package com.SelfStudy.TwitterTrends;

import com.beust.jcommander.IStringConverter;
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
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    private final String numOfLikesXpath="//div[2]/div[3]/div[3]//div[2]/span[1]/span[1]";
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
    public void test() throws InterruptedException {
        driver.get("https://twitter.com/explore");
        List<WebElement> trends = driver.findElements(By.xpath("//section[1]/div[1]/div[1]"));
        for (WebElement trend : trends) {
            System.out.println("trend.getText() = " + trend.getText());
            trend.click();
            List<WebElement> elements = driver.findElements(By.xpath(numOfLikesXpath));
            elements.get(0).click();
            Thread.sleep(1000);
            break;
        }

    }
}
