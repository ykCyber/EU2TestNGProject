package com.SelfStudy.NewTab_ROBOT;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NewTab {
    @Test
    public void test() throws AWTException, InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/status_codes");
        List<WebElement> allCodes = driver.findElements(By.xpath("//div//ul/li/a"));
        List<String> links = new ArrayList<>();
        System.out.println("allLink.size() = " + allCodes.size());
        String handle =null;
        for (WebElement allElement : allCodes) {
            links.add(allElement.getAttribute("href").toString());
        }



        for (int i = 0; i < allCodes.size(); i++) {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_T);
            Thread.sleep(1500);
//Switch focus to new tab
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            Iterator<String> iter = tabs.iterator();
            System.out.println("numbers of tabs "+tabs.size());
            for (int j = 0; j <tabs.size() ; j++) {
                System.out.println("current window's handle  :"+driver.getWindowHandle().toString());
                handle = iter.next();
            }
            System.out.println("new handle handle         :"+ handle);
            System.out.println("--------new tab----------");
            driver.switchTo().window(handle);
//Launch URL in the new tab
            driver.get(links.get(i));
        }

//            driver.quit();

    }
}
