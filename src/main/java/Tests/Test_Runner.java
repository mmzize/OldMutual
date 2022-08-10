package Tests;

import Helpers.Report_Helper;
import Helpers.Scroll_Helper;
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
    Scroll_Helper scroll_helper = new Scroll_Helper();
    public Test_Runner(){

    }
    @Test
    public void Verify_Page_Title_Test() throws InterruptedException {

        test=extent.createTest("Verify_Page_Title_Test");
        test.log(Status.PASS,"Verifying Home Page Title");
        home_page.Get_Page_Title(Title);
        screenshot.takeSnapShot(driver,"Landing Page");
    }
    @Test(priority = 1)
    public void Navigate_To_Personal_Loans_Test() throws InterruptedException {
        test=extent.createTest("Navigate_To_Personal_Loans_Test");
        test.log(Status.PASS,"Click Learn More Button");
        scroll_helper.Scroll(driver);
        screenshot.takeSnapShot(driver,"Learn More Button");
        personal_loans.Navigate_To_Personal_Loans_Page();

    }
    @Test(priority = 3)
    public void Click_Calculate_Button_Test() throws InterruptedException {
        test=extent.createTest("Click_Calculate_Button_Test");
        test.log(Status.PASS,"Click Calculate Button");
        screenshot.takeSnapShot(driver,"Calculate Button");
        personal_loans.Click_Calculate_Button();
    }
    @Test(priority = 4)
    public void Select_Amount_From_Dropdown_Test() throws InterruptedException {
        test=extent.createTest("Select_Amount_From_Dropdown_Test");
        test.log(Status.PASS,"Select Value From Dropdown");

        screenshot.takeSnapShot(driver,"Select Value From Dropdown");
        personal_loans.Select_Amount_From_Dropdown("R50000");
    }
    @Test(priority = 5)
    public void Click_Next_Button_Test() throws InterruptedException {
        test=extent.createTest("Click_Next_Button_Test");
        test.log(Status.PASS,"Click Next Button");

        screenshot.takeSnapShot(driver,"Next Button");
        personal_loans.Click_Next_Button();
    }
    @Test(priority = 6)
    public void Select_Period_From_Dropdown_Test() throws InterruptedException {
        test=extent.createTest("Select_Period_From_Dropdown_Test");
        test.log(Status.PASS,"Select Payment Period");

        screenshot.takeSnapShot(driver,"Select Period From Dropdown");
        personal_loans.Select_The_Payment_Period_From_The_Dropdown("60 Months");
    }
    @Test(priority = 7)
    public void Calculate_Installment_Test(){
        test=extent.createTest("Calculate_Installment_Test");
        test.log(Status.PASS,"Click Calculate Button");

        personal_loans.Click_Calculate_Installment_Button();
    }
    @Test(priority = 8)
    public void Verify_Installment_Amount_Test() throws InterruptedException {
        test=extent.createTest("Verify_Installment_Amount_Test");
        test.log(Status.PASS,"Get Installment Amount");
        scroll_helper.Scroll(driver);
        screenshot.takeSnapShot(driver,"Calculated Amount");
        personal_loans.Verify_Calculated_Amounts("R1 656.43 - R1 810.05");
    }
    @AfterSuite
    public void Tear_Down(){
        driver.quit();
    }
}
