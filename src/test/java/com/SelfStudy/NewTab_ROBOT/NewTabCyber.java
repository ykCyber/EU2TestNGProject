package com.SelfStudy.NewTab_ROBOT;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTabCyber {

        @DataProvider
    public  Object[][] isimGetir() {
        String [][] data = new String[3][2];
        data[0][0] = "ahmet";
        data[0][1] = "yılmaz";
        data[1][0] = "mehmet";
        data[1][1] = "çelik";
        data[2][0] = "ali";
        data[2][1] = "er";

        return data ;
    }

    @Test(dataProvider = "isimGetir")
    public void test(String name,String soyisim){
        System.out.println("isim "  + name);
        System.out.println("soyisim " + soyisim);

    }
}
