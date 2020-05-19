//package com.SelfStudy.Others;
//
//import com.cybertek.utilities.Base;
//import com.cybertek.utilities.Driver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.Iterator;
//import java.util.List;
//
//public class BrokenLinks {
//
//    private static WebDriver driver = null;
//
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        driver = Driver.get();
//        Base.login(driver,"user16");
//        String homePage = "https://qa1.vytrack.com/";
//        String url = "";
//        HttpURLConnection huc = null;
//        int respCode = 200;
//       @Test
//        XSSFWorkbook workbook = new XSSFWorkbook();
//
//
//        List<WebElement> links = driver.findElements(By.tagName("a"));
//
//        Iterator<WebElement> it = links.iterator();
//
//        while(it.hasNext()){
//
//            url = it.next().getAttribute("href");
//
//            System.out.println(url);
//
//            if(url == null || url.isEmpty()){
//                System.out.println("URL is either not configured for anchor tag or it is empty");
//                continue;
//            }
//
//            if(!url.startsWith(homePage)){
//                System.out.println("URL belongs to another domain, skipping it.");
//                continue;
//            }
//
//            try {
//                huc = (HttpURLConnection)(new URL(url).openConnection());
//
//                huc.setRequestMethod("HEAD");
//
//                huc.connect();
//
//                respCode = huc.getResponseCode();
//
//                if(respCode >= 400){
//                    System.out.println(url+" is a broken link");
//                }
//                else{
//                    System.out.println(url+" is a valid link");
//                }
//
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//
//        driver.quit();
//
//    }
//}