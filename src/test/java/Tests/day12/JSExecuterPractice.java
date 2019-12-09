package Tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class JSExecuterPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
    }

    @Test(description = "scrolling with JavaScript")
    public void test1() {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 10; i++) {
            //move 500 pixels down
            js.executeScript("window.scrollBy(0,500);");
            BrowserUtils.wait(1);
        }
    }

    @Test(description = "")
    public void test2() {
        driver.get("http://practice.cybertekschool.com/large");
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        BrowserUtils.wait(2);//demo
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //this script must scroll, until link element is not visible
        //once link element will be visible, it will stop scrolling
        //arguments[0]=means first element after comma(link)
        //argument is an Array of webelement after comma
        //argument[0]= link web element, it can be any element
        js.executeScript("arguments[0].scrollIntoView(true)", link);
        //                    Array of webelement                webelement
        BrowserUtils.wait(2);
    }
//        var btn1 = document.getElementsByTagName('a')[1];
//    btn1.click()
    @Test(description = "Click with JS executor")
    public void test3(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        //example 1 is a beginning of the phrase <a href='http:'>Example1...</a>
        WebElement link1 = driver.findElement(By.partialLinkText("Example 1"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //arguments[0]=link1 webelement
        //whenever regular selenium methods are not working, i use js executor
        //or for scrolling
        //argument[0].click() is alternative for link.click()
        js.executeScript("arguments[0].click()", link1);
        BrowserUtils.wait(2);
    }
    //document.getElementsByName('full_name')[0].setAttribute('value','My name')
    @Test(description = "Enter text with JS executer")
    public void test4(){
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement name=driver.findElement(By.name("full_name"));
        WebElement email=driver.findElement(By.name("email"));
        WebElement submitButton = driver.findElement(By.name("wooden_spoon"));
        //to create javascriptexecutor object we need to cast webdriver object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //enter full name
        //arguments[0].setAttribute('value', 'John Smith') it's the same as name.sendKeys("John Smith");
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].setAttribute('value', 'John Smith')", name);
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].setAttribute('value', 'someemail@email.com')", email);
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].click()", submitButton);
        BrowserUtils.wait(2);




    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
