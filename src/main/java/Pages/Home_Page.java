package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Home_Page {

    private WebDriver driver;


    public Home_Page(WebDriver driver){
        this.driver=driver;
    }
    @FindBy(id="")
    WebElement Title;

    public void Get_Page_Title(String _expectedTitle){

        Assert.assertEquals(_expectedTitle,driver.getTitle(),"Actual Title Did Not Match The Expected Title");
        System.out.println(driver.getTitle());
    }
}
