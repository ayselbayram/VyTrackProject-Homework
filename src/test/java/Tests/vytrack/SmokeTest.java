package Tests.vytrack;

import Pages.LoginPage;
import Tests.TestBase;
import org.testng.Assert;
import org.testng.IDataProviderListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SmokeTest extends TestBase {
    @Test(dataProvider="navigationInfo")
    public void smokeTest(String moduleName, String subModuleName, String pageSubTitle){
        extentTest=extentReports.createTest("verify that page subtitle is equal to "+pageSubTitle);
        LoginPage loginpage=new LoginPage();
        loginpage.login("storemanager85","UserUser123");
        loginpage.navigateTo(moduleName,subModuleName);
        loginpage.waitUntilLoaderMaskDisappear();
        Assert.assertEquals(loginpage.getPageSubTitle(),pageSubTitle);
        extentTest.pass("Verified that page subtitle '"+pageSubTitle+"' is displayed");


    }
    @DataProvider(name="navigationInfo")
    public Object[][] navigationInfo(){
        return new Object [][]{
                {"Dashboards","Dashboard","Dashboard"},
                {"Dashboard","Manage Dashboard","All Manage Dashboard"},
                {"Fleet","Vehicles","All Cars",},{"Customers","Accounts","All Accounts"},
                {"Customers", "Accounts", "All Accounts"},
                {"Activities","Calls","All Calls"},
                {"Activities","Calendar Events","All Calendar Events"},
                {"Sales","Opportunities","Open Opportunities"}


        };



    }



}
