package Tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitsPractice {
    private WebDriver driver;
    @BeforeMethod
    public void seyup(){

        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    @Test(description = "implicitly wait")
    public void test1(){
        //this line should be before all findelement()
        //to wait with in 10 seconds until element is present
        //we apply it once and it always works with findelement()
        //put this line into @beforemethod and it will work for all tests
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.findElement(By.linkText("Dynamic Loading")).click();
      //partialLinkText we match only of the link text
        // partialLinkText its like contains text
        //Example 2: Element on the page that is rendered after the trigger-->this is linktext
        //we can use "Example 2" as a partial text , it work with only link, with <a> element
      driver.findElement(By.partialLinkText("Example 2")).click();
      //click the "start" button
      driver.findElement(By.tagName("button")).click();

      //this is "hello world"
      WebElement finishElement=driver.findElement(By.id("finish"));
        System.out.println(finishElement.getText());
    }
    @Test(description = "explicit wait")
    public void test2(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        //select example 1
        driver.findElement(By.partialLinkText("Example 1")).click();
        //click the "start" button
        driver.findElement(By.tagName("button")).click();

        //enter user name
        //explicit wait
        //we find elements first
        // but the problem is element can be present but not visible

        //how to apply condition
        WebElement userNameInputBox=driver.findElement(By.id("username"));
        //we create object of webdriverwait to apply explicit wait
        //we must provide webdriver object and period of time
        //within this period of time selenium will check every 500 miliseconds
        //if consition is true, if condition has met, no neeed to wait longer
        //your script will continue executing
        WebDriverWait wait=new WebDriverWait(driver,10);
        //how to apply condition| ExpectedConditions.condition
        //in this example webdriver will wait up to 10 second until the element is visible
        //if wait time will expire, your test will fail(due axception)
        wait.until(ExpectedConditions.visibilityOf(userNameInputBox));
        userNameInputBox.sendKeys("tomsmith");



        //enter password
        //no need to create another wait elemnt use the previous one
        WebElement passwordInputBox=driver.findElement(By.id("pwd"));
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        passwordInputBox.sendKeys("SuperSecretPassword");

        //click submit button
        WebElement submit=driver.findElement(By.cssSelector("button[type='submit']"));
        //wait until that button is available for click
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();

        WebElement message=driver.findElement(By.tagName("h4"));
        wait.until(ExpectedConditions.visibilityOf(message));
        String expectedMessage="Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage=message.getText();
        Assert.assertEquals(actualMessage,expectedMessage,"message is wrong");









    }
    @Test(description = "explicit wait example")
    public void test3(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 5")).click();
        WebDriverWait wait=new WebDriverWait(driver,15);
        WebElement overlayScreen=driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin']"));
        //wait until overlay screen diseppear
        //otherwise we will have issues to click or enter the text
        wait.until(ExpectedConditions.invisibilityOf(overlayScreen));

        //enter username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //enter password
        driver.findElement(By.id("pwd")).sendKeys("SuperSecretPassword");
        //click on submit key
        driver.findElement(By.tagName("button")).click();
    }
//    @Test(description = "fluent wait example")
//    public void test4(){
//        driver.findElement(By.linkText("Dynamic Loading")).click();
//        driver.findElement(By.linkText("Example 2")).click();
//        driver.findElement(By.tagName("button")).click();
//        Wait wait=new FluentWait(driver)
//                 //.withTimeout(10,TimeUnit.SECONDS);//----means depricated, means it is old we have th enew version
//                  .withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofMillis(200))
//                .ignoring(ElementNotVisibleException.class);
//
//        WebElement message=wait.until(new Function<WebDriver, WebElement>)
//    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
