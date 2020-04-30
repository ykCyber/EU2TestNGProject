package com.SelfStudy;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.awt.event.KeyEvent.*;

public class Mackolik {
//    WebDriver driver = WebDriverFactory.getDriver("chrome");
//
//    @BeforeMethod
//    public void setUp() {
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }
//
//    @AfterMethod
//    public void afterMethod() throws InterruptedException {
//        Thread.sleep(2000);
//    }

    @Test
    public void test() throws AWTException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.mackolik.com/");
      //  driver.findElement(By.cssSelector("a[data-ga-label=\"Futbol\"]")).click();
        driver.findElement(By.xpath("(//ul//li//a[1])[2]")).click();
        driver.findElement(By.xpath("(//ul//li//a[1])[2]")).sendKeys(Keys.TAB , Keys.ENTER);
       // driver.findElement(By.xpath("(//div[contains(.,' Kabul Et ')]//a)[2]")).click();
        Robot robot = new Robot();
        robot.mouseWheel(15);
        List<WebElement> clubNames = driver.findElements(By.xpath("//tbody//tr//td[3]"));
        List<WebElement> clubWon = driver.findElements(By.xpath("//tbody//tr//td[6]"));
        List<WebElement> clubDeuce = driver.findElements(By.xpath("//tbody//tr//td[7]"));
        List<WebElement> clubPoints = driver.findElements(By.xpath("//tbody//tr//td[12]"));

        for (int i = 0; i < clubNames.size(); i++) {
            String name = clubNames.get(i).getText();
            int won = Integer.parseInt(clubWon. get(i).getText().trim());
            int deuce = Integer.parseInt(clubDeuce.get(i).getText().trim());
            int point = Integer.parseInt(clubPoints.get(i).getText().trim());
            System.out.printf("%s %nPoints :%3d   Won: %3d   Deuce :%3d%n", name, point, won, deuce);
            Assert.assertTrue(((won * 3) + deuce) == point, name + " point's is wrong ");

//            System.out.println(clubNames.get(i).getText() + " puan " + clubPoints.get(i).getText() + "Puan");
//            System.out.println(clubNames.get(i).getText() + " beraberlik " + clubDeuce.get(i).getText() + "Puan");
//            System.out.println(clubNames.get(i).getText() + " galibiyet " + clubWon.get(i).getText() + "Puan");
        }

        driver.quit();
    }
}
