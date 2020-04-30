package com.SelfStudy.NewTab_ROBOT;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RobotNewTab {
    @DataProvider
    public static Object[] getLink() {

        return new Object[]{"https://www.javatpoint.com/java-listiterator-add-method",
        "https://vytrack.com/index.php/about-us/",
        "https://web.whatsapp.com/"
        ,"https://www.m.utest.com/charles-proxy"};
    }

    @Test (dataProvider = "getLink")
    public void testDataProviderILE(String link) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        Thread.sleep(5000);
    driver.get(link);

    }

    @Test //dataP"siz
    public void test() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        for (int i = 0; i < 4; i++) {

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_T);

        }
        Thread.sleep(5000);
        Object [] links = {"https://www.javatpoint.com/java-listiterator-add-method",
                "https://vytrack.com/index.php/about-us/",
                "https://web.whatsapp.com/"
                , "https://www.m.utest.com/charles-proxy"};

        Iterator<Object> iter = (Arrays.asList(links)).iterator();
        List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        System.out.println(windowHandles.size());
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            driver.get(iter.next().toString());
        }

    }
}
