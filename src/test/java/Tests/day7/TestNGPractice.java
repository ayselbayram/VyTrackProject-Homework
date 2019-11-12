package Tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGPractice {

     @Test
     public void test(){
         //to verify that expected and actual result is the same
         //if no --it will throw exception and stop the peogram
         //also, you will se in the console what was expected
         //and what was actually
         //click and hold comman/control button and use left/or single clik to open the class
         //top right side you will see "donwload sources" message click on it
         Assert.assertEquals("apple","Orange","Word is not correct, should be apple");
         //before we need to give if then statmenet now only asser



    }
    @Test(description="Verifying title of the practice website")
    public void verifyTitle(){
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        String expectedTitle="Practice";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title is wrong");
        driver.quit();

    }
    //lets verify that 'Test automation practice' headin is displayed
    @Test(description = "verify that heading is dispolayed")
    public void verifyHeadingDisplayed(){
         WebDriver driver=BrowserFactory.getDriver("chrome");
         driver.get("http://practice.cybertekschool.com/");
         //if there is no element with this locator, we will get nosuchelement exception
        //and our program will stop on the fineelement line
        WebElement heading=driver.findElement(By.xpath("//span[text()='Test Automation Practice']"));
        //to make sure that element is visible to user
        //because lement can be present, but not visible,
        //we need to make sure lement is visible
        //'Element is not visible'---will be printed when test is failed
        Assert.assertTrue(heading.isDisplayed(), "Element is not visible");
        driver.quit();
    }

}

