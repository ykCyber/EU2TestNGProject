package com.cybertek.tests.day16PageObjectModel;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.annotations.Test;

public class TestCase16 extends TestBase {




    @Test
    public void test() {
        LoginPage.login("user16", "UserUser123");

    }



}
