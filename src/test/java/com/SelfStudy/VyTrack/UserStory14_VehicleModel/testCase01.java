package com.SelfStudy.VyTrack.UserStory14_VehicleModel;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/*1.Verify that store manager or sales manager should be able to access Vehicle model page and
        able to see all Vehicles model information*/
public class testCase01 {
//Negative scenerio Login as a Truck Driver

     WebDriver driver;

    @DataProvider// truck driver credentials
      public static Object[][] credentials() {

        return new Object[][]{
                {"user16", "UserUser123" },
                {"user17", "UserUser123" },
                {"user18", "UserUser123" }
        };
    }

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getManuelDriver("chrome");

        driver.get("https://qa1.vytrack.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @AfterTest
    public void aftertest() throws InterruptedException {

        System.out.println("after test");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        driver.quit();
        System.out.println("after method");
    }

    @Test(dataProvider = "credentials")
    public void loginAsTruckDriver(String username, String password) throws InterruptedException {

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        System.out.println("driver.getTitle() = " + driver.getTitle());
        driver.findElement(By.id("_submit")).click();
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        WebElement fleet = driver.findElement(By.xpath("//span[contains(text(),'Fleet')]"));
        System.out.println("fleet.getText() = " + fleet.getText());
        Actions actions = new Actions(driver);
        actions.moveToElement(fleet).perform();

        System.out.println("driver.getTitle() = " + driver.getTitle());


    }
}
