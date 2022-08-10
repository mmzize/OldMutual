package Setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Setup_Class {

    public static String dir = System.getProperty("user.dir");

    private static final String Chromedriver = dir + "/src/main/java/Drivers/chromedriver.exe";
    private static WebDriver driver;
    public Setup_Class() {
    }

    public static WebDriver startBrowserOfChoice(String URL, String BrowserChoice) {
        if (BrowserChoice.equalsIgnoreCase("chroME")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        } else if (BrowserChoice.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        driver.get(URL);
        return driver;
    }
}