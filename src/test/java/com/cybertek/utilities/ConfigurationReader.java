package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;

    static {
        try {
            String path = "configuration.propoerties";

            FileInputStream inputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String value) throws FileNotFoundException {

        String result = null;

        FileInputStream inputStream = new FileInputStream("//idea/navigate/reference?project=EU2TestNGProject&path=configuration.properties");
        System.out.println("inputStream.toString() = " + inputStream.toString());

        return inputStream.toString();
    }
}
