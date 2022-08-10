package Tests;

import Helpers.Report_Helper;
import Helpers.Take_Screenshot;
import Pages.Home_Page;
import Pages.Personal_Loans;
import Setup.Setup_Class;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Test_Runner extends Report_Helper {

    private WebDriver driver= Setup_Class.startBrowserOfChoice("https://www.oldmutual.co.za/personal/solutions/bank-and-borrow/","Chrome");
    String Title = "Bank and Borrow Solutions | Old Mutual";
    Home_Page home_page= PageFactory.initElements(driver,Home_Page.class);
    Personal_Loans personal_loans = PageFactory.initElements(driver, Personal_Loans.class);
    Take_Screenshot screenshot = new Take_Screenshot();

    public Test_Runner(){

    }
    @Test
    public void Verify_Page_Title_Test() throws InterruptedException {

        test=extent.createTest("Verify_Page_Title_Test");
        test.log(Status.PASS,"Verifying Home Page Title");
        home_page.Get_Page_Title(Title);
        screenshot.takeSnapShot(driver,"Landing Page");
    }

    @AfterSuite
    public void Tear_Down(){
        driver.quit();
    }
}