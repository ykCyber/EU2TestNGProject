package com.SelfStudy.ParalelTestingDemo;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParallelTesting {



    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);

    }

    @Test
    public void test() throws AWTException, InterruptedException {
    WebDriver driver1 = WebDriverFactory.getDriver("chrome");
        driver1.get("https://practice-cybertekschool.herokuapp.com/status_codes");
        List<WebElement> allCodes = driver1.findElements(By.xpath("//div//ul/li/a"));
        List<String> links = new ArrayList<>();
        System.out.println("allLink.size() = " + allCodes.size());
        String handle =null;
        for (WebElement allElement : allCodes) {
            links.add(allElement.getAttribute("href"));
        }



        for (int i = 0; i < allCodes.size(); i++) {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_T);
            Thread.sleep(1500);
//Switch focus to new tab
            ArrayList<String> tabs = new ArrayList<>(driver1.getWindowHandles());
            Iterator<String> iter = tabs.iterator();
            System.out.println("numbers of tabs "+tabs.size());
            for (int j = 0; j <tabs.size() ; j++) {
                System.out.println("current window's handle  :"+ driver1.getWindowHandle());
                handle = iter.next();
            }
            System.out.println("new handle handle         :"+ handle);
            System.out.println("--------new tab----------");
            driver1.switchTo().window(handle);
//Launch URL in the new tab
            driver1.get(links.get(i));
        }

            driver1.quit();

    }

    
    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("opera");
        driver.get("https://www.youtube.com/watch?v=KcDhx0e2wns");
        String currentUrl = driver.getCurrentUrl();
        String title = driver.getTitle();
        System.out.println("title = " + title);
        System.out.println("currentUrl = " + currentUrl);
        Assert.assertTrue(title.contains(currentUrl));
    }
}
