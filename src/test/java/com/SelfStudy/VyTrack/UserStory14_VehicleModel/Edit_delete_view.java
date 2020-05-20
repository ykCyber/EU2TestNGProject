package com.SelfStudy.VyTrack.UserStory14_VehicleModel;

import com.cybertek.pages.Base;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Edit_delete_view {
    WebDriver driver = WebDriverFactory.getDriver("chrome");


    @AfterMethod
    public void afterMethod() throws InterruptedException {
        sleep(2000);
    }

    @Test
    public void test() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://qa1.vytrack.com");
        Base.login(driver, "salesmanager116");
        //sayfayı açtık lagin olduk
        driver.findElement(By.xpath("//span[contains(text(),'Fleet')]")).click();
        Thread.sleep(200);

        //fleet--vehicle costs a tıkladık
        driver.findElement(By.xpath("//span[contains(.,'Vehicle Costs')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //  tablo görününene kadar bekle
        //wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//th"))));
        //veya ortada dönen loader frame yok olana kadar bekle
        //aksi takdirde bazen hata veriyor
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='loader-frame']"))));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        WebElement buttonToclick;

        //istediğimiz line'ı bulup relative xpath yoluyla en sağdaki üç noktaya geçiyoruz
        WebElement cssIleSıraUc = driver.findElement(By.cssSelector(".grid-row:nth-child(3) .dropdown-toggle"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //kar lastiği ile ilgi bir satır vardı orayı Texten locate edip parentına gidip //td//div ile
        // o satırın en sağında bulunan ... üç noktayı locate ediyoruz
        buttonToclick = driver.findElement(By.xpath("//td[contains(.,'Snow')]/../td/div"));
//        js.executeScript("arguments[0].click();", buttonToclick);
        js.executeScript("arguments[0].click();", cssIleSıraUc);/*
        js ile tıklıyoruz üç noktaya tıklayınca
        view edit delete seçenekleri çıkıyor
        //li//ul[@class='nav nav-pills icons-holder launchers-list']/li/a (view-edit ve delete ın bulunduğu bölüm )
        parantez içine alıp view için 1 edit için 2 delete için 3 ü locate edip Js ile tıklıyoruz
        WebElement element = driver.findElement(By.xpath("(//li//ul[@class='nav nav-pills icons-holder launchers-list']/li/a)[1]"));
        WebElement element = driver.findElement(By.xpath("(//li//ul[@class='nav nav-pills icons-holder launchers-list']/li/a)[2]"));

 */
        WebElement element = driver.findElement(By.xpath("(//li//ul[@class='nav nav-pills icons-holder launchers-list']/li/a)[3]"));
        js.executeScript("arguments[0].click();", element);//


    }
}
