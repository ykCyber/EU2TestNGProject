package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    @FindBy(id = "prependedInput")
    public static WebElement usernameInput;
    @FindBy(id = "prependedInput2")
    public static WebElement passwordInput;
    @FindBy(id = "_submit")
    public static WebElement loginBtn;

    public LoginPage() {
        PageFactory.initElements((Driver.get()), this);
    }

    public static void login(String usernameStr, String passwordStr) {
        usernameInput.sendKeys(usernameStr);
        passwordInput.sendKeys(passwordStr);
        loginBtn.click();
    }

}