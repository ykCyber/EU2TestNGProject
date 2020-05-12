package com.SelfStudy.Others;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class checkLinkAllLinks {

    public static void main(String[] args) {
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        WebDriver driver = WebDriverFactory.getManuelDriver("chrome");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(baseUrl);
        List<WebElement> linkElements = driver.findElements(By.tagName("a"));
        Set<String> withOutDubs = new HashSet<String>(Arrays.asList(linkElements.toString()));
        Consumer<? super WebElement> link = null;

        
                System.out.println("linkElements.size() = " + linkElements.size());
        Set<String> removedDubs = new HashSet();
        for (WebElement linkElement : linkElements) {
            removedDubs.add(linkElement.getText());
            System.out.println("linkElement.getAttribute(\"href\") = " + linkElement.getAttribute("href"));
        }

        System.out.println("removedDubs.size() = " + removedDubs.size());
    }
}
