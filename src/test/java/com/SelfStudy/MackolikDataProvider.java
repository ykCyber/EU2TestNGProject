package com.SelfStudy;

import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.utilities.WebDriverManuelSetFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MackolikDataProvider {
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    @DataProvider
    public static Object[] teamName() {
        return new String[]{"Trabzonspor" ,  "AnkaraGucu", "Galatasaray", "Sivasspor","Beşiktaş", "Alanyaspor", "Fenerbahçe", "Göztepe", "Gaziantep FK", "Denizlispor", "Antalyaspor", "Gençlerbirliği", "Kasımpaşa", "Konyaspor", "Yeni Malatya", "Ç. Rizespor", "MKE Ankaragücü", "Kayserispor"};

    }

    @BeforeClass
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test(dataProvider = "teamName")
    public void test(String clubName) {
        driver.get("https://www.mackolik.com/puan-durumu/t%C3%BCrkiye-s%C3%BCper-lig/482ofyysbdbeoxauk19yg7tdt");
        String team = clubName;
        String xpath = "//tr[@data-team-name='" + team + "']";
        WebElement element = driver.findElement(By.xpath(xpath));
        String[] tablo = element.getText().split(" ");
        int wonPoints = 3 * Integer.parseInt(tablo[3]) + Integer.parseInt(tablo[4]);
        int tablePoint = Integer.parseInt(tablo[9]);
        System.out.printf("%s%nGalibiyet :%s Beraberlik :%s Toplam puan:%s",team,tablo[3],tablo[4],tablo[9]);
        Assert.assertEquals(wonPoints, tablePoint, ""+team);

    }


}
