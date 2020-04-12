package com.cybertek.tests.day06_LocatorsHomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class testCase02 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("opera");
        driver.get("https://ebay.com");
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
        Thread.sleep(300);

        String searchItem = "air pods";
        searchBox.sendKeys(searchItem);
        searchBox.sendKeys(Keys.TAB);
        searchBox.sendKeys(Keys.ENTER);
        boolean flag = driver.getTitle().contains(searchItem);
        driver.get("https://www.amazon.com/");
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(searchItem);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        boolean flag2 = driver.getTitle().contains(searchItem);
        System.out.println("flag EBAY = " + flag);
        System.out.println("searchItem = " + searchItem);
        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("Flag AMAZON "+flag2);
        driver.quit();
    }
}
