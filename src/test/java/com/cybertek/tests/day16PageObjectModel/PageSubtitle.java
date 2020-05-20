package com.cybertek.tests.day16PageObjectModel;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.annotations.*;

public class PageSubtitle extends TestBase {

    @Test
    public void test() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("User16", "UserUser123");
        navigateToModule("Activities","Calendar Events");
        waitUntilLoaderScreenDisappear();
        System.out.println("pageSubTitle = " + pageSubTitle.getText());

    }

}
