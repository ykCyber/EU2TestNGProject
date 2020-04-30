package com.SelfStudy;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MackolikDataProvider2 {
    WebDriver driver = WebDriverFactory.getDriver("opera");

    @DataProvider
    public static Object[] temaNameProvider() {
        String[] teamNames = new String[]{"Trabzonspor", "AnkaraGucu", "Galatasaray", "Sivasspor", "Beşiktaş", "Alanyaspor", "Fenerbahçe", "Göztepe", "Gaziantep FK", "Denizlispor", "Antalyaspor", "Gençlerbirliği", "Kasımpaşa", "Konyaspor", "Yeni Malatya", "Ç. Rizespor", "MKE Ankaragücü", "Kayserispor"};

        return teamNames;
    }

    @BeforeMethod
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(dataProvider = "temaNameProvider")
    public void test(String teamNameFromDP) throws InterruptedException, AWTException {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.mackolik.com/puan-durumu/t%C3%BCrkiye-s%C3%BCper-lig/482ofyysbdbeoxauk19yg7tdt");
//        driver.findElement(By.linkText("Futbol")).click();
//        driver.findElement(By.linkText("Puan Durumu")).click();
//      //  driver.findElement(By.cssSelector("a[data-ga-label=\"Futbol\"]")).click();
//       // driver.findElement(By.xpath("(//div[contains(.,' Kabul Et ')]//a)[2]")).click();
        Robot robot = new Robot();
        robot.mouseWheel(5);
        Thread.sleep(1000);
        robot.mouseWheel(-5);

        String clubnWonCSS = "[data-team-name^=\"" + teamNameFromDP + "\"]>td:nth-of-type(6)";
        String clubnDeuceCSS = "[data-team-name^=\"" + teamNameFromDP + "\"]>td:nth-of-type(7)";
        String clubnPointsCSS = "[data-team-name^=\"" + teamNameFromDP + "\"]>td:nth-of-type(12)";
        WebElement clubWon = driver.findElement(By.cssSelector(clubnWonCSS));
        WebElement clubDeuce = driver.findElement(By.cssSelector(clubnDeuceCSS));
        WebElement clubPoints = driver.findElement(By.cssSelector(clubnPointsCSS));
        int won = Integer.parseInt(clubWon.getText().trim());
        int deuce = Integer.parseInt(clubDeuce.getText().trim());
        int point = Integer.parseInt(clubPoints.getText().trim());
        System.out.printf("%s %nPoints :%3d   Won: %3d   Deuce :%3d%n", teamNameFromDP, point, won, deuce);
        Assert.assertTrue(((won * 3) + deuce) == point, teamNameFromDP + " point's is wrong ");


    }
}

