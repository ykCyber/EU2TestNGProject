package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Base {
    public static String USER_ID;
    public static String PASSWORD= "UserUser123";

    public static void login(WebDriver driver, String userID) {
       driver.get("https://qa1.vytrack.com");
        String userIdBoxXpath = "prependedInput";
        driver.findElement(By.id(userIdBoxXpath)).sendKeys(userID);
        driver.findElement(By.id("prependedInput2")).sendKeys(PASSWORD, Keys.ENTER);
    }


    public static void logout(WebDriver driver) {
        driver.findElement(By.id("user-menu")).click();
        driver.findElement(By.linkText("Logout")).click();
        System.out.println("Logout from " + driver.getTitle());
    }

}
