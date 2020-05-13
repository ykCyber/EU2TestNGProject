package com.SelfStudy.Others;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderFroTwoList {
    @DataProvider
    public static Object[][] alfa() {
        String titles [] =new String[]{"title1","title2"};
        String links [] =new String[]{"Link1","Link2"};
        String[][] set = new String[2][];
        for (String[] strings : set) {
            for (String link : links) {
                strings[0] = link;
            }
            for (String title : titles) {
                strings[1] = title;
            }

        }
        return set;
    }

    @Test(dataProvider = "alfa")
    public void writeFromDataP(String link, String title){
        System.out.println(link+" "+title);
    }
}
