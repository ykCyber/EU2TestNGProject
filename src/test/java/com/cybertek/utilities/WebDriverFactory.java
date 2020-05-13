package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

import java.io.File;

public class WebDriverFactory {
    private static WebDriver driver;

    public static WebDriver getManuelDriver(String browserType) {
        String projectPath = System.getProperty("user.dir");

        switch (browserType.toLowerCase()) {
            case "chrome":
                String relativePath = "drivers\\chromedriver.exe";
                String filePath = (projectPath + "\\" + relativePath);
                System.setProperty("webdriver.chrome.driver", filePath);

                driver = new ChromeDriver();
                break;
            case "firefox":

                relativePath = "drivers\\geckhodriver.exe";
                filePath = (projectPath + "\\" + relativePath);
                System.setProperty("webdriver.chrome.driver", filePath);

                driver = new FirefoxDriver();
                break;
            case "opera":

                relativePath = "drivers\\operadriver.exe";
                filePath = (projectPath + "\\" + relativePath);
                System.setProperty("webdriver.opera.driver", filePath);

                driver = new OperaDriver();
                break;
        }
        return driver;
    }

    public static WebDriver getDriver(String browserType) {
                ChromeOptions chromeOptions = new ChromeOptions();
  //              chromeOptions.addExtensions(new File("C:\\Users\\mksimsir\\git\\EU2TestNGProject\\drivers\\chropath_6_1_4_0.crx"));
        if (driver == null) {

            switch (browserType.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "chrome-headless":
    //                chromeOptions.addExtensions(new File("C:\\Users\\Mustafa\\git\\EU2TestNGProject\\drivers\\chropath_6_1_4_0.crx"));

                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "firefox- headless" :
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
