package com.cybertek.tests.day12.actions_jsExecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ActionsTest {
    WebDriver driver = WebDriverFactory.getDriver("opera");

    @BeforeMethod
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterTest
    public void afterMethod() throws InterruptedException {
        sleep(2000);
        driver.close();
    }

    @Test
    public void DragAndDrop() throws AWTException, InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("(//button)[2]")).click();
        Robot robot = new Robot();
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement dropable = driver.findElement(By.id("droptarget"));
        robot.mouseMove(1150, 250);
        actions.moveToElement(draggable).clickAndHold().build().perform();
        robot.mouseMove(50, 50);
        Thread.sleep(2000);
        robot.mouseMove(150, 250);
        Thread.sleep(2000);
        actions.moveToElement(dropable).perform();
    }

    @Test
    public void robot() throws AWTException {
        Robot robot = new Robot((GraphicsDevice) driver);
        robot.mouseMove(50, 50);

    }
}
