package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TestPage extends TestBase{
    public TestPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "")
    WebElement element;

    public void zoomRobot() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SUBTRACT);
        robot.keyRelease(KeyEvent.VK_SUBTRACT);
        robot.keyPress(KeyEvent.VK_SUBTRACT);
        robot.keyRelease(KeyEvent.VK_SUBTRACT);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public void zoomAction(){
        Actions action = new Actions(driver);
        action.sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT)).perform();
        action.sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT)).perform();
    }

    public void zoomSendKeys(){
        Actions action = new Actions(driver);
        driver.findElement(By.tagName("html")).sendKeys(Keys.CONTROL,Keys.SUBTRACT);
        driver.findElement(By.tagName("html")).sendKeys(Keys.CONTROL,Keys.SUBTRACT);
    }

    public void zoomJS() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.zoom = '0.5'");
        executor.executeScript("document.body.style.zoom = '1'");
    }

    public void zoomJsFf(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.MozTransform = 'scale(0.8)'");
        executor.executeScript("document.body.style.MozTransformOrigin = '0 0'");
    }
}

