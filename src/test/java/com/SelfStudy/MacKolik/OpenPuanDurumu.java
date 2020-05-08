package com.SelfStudy.MacKolik;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenPuanDurumu {


    @DataProvider
    public static Object[][] list() {
        return new Object[][]{{"FenerBahce", 5, 85.1533687d}, {"TSpor", 40, 123456.123456789}};
    }

    @BeforeMethod
    public void setUp() {

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(dataProvider = "list")
    public void test(String teamName, int score, double avarageHeiht) {
        System.out.printf("%-10S   point:%3d    heihgt :%10.2f", teamName, score, avarageHeiht);

    }
}
