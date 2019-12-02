package Tests.vytrack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class TestCase4 {
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

    @Test(description = "Verify that “view”, “edit” and “delete” options are available")
    public void test1() {
        WebElement options = driver.findElement(xpath("//table[@class='grid table-hover table table-bordered table-condensed']//tbody//tr[13]//td[9]"));
        Actions action = new Actions(driver);
        action.moveToElement(options).perform();
        BrowserUtils.wait(1);

        for(int i=1;i<4;i++) {
            List <WebElement> list=driver.findElements(By.xpath("//table//tr[13]//td[9]//div//div//ul//li//ul//li//a[" + i + "]"));
            System.out.println(list.get(i).getText());
            }
        }


    ////div[@class='table-wrapper']//table//tbody//tr

    @Test(description = "Verify that “Title” column still displayed")
    public void test2() {
        WebElement gridButton = driver.findElement(By.cssSelector("[class='fa-cog hide-text']"));
        gridButton.click();
        BrowserUtils.wait(1);
        List<WebElement> checkboxes = driver.findElements(xpath("//table[@class='grid table-hover table table-condensed']//tr//td[3]"));
        for (int i = 1; i < checkboxes.size(); i++) {
            checkboxes.get(i).click();
            BrowserUtils.wait(1);
        }
        WebElement title = driver.findElement(xpath("//table[@class='grid table-hover table table-condensed']//tr//td[3]"));
        Assert.assertTrue(title.isDisplayed());
    }

    @Test(description = "Verify that “Save And Close”, “Save And New” and “Save” options are available")
    public void test3() {
        WebElement createEvent = driver.findElement(xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        createEvent.click();
        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        driver.findElement(xpath("//a[@class='btn-success btn dropdown-toggle']")).click();
        BrowserUtils.wait(1);//for demo
        List<WebElement> lists=driver.findElements(xpath("//ul[@data-options='{\"align\": \"right\", \"attachToParent\": \"true\"}']"));
        for(WebElement list: lists){
            System.out.println(list.getText());
        }
    }
    @Test(description = "Verify that “All Calendar Events” page subtitle is displayed")
    public void test4(){
        WebElement eventButton=driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        eventButton.click();
        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        driver.findElement(By.xpath("//a[@class='btn back icons-holder-text ']")).click();
        WebElement loaderMask1 = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        String actualDisplay=driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        String expectedDisplay="All Calendar Events";
        Assert.assertEquals(actualDisplay,expectedDisplay);

    }
    @Test
    public void test5(){
        WebElement eventButton=driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        eventButton.click();
        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));


       WebElement num1=driver.findElement(By.id("#time_selector_oro_calendar_event_form_start-uid-5de0b4be8035d"));
        System.out.println((num1.getText()));
    }
    @Test
    public void test6(){
        WebElement eventButton=driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        eventButton.click();
        BrowserUtils.wait(3);
        WebElement startTime=driver.findElement(By.cssSelector("div[class='fields-row timepicker-dialog-is-below']"));
        Select select=new Select(startTime);
        select.selectByVisibleText("9:00 PM");

    }
    @Test
    public void test7(){

        WebElement eventButton=driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        eventButton.click();
        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        BrowserUtils.wait(2);
        driver.findElement(By.id("oro_calendar_event_form_allDay-uid-5de0c3d2f3643")).click();

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
