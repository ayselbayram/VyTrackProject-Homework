package Tests.vytrack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.concurrent.TimeUnit;

public class CalendarEventTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        //explicit wait
        wait = new WebDriverWait(driver, 10);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        //enter in the send keys
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

        //webelement of "Activities"
        WebElement activitiesButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/header/div[2]/ul/li[5]/a/span"));
        //explicit wait to wait until "Activities" module appear
        wait.until(ExpectedConditions.visibilityOf(activitiesButton));
//        BrowserUtils.wait(2);


        // create webElement of "Calendar Events"
        WebElement CalendarButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/header/div[2]/ul/li[5]/div/div/ul/li[4]/a"));
        //for hover over to the Calendar Event create an action object
        Actions action = new Actions(driver);
        //hover over to Calendar Event button
        //perform does the hover over action
        action.moveToElement(CalendarButton).perform();
        wait.until(ExpectedConditions.invisibilityOf(CalendarButton));
//        BrowserUtils.wait(2);//just for demo
//        click the Calendar Event button
        CalendarButton.click();

        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

    }

    @Test(description = "verify page subtitle")
    public void test1() {
        WebElement subTitle=driver.findElement(By.className("oro-subtitle"));
        String expectedSubtitle = "All Calendar Events";
        String actualSubTitle = subTitle.getText();
        System.out.println(actualSubTitle);
        Assert.assertEquals(actualSubTitle, expectedSubtitle, "subtitle is wrong");
    }

    @Test(description = "verify that ")
    public void test2() {
        Assert.assertTrue(driver.findElement(By.cssSelector("[title='Create Calendar event']")).isDisplayed());
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}





