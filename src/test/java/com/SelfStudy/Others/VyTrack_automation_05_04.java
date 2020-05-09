package com.SelfStudy.Others;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class VyTrack_automation_05_04 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    @Test
    public void Test1() throws InterruptedException {
        //navigate to "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract"
        driver.get("https://qa1.vytrack.com/");
        //Use credentials to login
        WebElement userNameBox = driver.findElement(By.id("prependedInput"));
        userNameBox.sendKeys("storemanager61");
        WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(5000);

        //fullscreen
        driver.manage().window().maximize();

        //hover over Fleet module then Hover over to Vehicle Contracts module and click
        Actions action = new Actions(driver);
        WebElement element1 = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        WebElement element2 = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[6]"));
        action.moveToElement(element1).pause(1000).perform();
        action.moveToElement(element2).pause(2000).click().perform();
        Thread.sleep(10000);

        //locate contract and click on it
        driver.findElement(By.xpath("//*[.='Halim Smith']")).click();

        //Verify that you get your vehicle info successfully
        String actualVehicleInfo = driver.findElement(By.xpath("//h1[@class='user-name']")).getText();
        String expectedVehicleInfo = "Halim Smith Vendor Driver Smith Muhammet Ali";
        Assert.assertTrue(actualVehicleInfo.contentEquals(expectedVehicleInfo),"verify vehicle info");
        System.out.println("expectedVehicleInfo = " + expectedVehicleInfo);
        System.out.println("actualVehicleInfo = " + actualVehicleInfo);

//       verify that you edit one vehicle contract info add new info and verify you made changes

        //locate edit button and click
        WebElement editButton = driver.findElement(By.xpath("//a[@title='Edit Vehicle Contract']"));
        editButton.click(); //we can also do this action in previous line
        //locate VehiclesModel button and click
       // WebElement VehiclesModelButton = driver.findElement(By.xpath("//a[.='VehiclesModel']"));
        //use actions to click on VehiclesModel button
       // Actions actions = new Actions(driver);
        //actions.moveToElement(VehiclesModelButton).click().perform();
        Thread.sleep(2000);

        //locate 1st add button and click
        WebElement AddButton1 = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        AddButton1.click();
        Thread.sleep(2000);
        //handle the new window
        String currentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles.size());
//        for (String handle : windowHandles) {
//            if (!handle.equals(windowHandles)){
//                System.out.println(windowHandles.toString());
//                System.out.println(handle);
//                driver.switchTo().window(handle);
//            }
//        }
        //locate any element (Accord) and click on it then click on select button
        WebElement checkBoxItem = driver.findElement(By.xpath("//tbody/tr[12]/td[1]"));
        checkBoxItem.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[.='Select'])[2]")).click();
        Thread.sleep(2000);
        //switch first window
        driver.switchTo().window(currentWindow);
        //locate and verify model name is displayed
        String expectedName = "Model Name: Accord";
        WebElement modelName = driver.findElement(By.xpath("//*[.='Model Name: Accord']"));
        Assert.assertTrue(modelName.isDisplayed(),"verify that model name is displayed");
        Assert.assertTrue(expectedName.contentEquals(modelName.getText()),"verify that modelName is equal to our expected name");


    }

}