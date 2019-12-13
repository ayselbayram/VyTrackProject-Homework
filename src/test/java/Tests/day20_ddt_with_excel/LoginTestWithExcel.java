package Tests.day20_ddt_with_excel;

import Pages.LoginPage;
import Tests.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.Driver;
import utils.ExcelUtil;

import java.util.Map;

public class LoginTestWithExcel extends TestBase {
    @Test(dataProvider = "credentials",description = "login with different credentials")
    public void loginTest(String username,String password, String firstname, String lastname, String result){

   extentTest=extentReports.createTest("Login as "+username);
        //is must because we will ge null pointer exception
     if(username.equals("username")){

         //will make test skipped
         //it will not fail
         //because first row is dedicated to column names
         throw new SkipException("test was skipped because it's firt row");

     }else{
         LoginPage loginPage=new LoginPage();
         loginPage.login(username,password);
         //put here wait for title to be "Dashboard"
         BrowserUtils.waitForVisibility(loginPage.pageSubTitle,10);

         Assert.assertEquals(Driver.get().getTitle(),"Dashboard");
         extentTest.pass("Login test passes for user "+username);

     }

    }

    //is a test data supplier
    //as many set of data it returns
    //as many times exactly same test will run
    @DataProvider(name = "credentials")
    public static Object[][] credentials() {
        ExcelUtil qa2 = new ExcelUtil("vytrack_testusers.xlsx", "QA2-short");
        return qa2.getDataArray();

    }






//    public static void main(String[] args) {
//        ExcelUtil qa2=new ExcelUtil("/Users/Filiz/IdeaProjects/Summer2019OnlineTestNGSeleniumProject/vytrack_testusers.xlsx","QA2-short");
//        System.out.println("Row count: "+qa2.rowCount());
//        System.out.println("Column names: "+qa2.getColumnsNames());
//        System.out.println("det data lis "+qa2.getDataList());
//        //map is a data structure
//        //in map every value is reference by key
//        //when we retrieve data from map,
//        //we dint specify index, ae specify key name, keys must be unique
//        //keys are represented column names
//        //like properties file key=value
//        for(Map<String,String> map :qa2.getDataList()) {
////            System.out.println(map);
//            System.out.println(map.get("username"));
//        }
//}





}
