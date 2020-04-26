package com.cybertek.tests.day11_File_Upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class FileUpload {
    WebDriver driver = WebDriverFactory.getDriver("chrome");

    @BeforeMethod
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        sleep(2000);
    }

    @Test
    public void test() {
        driver.get("http://practice.cybertekschool.com/upload");
//        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Mustafa\\Desktop\\asd.txt");
        System.out.println(System.getProperty("user.dir"));
        String projectPath = System.getProperty("user.dir");
        String relativePath = "src\\test\\resources\\testfile.txt";
        System.out.println("relativePath = " + relativePath);
        String filePath = (projectPath + "\\"+ relativePath);
        System.out.println("filePath = " + filePath);
        driver.findElement(By.id("file-upload")).sendKeys(filePath);
    }
}