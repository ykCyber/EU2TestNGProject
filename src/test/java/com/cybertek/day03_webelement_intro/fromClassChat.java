package com.cybertek.day03_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class fromClassChat {
    public static void main(String[] args) {
        /**
         * Verify confirmation message
         * open browser
         * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
         * enter any email
         * verify that email is displayed in the input box
         * click on Retrieve password
         * verify that confirmation message says 'Your e-mail's been sent!'
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement emailInputBox = driver.findElement(By.name("email"));
        String expectedEmail = "test@cybertekschool.com";
        emailInputBox.sendKeys(expectedEmail);
        //somehow we should get text from webelements
        //two main ways to get text from web elements
        //1.getText()--> it will work %99 and it will return string
        //2.getAttribute("value")--> second way of getting text especially inputboxes
        String actualEmail = emailInputBox.getAttribute("value");
        //verify email is displayed
        if (actualEmail.equals(expectedEmail)) {
            System.out.println("actualEmail = " + actualEmail);
            System.out.println("expectedEmail = " + expectedEmail);
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("actualEmail = " + actualEmail);
            System.out.println("expectedEmail = " + expectedEmail);
        }
    }
}

