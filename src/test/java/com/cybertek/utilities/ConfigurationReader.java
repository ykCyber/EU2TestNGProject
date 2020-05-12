package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ConfigurationReader {
    public static String get(String value) throws FileNotFoundException {

        String result = null;

        FileInputStream inputStream = new FileInputStream("//idea/navigate/reference?project=EU2TestNGProject&path=configuration.properties" );
        System.out.println("inputStream.toString() = " + inputStream.toString());

        return inputStream.toString();
    }
}
