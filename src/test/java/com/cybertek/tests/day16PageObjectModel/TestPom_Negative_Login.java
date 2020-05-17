package com.cybertek.tests.day16PageObjectModel;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPom_Negative_Login extends TestBase {

//    LoginPage loginPage = new LoginPage();


//    @Test
//    public void test() {
//        loginPage.usernameInput.sendKeys("AlfaBeta");
//        String currentUrl = driver.getCurrentUrl();
//
//        loginPage.passwordInput.sendKeys("somePassord");
//        loginPage.loginBtn.click();
//        String currentUrl1 = driver.getCurrentUrl();
//        Assert.assertEquals(currentUrl, currentUrl1);
//
//    }

    @Test
    public void test2() throws InterruptedException {
        LoginPage.login("user1", "useruser123");

        Base.login("user1");
        Thread.sleep(3000);
        Base.logout();
    }
}
