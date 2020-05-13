package com.SelfStudy.Others;

import com.cybertek.utilities.Base;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckLinks {

    static WebDriver driver = WebDriverFactory.getDriver("chrome");

    @DataProvider
    public static Object[][] data() {
        Base.login(driver, "user16", "UserUser123");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        List<WebElement> toGetSubModuleTitles = driver.findElements(By.xpath("//span[@class='title title-level-2']"));
        List<WebElement> toGetSubModuleLinks = driver.findElements(By.xpath("//span[@class='title title-level-2']/.."));

//        List<String> subModuleTitles = new ArrayList<>();
//        List<String> subModulesLinks = new ArrayList<>();

        String[][] data = new String[toGetSubModuleLinks.size()][];
        System.out.println("data.size = " + data.length);

        for (int i = 0; i <data.length ; i++) {
            data[i][1] = toGetSubModuleLinks.get(i).getAttribute("href");
        }
        for (WebElement e : toGetSubModuleTitles) {
           // subModuleTitles.add(e.getAttribute("textContent"));
            //getText çalışmadı innerText çalışmadı
            //textContent çalıştı


        }
        for (WebElement s : toGetSubModuleLinks) {
            //linklerin hepsini arraye alıyoruz
        }

        return data;
    }


    @BeforeMethod
    public void setUp() {
        Base.login(driver, "user16", "UserUser123");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
    }
    @Test(dataProvider = "data")
    public void test1(String link, String title) {
        driver.get(link);




    }
    @Test(dataProvider = "data")
    public void test(String link, String title) {

        List<WebElement> toGetSubModuleLinks = driver.findElements(By.xpath("//span[@class='title title-level-2']/.."));
        List<WebElement> toGetSubModuleTitles = driver.findElements(By.xpath("//span[@class='title title-level-2']"));

        List<String> subModuleTitles = new ArrayList<>();
        List<String> subModulesLinks = new ArrayList<>();
        //textlerini almak için foreach döngüsü
        for (WebElement e : toGetSubModuleTitles) {
            subModuleTitles.add(e.getAttribute("textContent"));
            //getText çalışmadı innerText çalışmadı
            //textContent çalıştı
        }
        for (WebElement s : toGetSubModuleLinks) {
            //linklerin hepsini listeye alıyoruz
            subModulesLinks.add(s.getAttribute("href"));
        }
        Iterator<String> iterator = subModuleTitles.iterator();
        for (String l : subModulesLinks) {
            String expectedResult = iterator.next();

            driver.get(l);
            String actualResult = driver.getTitle();
        }
        driver.quit();
    }

}
