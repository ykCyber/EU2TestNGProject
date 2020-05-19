package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

import java.io.File;

public class Driver {
    static int counter= 0;

    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver get() {
        counter++;

        ChromeOptions chromeOptions = new ChromeOptions();

        String projectPath = System.getProperty("user.dir");
        String relativePath = "drivers\\chropath_6_1_4_0.crx";
        System.out.println("Chrome is launching with ChroPath..." + counter);
        String filePath = (projectPath + "\\"+ relativePath);
        chromeOptions.addExtensions(new File(filePath));
        if (driver == null) {

            String browser = ConfigurationReader.get("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "chrome-headless":

                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions.setHeadless(true));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "firefox- headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                default:
                    System.out.println("Please Select Opera Chrome or FireFOx");
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}


