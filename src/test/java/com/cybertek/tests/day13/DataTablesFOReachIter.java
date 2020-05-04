package com.cybertek.tests.day13;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


;import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataTablesFOReachIter {
    WebDriver driver = WebDriverFactory.getManuelDriver("chrome");

    @BeforeMethod
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterTest
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void OpenNewTab_SwitchWindow_Keys_Chord() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/tables");
        System.out.println("first Handle = " + driver.getWindowHandle());
        String newtab = Keys.chord(Keys.CONTROL, Keys.RETURN);
        driver.findElement(By.linkText("Home")).sendKeys(newtab);
        Thread.sleep(2000);
        ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("windowHandles.size() = " + windowHandles.size());
        System.out.println("Befre switch hnd =" + driver.getWindowHandle());
        System.out.println("Befre switch url = " + driver.getCurrentUrl());
        driver.switchTo().window(windowHandles.get(0));
        System.out.println("After switch hnd =" + driver.getWindowHandle());
        System.out.println("After switch url = " + driver.getCurrentUrl());
        driver.switchTo().window(windowHandles.get(1));
        System.out.println("Second switch hnd =" + driver.getWindowHandle());
        System.out.println("Second switch url = " + driver.getCurrentUrl());



    }
     @Test
    public void test() {
        driver.get("http://practice.cybertekschool.com/tables");

        List<WebElement> headers = driver.findElements(By.xpath("(//thead)[1]//span"));// 6 baslik 1 i fazla
        List<WebElement> numOfPeople = driver.findElements(By.xpath("(//tbody)[1]//tr//td[1]"));//kisi sayisini veren dizi
//        for (int i = 1; i <= numOfPeople.size(); i++) {//kisi sayisi
//            Iterator<WebElement> headerIter = headers.iterator();
//            for (int j = 1; j <= headers.size() - 1; j++) {//5 baslik
//                String infoCell = driver.findElement(xpath(("(//tr[" + i + "]//td[" + j + "])[1]"))).getText();
//                String header = headerIter.next().getText();
//                System.out.printf("%-10s : %s\n", header , infoCell);
//            }
//            System.out.println("----##########-----");
//        }
    }


    @Test
    public void cellByCell() {
        driver.get("http://practice.cybertekschool.com/tables");

        List<WebElement> titles = driver.findElements(By.xpath("(//tr)[1]/th"));
        //titles  = toplam 6 element( buradan getText ile basliklari alacagiz
        List<WebElement> allCells = driver.findElements(By.xpath("(//tbody)[1]//tr//td"));
        //allCells = toplam 24 element (buradan getText ile hucrelerin icindeki datayi teker teker alacagiz

        Iterator<WebElement> titleIter = titles.iterator();
        // titleIter.next() basliklari teker teker yazdirmamiza yarayacak (.getText() ile)
        //

        for (WebElement cell : allCells) {// 24 hucreyi liste seklinde barindiran allCells icin for each loop kuruyoruz

            String title = titleIter.next().getText();//-1. indexten 0 git ve text'ini al=(lastName)
            // ikinci iterasyonda 0 dan 1 git ( firsname)...........


            if (titleIter.hasNext() == false) {
                //sonda action-edit var onu yazdirmak istemiyorum
                //sirada baska eleman yoksa(sona gelmisim demektir) false donecek ve if dongusunun icine girecek

                System.out.println("----action-edit yazilmadi,  ----\n" +
                        " ---siradaki kisi bilgilerine geciyoruz---");
                //burasi cokomelli
                // sona gelince pointer basa donsun
                // aksi halde ilk bes elemandan sonra 6.elemana gecer ve
                //if dongusunun icine girer 6. basligi atlar (buraya kadar guzel)
                //6. elemandan sonra pointer i resetlemezsek 7.eleman olmadigi icin
                // NoSuchElementException hatasi aliriz
                titleIter = titles.listIterator();//pointer tekrar -1 e dondu
                continue;
            } else
                System.out.printf("%-13S :%s\n", title, cell.getText());
        }
    }
}
