package Tests.assignments;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase3 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        //explicit wait
        wait = new WebDriverWait(driver, 10);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
        BrowserUtils.wait(4);
        activitiesElement.click();
        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();
        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }

    @Test(description = "Verify that page subtitle \"Options\" is displayed")
    public void test1() {
        String actualSubTitle = driver.findElement(By.xpath("//div[@class='btn btn-link dropdown-toggle']")).getText();
        String expectedSubTitle = "Options";
        System.out.println(actualSubTitle);
        Assert.assertEquals(actualSubTitle, expectedSubTitle, "Subtitle is wrong");
    }

    @Test(description = "Verify that page number is equals to 1 ")
    public void test2() {

        WebElement actualNumber= driver.findElement(By.cssSelector("[type='number']"));
        String actual=actualNumber.getAttribute("value");
        System.out.println(actual);
        BrowserUtils.wait(2);
        Assert.assertEquals(actual,"1","number is wrong");

    }
    @Test(description = "Verify that view per page number is equals to \"25\"")
    public void test3(){
        String pageNumber=driver.findElement(By.cssSelector("[class='btn dropdown-toggle ']")).getText();
        System.out.println(pageNumber);
        Assert.assertEquals(pageNumber,"25","number is wrong");

    }

    @Test(description = "Verify that number of calendar events (rows in the table) is equals to number of records")
    public void test4(){
        List<WebElement> elements=driver.findElements(By.xpath("//table//tbody//tr"));
        int numberOfRecords=0;
        for(WebElement element:elements){
            numberOfRecords++;
        }
        //convert int primitive to string to find out the text contains 20 or not
        Integer numberOfRecordsInteger=numberOfRecords;
        String numberOfRecordsString=Integer.toString(numberOfRecordsInteger);
//        System.out.println(numberOfRecordsString);

        //text that contains 20
        WebElement text=driver.findElement(By.xpath("//label[@class='dib'][3]"));
        String numberOfEvents=text.getText();
        //verify that there are 20 records
        Assert.assertTrue(numberOfEvents.contains(numberOfRecordsString),"records amount is wrong");


    }
    @Test(description = "Verify that all calendar events were selected")
    public void test5(){
        driver.findElement(By.xpath("//button//input")).click();
        BrowserUtils.wait(2);
        List<WebElement> boxes=driver.findElements(By.xpath("//table//tbody//tr//td//input"));
        for(WebElement box:boxes){
            Assert.assertTrue(box.isSelected());
        }


    }
    @Test(description = "Verify that following data is displayed:")
    public void test6(){
        //click the testers meeting button
        driver.findElement(By.cssSelector("[class='grid-row row-click-action']:nth-of-type(15)")).click();
        BrowserUtils.wait(1);
        List<WebElement> lines= driver.findElements(By.xpath("//div[@class='responsive-cell']"));
        for(WebElement each:lines){
            System.out.println(each.getText());
            Assert.assertTrue(each.isDisplayed());
        }


    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
