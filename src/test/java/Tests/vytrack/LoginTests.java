package Tests.vytrack;

import Pages.LoginPage;
import Tests.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;

//to inherit before and after methods
//this class will dedicated to tests related login page only
//we dont have to find elements here
//we should find elements in page classes only

public class LoginTests extends TestBase {
    @Test(description = "Verify that page title is a 'Dashboard'")
    public void test1(){
        //create a page object
        LoginPage loginpage=new LoginPage();
        //call login method
        //provide username and password
        loginpage.login("storemanager85","UserUser123");
        //verification stage
        //Driver.get()=driver
        //Driver.get() returns webdriver object
        WebDriverWait wait=new WebDriverWait(Driver.get(),10);
        //this is an explicit wait, it waits until title is "Dashoard"
        wait.until(ExpectedConditions.titleIs("Dashboard"));

        Assert.assertEquals(Driver.get().getTitle(),"Dashboard");
        //Driver.get() means Driver open chrome then get the title


    }
}
