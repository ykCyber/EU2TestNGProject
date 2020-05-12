package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Base {
    public static String USER_ID;
    public static String PASSWORD;

    public static void login(WebDriver driver, String userID, String password) {
        String userIdBoxXpath = "prependedInput";
        driver.findElement(By.id(userIdBoxXpath)).sendKeys(userID);
        driver.findElement(By.id("prependedInput2")).sendKeys(password, Keys.ENTER);
    }


    public static void logout(WebDriver driver) {
        driver.findElement(By.id("user-menu")).click();
        driver.findElement(By.linkText("Logout")).click();
        System.out.println("Logout from " + driver.getTitle());
    }
}
