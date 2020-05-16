package com.cybertek.tests.day014_driver_class;

import com.cybertek.utilities.Base;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void afterMethod () throws InterruptedException{
        Thread.sleep(2000);
    }
    @Test
    public void test(){
        driver.get(ConfigurationReader.get("url"));
        Base.login(driver,"");
    }
}
