package Tests.vytrack;

import Pages.CampaignsPage;
import Pages.LoginPage;
import Tests.TestBase;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class CampaingsTest extends TestBase {

    @Test(description = "verify that in the search button write'java is fun'")
    public void test1(){
        LoginPage loginpage=new LoginPage();
        CampaignsPage campaignPage=new CampaignsPage();
        loginpage.login("storemanager85","UserUser123");
        loginpage.navigateTo("Marketing","Campaigns");
        loginpage.waitUntilLoaderMaskDisappear();
        campaignPage.gridSearchButton("java is fun");
        BrowserUtils.wait(3);


    }
    @Test(description = "")
    public void clickViewPerPage(){
        LoginPage loginpage=new LoginPage();
        loginpage.login("storemanager85","UserUser123");
        loginpage.navigateTo("Marketing","Campaigns");
        CampaignsPage campaignsPage=new CampaignsPage();

        campaignsPage.selectViewPerPage("10");
    }

}
