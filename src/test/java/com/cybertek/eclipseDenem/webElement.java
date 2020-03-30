package com.cybertek.eclipseDenem;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cybertek.utilities.WebManuelSetFactory;

public class webElement {

	public static void main(String[] args) {
	WebDriver driver = WebManuelSetFactory.getDriver("chrome");
	driver.get("https://google.com");
		
	}

}
