package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

import java.io.File;
import java.io.FileNotFoundException;

public class Driver {
    private static WebDriver driver;

    public static WebDriver get() throws FileNotFoundException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addExtensions(new File("C:\\Users\\Mustafa\\git\\EU2TestNGProject\\drivers\\chropath_6_1_4_0.crx"));
        String browserType = ConfigurationReader.get("browser");
        if (driver == null) {


            switch (browserType.toLowerCase()) {
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
            }

        }
        return driver;
    }
}

