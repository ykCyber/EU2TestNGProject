package com.cybertek.pages;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Base extends TestBase {
    public  static String USER_ID = null;
    public static String PASSWORD = "UserUser123";
    public static void login(WebDriver driver, String userID) {
        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys(userID);
        loginPage.passwordInput.sendKeys(PASSWORD);

        loginPage.loginBtn.click();
    }

    public static void login(WebDriver driver, String userID, String userPassword) {
        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys(userID);
        loginPage.passwordInput.sendKeys(userPassword);
        loginPage.loginBtn.click();
    }

    public static void login(String userID) {

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys(userID);
        loginPage.passwordInput.sendKeys(PASSWORD);

        loginPage.loginBtn.click();
    }

    public static void login(String userID, String userPassword) {

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys(userID);
        loginPage.passwordInput.sendKeys(userPassword);

        loginPage.loginBtn.click();

    }


    public static void logout() {
        driver.findElement(By.id("user-menu")).click();
        driver.findElement(By.linkText("Logout")).click();
        System.out.println("Logout from " + driver.getTitle());
    }

}
