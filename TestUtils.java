package base;

import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import test.TestBase;

import java.io.File;
import java.io.IOException;

public class TestUtils extends TestBase {
    static JavascriptExecutor js;
    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }

    public static void loadGrowl() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        // Check for jQuery on the page, add it if need be
        js.executeScript("if (!window.jQuery) {"
                + "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
                + "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
                + "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
        Thread.sleep(5000);
        // Use jQuery to add jquery-growl to the page

        js.executeScript("var len = $('script').filter(function () {\n" +
                "    return ($(this).attr('src') == 'https://the-internet.herokuapp.com/js/vendor/jquery.growl.js');\n" +
                "}).length;console.log(len);if( len === 0){$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js');}");

        js.executeScript("var len1 = $('script').filter(function () {\n" +
                "    return ($(this).attr('src') == 'https://the-internet.herokuapp.com/js/vendor/jquery.growl.js');\n" +
                "}).length;console.log(len1)");

        // Use jQuery to add jquery-growl styles to the page
        js.executeScript("$('head').append(\"<link rel=\\\"stylesheet\\\" type=\\\"text/css\\\" href=\\\"https://the-internet.herokuapp.com/css/jquery.growl.css\\\">\");");
        Thread.sleep(5000);
    }

    public static void runTimeInfo(@NotNull String messageType, String message) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        Thread.sleep(500);
        js.executeScript("$.growl({ title: 'GET', message: '/' });");
        if (messageType.equals("error")) {
            js.executeScript("$.growl.error({ title: 'Error', message: '"+message+"' });");
        }else if(messageType.equals("info")){
            js.executeScript("$.growl.notice({ title: 'Info', message: '"+message+"' });");
        }else if(messageType.equals("warning")){
            js.executeScript("$.growl.warning({ title: 'Warning!', message: '"+message+"' });");
        }else
            System.out.println("no error message");
        Thread.sleep(500);
    }
}
