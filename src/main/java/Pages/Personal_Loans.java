package Pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Personal_Loans {

    private WebDriver driver;

    public Personal_Loans(WebDriver driver){
        this.driver=driver;
    }

    @FindBy(xpath = "(//span[contains(.,'LEARN MORE')])[2]")
    WebElement Personal_Loans_Learn_More;
    @FindBy(xpath = "(//span[contains(.,'CALCULATE')])[2]")
    WebElement Calculate;

    public void Navigate_To_Personal_Loans_Page() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", Personal_Loans_Learn_More);

    }
    public void Click_Calculate_Button(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(Calculate));

        Calculate.click();
    }

}
