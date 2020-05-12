package com.SelfStudy.Others;
import com.cybertek.utilities.ConfigurationReader;

import java.io.FileNotFoundException;
import java.util.Scanner;
public class SimpleProgram {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print(scanner.next());
        scanner.close();
        System.out.println("ConfigurationReader.get(\"asd\") = " + ConfigurationReader.get("asd"));
    }
}