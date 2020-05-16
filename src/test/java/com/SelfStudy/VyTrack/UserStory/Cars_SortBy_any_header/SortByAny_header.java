package com.SelfStudy.VyTrack.UserStory.Cars_SortBy_any_header;

import com.cybertek.utilities.Base;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SortByAny_header {
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
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // wait until titles are clickable
        wait.until(ExpectedConditions.elementToBeClickable(titleToSort));
        //use js to click
        js.executeScript("arguments[0].click();", titleToSort);
        wait.until(ExpectedConditions.elementToBeClickable(titleToSort));
        // second click to sort descending
        js.executeScript("arguments[0].click();", titleToSort);
        //when we click any title grid Url changes wait until grid url changed to expected( don't forgot to remove spaces
        wait.until(ExpectedConditions.urlContains(headerTitle.replace(" ", "")));
        // now u can get the sorted list
        List<WebElement> elements = driver.findElements(By.xpath("//td[@data-column-label='" + headerTitle + "']"));
        System.out.println(elements.size());
        int i = 0;
        for (WebElement element : elements) {
            System.out.println("element.getText() line = "+ (++i)+" "+ element.getText());
        }
    }
}
