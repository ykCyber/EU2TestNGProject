package com.SelfStudy.VyTrack.UserStory.Cars_SortBy_any_header;

import com.cybertek.pages.Base;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SortByAny_header_WebDriverClick {
    WebDriver driver = Driver.get();

    @BeforeMethod
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);


    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test
    public void test() {
        driver.get("https://qa1.vytrack.com");
        //login to page
        Base.login(driver, "User16");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        //Find Vehicles modules link
        String link = driver.findElement(By.xpath("//*[text()='Vehicles']/..")).getAttribute("href");
        // goto link that u find
        driver.get(link);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // locate loader frame
        WebElement loaderFrame = driver.findElement(By.className("loader-frame"));
        // wait until loaderFrame is invisible
        wait.until(ExpectedConditions.invisibilityOf(loaderFrame));
        System.out.println("driver.getTitle() = " + driver.getTitle());
        //store url to wait
        //String oldUrl = driver.getCurrentUrl();
        String headerTitle = "Last Odometer";
        // find the header which contains headerTitle
        WebElement titleToSort = driver.findElement(By.xpath("//span[@class='grid-header-cell__label'][contains(text(),'" + headerTitle + "')]"));
        titleToSort.click();

        wait.until(ExpectedConditions.urlContains("3D1"));
        String oldUrl = driver.getCurrentUrl();
        titleToSort.click();
        wait.until(ExpectedConditions.urlContains("%255D%3D-1"));
        wait.until(ExpectedConditions.invisibilityOf(loaderFrame));
        wait.until(ExpectedConditions.invisibilityOf(loaderFrame));
        wait.until(ExpectedConditions.invisibilityOf(loaderFrame));
        wait.until(ExpectedConditions.invisibilityOf(loaderFrame));

        List<WebElement> elements = driver.findElements(By.xpath("//td[@data-column-label='" + headerTitle + "']"));


        System.out.println(elements.size());
        int i = 0;
        for (WebElement element : elements) {
            wait.until(ExpectedConditions.stalenessOf((WebElement) elements));
            elements = driver.findElements(By.xpath("//td[@data-column-label='" + headerTitle + "']"));
            System.out.println("element.getText() line = " + (++i) + " " + element.getText());
        }
    }
}
