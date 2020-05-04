package com.cybertek.tests.day13;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class HomeWorkHoverAndVerifyIsDisplayed {
    WebDriver driver = WebDriverFactory.getManuelDriver("chrome");
//    WebDriver driver = WebDriverFactory.getDriver("chrome");

    @BeforeMethod
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterClass
    public void afterMethod() throws InterruptedException {
        sleep(2000);
        driver.close();
    }

    @Test
    public void VerifyUserNameDisplayed() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        //liste olarak  uzerine gidecegimiz elemanlari aliyoruz
        List<WebElement> img = driver.findElements(By.xpath("//img"));
        System.out.println("img.size() = " + img.size());

        //Liste olarak tasdik edecegemiz elementleri aliyoruz
        List<WebElement> userName = driver.findElements(By.xpath("//div[@class='figcaption']/h5"));
        System.out.println("userName.size() = " + userName.size());


        ListIterator<WebElement> iterator = userName.listIterator();
        Actions actions = new Actions(driver);

        for (WebElement element : img) {
            Thread.sleep(300);
            WebElement webElement = iterator.next();
            if (iterator.nextIndex()==2){
                System.out.println(iterator.nextIndex()+" skipped by if continue");
                continue;
            }
            actions.moveToElement(element).perform();
            System.out.println("elementa.getText() = " + webElement.getText().split(" ")[1]);
            Assert.assertTrue(webElement.isDisplayed(), "is displayed?");

        }
    }
}
