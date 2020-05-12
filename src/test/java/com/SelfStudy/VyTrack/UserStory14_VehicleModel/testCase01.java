package com.SelfStudy.VyTrack.UserStory14_VehicleModel;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class testCase01 {
    WebDriver driver;

    @DataProvider(name="credentials") // truck driver credentials
    public static Object[][] credentials() {

        return new Object[][]{
                {"salesmanager116", "UserUser123"}

                 };
    }
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("opera");
        driver.get("https://qa1.vytrack.com");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
    @Test(dataProvider = "credentials")
    public void loginAsTruckDriver(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        System.out.println("Before clicking submit Title : " + driver.getTitle());
        driver.findElement(By.id("_submit")).click();
        System.out.println("Aftere clicking submit Title : " + driver.getTitle());
//        WebElement bar = driver.findElement(By.className("bar"));
//        WebElement h3 = driver.findElement(By.xpath("//h3"));
//        System.out.println("h3.toString() = " + h3.toString());
//        System.out.println(bar.toString());
//        System.err.println("--------------------");
//        System.out.println("h3.isDisplayed() = " + h3.isDisplayed());
//        System.err.println("--------------------");
//        System.out.println("h3 Text = " + h3.getText().trim());
//        System.err.println("--------------------");
//        System.out.println("bar.isDisplayed() = " + bar.isDisplayed());
//        System.err.println("--------------------");
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        System.out.println(" Title :" + driver.getTitle());
//        System.out.println("After title is Dashboar is displayed:" + bar.isDisplayed());
//
//        System.err.println("--------------------");
//        System.out.println("bar.isDisplayed() = " + bar.isDisplayed());
//        System.err.println("--------------------");
//        System.out.println("h3.isDisplayed() = " + h3.isDisplayed());
//        System.err.println("--------------------");
//        System.out.println("h3.getText().trim() = " + h3.getText().trim());
//        System.err.println("--------------------");
        WebElement actualResult = driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Zion Schaefer')]"));
        System.out.println(actualResult.getText());

    }
}