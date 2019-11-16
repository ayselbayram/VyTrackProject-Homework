package Tests.day9_review;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNG_review {
    //whatever is common among tests can go into @beforemethod and @ aftermethod
    //it helps to reduce code duplication
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.out.println("Before method!");
        driver= BrowserFactory.getDriver("chrome");

    }
    @AfterMethod
    public void teardown(){
       driver.quit();
    }
    //priority will cahnge the order of test execution
    //by default tests running by alphabetical order
    //lower priority- earlier execution
    //lower priority number-higher priority of the execution
    //tests will run, priority 1,2,3,
    @Test(description = "Verify title google.com",priority = 1)
    public void test1(){
       driver.get("http://google.com");
       String ecpectedTitle="Google";
       String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,ecpectedTitle,"Title is not correct");

    }
    @Test(description = "verfiy apple title",priority = 2)//priority gives order, which one you execute first
    public void verifyApplePageTitle(){
        driver.get("https://www.apple.com");
        String expectedTitle="Apple";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title is not correct");
        //if assertion failed, line below will not be reachable
        //if aseertion passed, you will see from line below
        System.out.println("Test passed");

    }
//data provider can supply test wth data. also it allows to do data Driven Testing.
    //What is this? it is when same test runs multiple times with difference test data set
//    @DataProvider(name = "testData")
//    public void Object[][] testData(){
//        return new Object [][]{{"https://www.apple.com","Apple"}},
//                                {"http://google.com","Google"}};
//
//    }
    @Test(dataProvider = "testdata")
    public void testWithDataProvider(String url, String title){
    driver.get(url);
    Assert.assertEquals(driver.getTitle(),title);

}
}