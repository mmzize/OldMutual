package Helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scroll_Helper {

    public void Scroll(WebDriver driver)
    {
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(0,700)");
    }
}
