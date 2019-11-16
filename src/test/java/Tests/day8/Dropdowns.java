package Tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class Dropdowns {
    private WebDriver driver;

    //<select id="dropdown">
    //      <option value="" disabled="disabled" selected="selected">Please select an option</option>
    //      <option value="1">Option 1</option>
    //      <option value="2">Option 2</option>
    //    </select>
    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Dropdown")).click();

    }

    @Test(description = "Select option 2 from the dropdown")
    public void test1() {
        //to work with select dropdowns we need to use select class in Selenium
        //step1: find dropdown and create a webelement
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //step2: create a select object
        //select class requires webelement object as a parameter
        Select select = new Select(dropdown);
        //to select any option by visible text:
        //also you can select by value or index
        //<option value="1">Option 1</option>. Option 1 is visible text, in between >text<, (in betwees angle brackets)
        select.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        //how to verify that option 2is selected-to get selected option/this is what is selected
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
    }

    @Test(description = "print list of all states")
    public void test2() {
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
        List<WebElement> states = select.getOptions();//will return available options to select
        for (WebElement option : states) {
            System.out.println(option.getText());

        }

    }

    @Test(description = "Select your state and verify that state is selected")
    public void test3() {
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
        //<option value="MA">Massachusetts</option>
        //we can use text, value and index for selection
        select.selectByValue("MA");
        BrowserUtils.wait(2);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Massachusetts");
    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
