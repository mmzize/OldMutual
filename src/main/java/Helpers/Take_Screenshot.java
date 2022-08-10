package Helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Take_Screenshot {

    public void takeSnapShot(WebDriver driver, String screenshotName) throws InterruptedException {

        TimeUnit.SECONDS.sleep(5);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(".//ScreenShots/" + screenshotName+ ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}