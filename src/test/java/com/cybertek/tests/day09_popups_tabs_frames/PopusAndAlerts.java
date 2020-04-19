package com.cybertek.tests.day09_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.cybertek.utilities.WebDriverFactory.getDriver;

public class PopusAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = getDriver("chrome");

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(20000);
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.findElement(By.xpath("//button[.='Destroy the World']")).click();
        Thread.sleep(2500);


        driver.findElement(By.xpath("//button[.='Yes']")).click();
        Thread.sleep(500);
        driver.findElement(By.id("j_idt721:message_container"));



    }
    @Test
     public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
             }


}