package Pages;

import org.checkerframework.checker.units.qual.C;
import org.checkerframework.checker.units.qual.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
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
    @FindBy(xpath = "(//span[contains(@class,'selected-value-container')])[1]")
    WebElement Amount_Dropdown;
    @FindBy(xpath = "(//button[contains(.,'Next')])[1]")
    WebElement Next_Button;
    @FindBy(xpath = "(//span[contains(@class,'selected-value-container')])[1]")
    WebElement Period_Dropdown;
    @FindBy(xpath = "(//span[contains(.,'Calculate')])[3]")
    WebElement Calculate_Installment;

    public void Navigate_To_Personal_Loans_Page() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", Personal_Loans_Learn_More);

    }
    public void Click_Calculate_Button(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(Calculate));

        Calculate.click();
    }
    public void Select_Amount_From_Dropdown(String _amount){

        ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", Amount_Dropdown);

        WebElement Amount=driver.findElement(By.xpath("//li[contains(@id,'"+_amount+"')]"));

        JavascriptExecutor executor2 = (JavascriptExecutor)driver;
        executor2.executeScript("arguments[0].click();", Amount);
    }
    public void Click_Next_Button(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", Next_Button);
    }
    public void Select_The_Payment_Period_From_The_Dropdown(String _period){

        ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", Period_Dropdown);

        WebElement Period=driver.findElement(By.xpath("//li[contains(@id,'"+_period+"')]"));

        JavascriptExecutor executor2 = (JavascriptExecutor)driver;
        executor2.executeScript("arguments[0].click();", Period);
    }
    public void Click_Calculate_Installment_Button(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", Calculate_Installment);
    }
    public void Verify_Calculated_Amounts(String _expected) throws InterruptedException {
        WebElement Installment=driver.findElement(By.xpath("//div[2]/h5/strong"));
        TimeUnit.SECONDS.sleep(5);
        Assert.assertEquals(Installment.getText(),_expected,"The Installment Amount Did Not Match");
        System.out.println("Your monthly Installment Range is " + Installment.getText());
    }

}
