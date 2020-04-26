package com.cybertek.tests.day11_File_Upload;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class FilePathExamample {
//    WebDriver driver = WebDriverFactory.getDriver("opera");

    @BeforeMethod
    public void setUp() {
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        sleep(2000);
    }

    @Test
    public void test() {
        System.out.println(System.getProperty("user.dir"));
        String projectPath = System.getProperty("user.dir");
        String relativePath = "src\\test\\resources\\testfile.txt";
        System.out.println("relativePath = " + relativePath);
        String filePath = (projectPath + "\\"+ relativePath);
        System.out.println("filePath = " + filePath);
    }
}
