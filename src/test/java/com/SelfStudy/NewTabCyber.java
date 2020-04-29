package com.SelfStudy;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class NewTabCyber {

        @DataProvider
    public  Object[][] isimGetir() {
        String [][] data = new String[3][2];
        data[0][0] = "ahmet";
        data[0][1] = "yılmaz";
        data[1][0] = "mehmet";
        data[1][1] = "çelik";
        data[2][0] = "ali";
        data[2][1] = "er";

        return data ;
    }

    @Test(dataProvider = "isimGetir")
    public void test(String name,String soyisim){
        System.out.println("isim "  + name);
        System.out.println("soyisim " + soyisim);

    }
}
