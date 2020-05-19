package com.SelfStudy.Homework;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class vytrackBasePageTestBase extends TestBase {
    LoginPage loginPage = new LoginPage();
    String usernameStr = ConfigurationReader.get("salesmanager_username");
    String passwordStr = ConfigurationReader.get("salesmanager_password");

    @Test(priority = 1)
    public void loginVytrack() {
        //login yap salesmanager credentials ile
        loginPage.login(usernameStr, passwordStr);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");
        logOut();
    }

    @Test(priority = 2)
    public void tabModuleTest() {
        //Fleet module altındaki vehicle costa git
        loginPage.login(usernameStr, passwordStr);
        String tab = "Fleet";
        String module = "Vehicle Costs";
        navigateToModule(tab, module);
        System.out.println(getPageSubTitle());
        Assert.assertEquals(getPageSubTitle(), "Vehicle Costs", "verification is true");
        logOut();
    }

    @Test(priority = 3)
    public void fileSave() throws InterruptedException {
        //burda bulunan gear sekmesini tıkla
        loginPage.login(usernameStr, passwordStr);
        String tab = "Fleet";
        String module = "Vehicle Costs";
        navigateToModule(tab, module);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@href='#'])[24]")).click();
        Thread.sleep(5000);
        logOut();
    }
}