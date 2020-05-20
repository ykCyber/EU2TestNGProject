package com.SelfStudy.VyTrack.UserStory14_VehicleModel;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class dots_edits {

@Test
public void test(){
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    driver.get("https:/qa1.vytrack.com");
}
}
