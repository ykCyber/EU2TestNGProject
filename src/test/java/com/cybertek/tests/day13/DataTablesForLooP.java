package com.cybertek.tests.day13;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.By.xpath;

public class DataTablesForLooP {
    WebDriver driver = WebDriverFactory.getDriver("chrome");


    @BeforeMethod
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        sleep(2000);
    }


    @Test
    public void test() {
        driver.get("http://practice.cybertekschool.com/tables");

        List<WebElement> headers = driver.findElements(xpath("(//thead)[1]//span"));// 6 baslik 1 i fazla
        List<WebElement> numOfPeople = driver.findElements(xpath("(//tbody)[1]//tr//td[1]"));//kisi sayisini veren dizi
        for (int i = 1; i <= numOfPeople.size(); i++) {//kisi sayisi
            Iterator<WebElement> headerIter = headers.iterator();
            for (int j = 1; j <= headers.size() - 1; j++) {//5 baslik
                String infoCell = driver.findElement(xpath(("(//tr[" + i + "]//td[" + j + "])[1]"))).getText();
                String header = headerIter.next().getText();
                System.out.printf("%-10s : %s\n", header , infoCell);
            }
            System.out.println("----##########-----");
        }
    }
}

