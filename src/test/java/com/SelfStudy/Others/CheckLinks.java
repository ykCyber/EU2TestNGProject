package com.SelfStudy.Others;

import com.cybertek.pages.Base;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckLinks {

    static WebDriver driver = WebDriverFactory.getDriver("chrome");

    @DataProvider
    public static Object[][] data() {
        Base.login(driver, "user16");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        List<WebElement> toGetSubModuleTitles = driver.findElements(By.xpath("//span[@class='title title-level-2']"));
        List<WebElement> toGetSubModuleLinks = driver.findElements(By.xpath("//span[@class='title title-level-2']/.."));
        Object[][] data = new Object[toGetSubModuleLinks.size()][2];
        int i = 0;
        for (WebElement e : toGetSubModuleTitles) {
            data[i][0] = e.getAttribute("textContent");
            i++;
        }
        i = 0;
        for (WebElement e : toGetSubModuleLinks) {
            data[i][1] = e.getAttribute("href");
            i++;
        }
        return data;
    }

    @Test(dataProvider = "data")
    public void test1(String link, String title) {
        System.out.printf("%S  %s\n", link, title);
    }

    @Test(dataProvider = "data")
    public void Smoke(String title, String link){
        driver.get(link);
        Assert.assertTrue(driver.getTitle().contains(title)," "+driver.getTitle());

    }

}
