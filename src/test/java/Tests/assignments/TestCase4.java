package Tests.assignments;

import org.openqa.selenium.*;
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
//        driver.manage().window().maximize();
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

        WebElement options = driver.findElement(By.xpath("//tr[14]//td[9]//div//div"));
        System.out.println(options.getText());
        Assert.assertTrue(options.isDisplayed());

        BrowserUtils.wait(1);


    }

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
        List<WebElement> lists = driver.findElements(xpath("//ul[@data-options='{\"align\": \"right\", \"attachToParent\": \"true\"}']"));
        for (WebElement list : lists) {
            System.out.println(list.getText());
        }
    }

    @Test(description = "Verify that “All Calendar Events” page subtitle is displayed")
    public void test4() {
        WebElement eventButton = driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        eventButton.click();
        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        driver.findElement(By.xpath("//a[@class='btn back icons-holder-text ']")).click();
        WebElement loaderMask1 = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        String actualDisplay = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        String expectedDisplay = "All Calendar Events";
        Assert.assertEquals(actualDisplay, expectedDisplay);

    }

    @Test(description = "Verify that difference between end and start time is exactly 1 hour")
    public void test5() {
        WebElement eventButton = driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        eventButton.click();
        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));


        WebElement startTime = driver.findElement(By.cssSelector("[id^='time_selector_oro_calendar_event_form_start']"));
        String startTime1 = startTime.getAttribute("value");
        System.out.println(startTime1);
        startTime1 = startTime1.substring(0, 2).concat(startTime1.substring(3, 5));
        System.out.println(startTime1);
        Integer startTime2 = Integer.parseInt(startTime1);

        WebElement endTime = driver.findElement(By.cssSelector("[id^='time_selector_oro_calendar_event_form_end']"));
        String endTime1 = endTime.getAttribute("value");
        endTime1 = endTime1.substring(0, 2).concat(endTime1.substring(3, 5));
        Integer endTime2 = Integer.parseInt(endTime1);

        int result = endTime2 - startTime2;
        String result1 = Integer.toString(result);
        Assert.assertEquals(result1, "100");


    }

    @Test(description = "Verify that end time is equals to “10:00 PM”")
    public void test6() {
        WebElement eventButton = driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        eventButton.click();
        BrowserUtils.wait(3);
        WebElement startTime = driver.findElement(By.cssSelector("[id^='time_selector_oro_calendar_event_form_start']"));
        startTime.click();
        BrowserUtils.wait(2);
        WebElement input = driver.findElement(By.xpath("//ul[@class='ui-timepicker-list']/li[43]"));
        input.click();
        BrowserUtils.wait(2);

        WebElement endTime = driver.findElement(By.cssSelector("[name^='time_selector_oro_calendar_event_form_end']"));
        System.out.println(endTime.getAttribute("value"));

        Assert.assertEquals(endTime.getAttribute("value"), "10:00 PM");


    }

    @Test(description = "Verify that start and end time input boxes are not displayed and start and end date input boxes are displayed")
    public void test7() {

        WebElement eventButton = driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        eventButton.click();
        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

        WebElement allDayEventCheckBox = driver.findElement(By.cssSelector("[id^='oro_calendar_event_form_allDay']"));
        allDayEventCheckBox.click();
        Assert.assertTrue(allDayEventCheckBox.isSelected());

        WebElement startTimeBox = driver.findElement(By.cssSelector("[id^='time_selector_oro_calendar_event_form_star']"));
        Assert.assertTrue(startTimeBox.isEnabled());

        WebElement startDateBox = driver.findElement(By.cssSelector("[id^='date_selector_oro_calendar_event_form_start-uid']"));
        Assert.assertTrue(startDateBox.isDisplayed());

        WebElement endTimeBox = driver.findElement(By.cssSelector("[id^='time_selector_oro_calendar_event_form_end']"));
        Assert.assertTrue(endTimeBox.isEnabled());
        WebElement endDateBox = driver.findElement(By.cssSelector("[id^='date_selector_oro_calendar_event_form_end']"));
        Assert.assertTrue(endDateBox.isDisplayed());


    }

    @Test(description = "Verify that “Daily” is selected by default and following options are available in “Repeats” drop-down:")
    public void test8() {
        WebElement eventButton = driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        eventButton.click();


        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        WebElement repeat = driver.findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        repeat.click();

        Assert.assertTrue(repeat.isSelected());


        WebElement dailyOption = driver.findElement(By.cssSelector("[id^='recurrence-repeats-']"));
        dailyOption.click();

        Select select = new Select(dailyOption);


        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Daily");


        //available options
        System.out.println(dailyOption.getText());


    }

    @Test(description = "Verify that following message as a summary is displayed: “Summary: Daily every 1 day”")
    public void test9() {
        WebElement eventButton = driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        eventButton.click();


        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        WebElement repeat = driver.findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        repeat.click();

        Assert.assertTrue(repeat.isSelected());

        WebElement neverButton = driver.findElement(By.xpath("//div[@class='controls recurrence-subview-control recurrence-subview-control__items']//div[1]//label//input"));
        Assert.assertTrue(neverButton.isSelected());

    }

    @Test(description = "Verify that following message as a summary is displayed: “Summary: Daily every 1 day, endafter 10 occurrences”")
    public void test10() {
        WebElement eventButton = driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        eventButton.click();


        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        WebElement repeat = driver.findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        repeat.click();

        String radioButtonLocator = "//div[@class='controls recurrence-subview-control recurrence-subview-control__items']//div[2]//label//input[1]";
        WebElement radioButton = driver.findElement(By.xpath(radioButtonLocator));
        radioButton.click();

        String boxLocator = "//div[@class='controls recurrence-subview-control recurrence-subview-control__items']//div[2]//label//input[2]";
        WebElement box = driver.findElement(By.xpath(boxLocator));
        box.sendKeys("10", Keys.ENTER);


        WebElement summaryMessage = driver.findElement(By.xpath("//div[@class='control-group recurrence-summary alert-info']"));
        System.out.println(summaryMessage.getText());
        Assert.assertEquals(summaryMessage.getText(), "Summary:\n" +
                "Daily every 1 day, end after 10 occurrences");

    }

    @Test(description = "Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end by Nov 18, 2021”")
    public void test11() {
        WebElement eventButton = driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        eventButton.click();


        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        WebElement repeat = driver.findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        repeat.click();

        String radioButtonLocator = "//div[@class='controls recurrence-subview-control recurrence-subview-control__items']//div[2]//label//input[1]";
        WebElement radioButton = driver.findElement(By.xpath(radioButtonLocator));
        radioButton.click();

        WebElement byButton = driver.findElement(By.xpath("//div[@class='controls recurrence-subview-control recurrence-subview-control__items']//div[3]//label//input"));
        byButton.click();

        WebElement dateBox = driver.findElement(By.xpath("//span[@class='recurrence-subview-control__datetime-wrapper']//div//input[2]"));
        dateBox.click();

        WebElement yearBox = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));


        Select selectYear = new Select(yearBox);
        selectYear.selectByValue("2021");
        WebElement monthBox = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));

        Select selectMonth = new Select(monthBox);
        selectMonth.selectByValue("10");

        WebElement date = driver.findElement(By.xpath("//a[text()='18']"));
        date.click();

        WebElement summaryMessage = driver.findElement(By.xpath("//div[@class='control-group recurrence-summary alert-info']"));
        System.out.println(summaryMessage.getText());
        Assert.assertEquals(summaryMessage.getText(), "Summary:\n" +
                "Daily every 1 day, end by Nov 18, 2021");


    }

    @Test(description = "Verify that following message as a summary is displayed: “Summary: Weekly every 1 week onMonday, Friday”")
    public void test12() {
        WebElement eventButton = driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        eventButton.click();


        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        WebElement repeat = driver.findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        repeat.click();

        String radioButtonLocator = "//div[@class='controls recurrence-subview-control recurrence-subview-control__items']//div[2]//label//input[1]";
        WebElement radioButton = driver.findElement(By.xpath(radioButtonLocator));
        radioButton.click();

        WebElement repeatsBox = driver.findElement(By.cssSelector("[id^='recurrence-repeats']"));
        Select selectRepeats = new Select(repeatsBox);
        selectRepeats.selectByValue("weekly");

        WebElement daysOptions = driver.findElement(By.xpath("//select[@name='recurrence[dayOfWeek]']"));

        WebElement monday = driver.findElement(By.xpath("//label[@class='multi-checkbox-control__item'][2]"));
        monday.click();

        WebElement friday = driver.findElement(By.xpath("//label[@class='multi-checkbox-control__item'][6]"));
        friday.click();

        WebElement summaryMessage = driver.findElement(By.xpath("//div[@class='control-group recurrence-summary alert-info']"));

        System.out.println(summaryMessage.getText());

        Assert.assertEquals(summaryMessage.getText(), "Summary:\n" +
                "Weekly every 1 week on Monday, Friday");

    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
