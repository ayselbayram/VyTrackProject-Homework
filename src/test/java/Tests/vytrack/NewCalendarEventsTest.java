package Tests.vytrack;

import Pages.LoginPage;
import Tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewCalendarEventsTest extends TestBase {

    @Test(description = "verify that page subtitle is equals to 'All Calendar Events")
    public void test1(){

        extentTest=extentReports.createTest("verify that page subtitle is equals to 'All Calendar Events");
        LoginPage loginpage=new LoginPage();

        loginpage.login("storemanager85","UserUser123");

        loginpage.navigateTo("Activities","Calendar Events");
        //subclass of basepage class, all the methods inherited , navigateto from basepage class inherited to login

        String expectedSubtitle = "All Calendar Eventsj";
        String actualSubTitle=loginpage.getPageSubTitle();

        Assert.assertEquals(actualSubTitle,expectedSubtitle);//if this fail next statement is unreachable

        extentTest.pass("pVerified that page subtitle'All Calendar Events' is displayed");


    }


}
