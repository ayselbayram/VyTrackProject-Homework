package Tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FramesPractice {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/frames");
    }
    @Test(description = "iFrame example")
    public void test1(){
       driver.findElement(By.linkText("iFrame")).click();
       //since element inside the frame, element is not visible for selenium without switching to the frame
        //we can switch to frame on id, name, index(starting from 0), web element
        driver.switchTo().frame("mce_0_ifr");
        //without wsitching we can not see innner HTML document
        //which one to use,id, name, index(starting from 0), webElement
        //1. id or name
        //2. webelement--driver.findelement(By.cssSelector("iframe[....
        //3. indet--[iframe1, iframe2, iframe3...]

        WebElement inputArea=driver.findElement(By.id("tinymce"));
        String expected="Your content goes here.";
        String actual=inputArea.getText();
        Assert.assertEquals(actual,expected);

        BrowserUtils.wait(1);

        inputArea.clear();//to clear text

        BrowserUtils.wait(1);

        inputArea.sendKeys("Java is fun");
        BrowserUtils.wait(1);


        //to exit from frame
        driver.switchTo().defaultContent();
        BrowserUtils.wait(2);
    }
   //incase of nested frames we must swith to first frame, then again to another frame
    //--html--frame#1----frame#2
    @Test(description = "nested frames exmaple")
    public void test2(){
        driver.findElement(By.linkText("Nested Frames")).click();
        //we swith to frame based on webelement
        driver.switchTo().frame(driver.findElement(By.cssSelector("[name='frame-bottom']")));
        //the reason why we are switching here
        //is because content that is inside the frame is not visible for selenium
        //it's like when you are on the 1. floor trying to find what is on the 2. floor
        WebElement content=driver.findElement(By.tagName("body"));
        System.out.println(content.getText());
        driver.switchTo().defaultContent();//to exit from all frames, go to 1. floor
        //come back to original document

        driver.switchTo().frame("frame-top");//2. floor
        driver.switchTo().frame("frame-left");//3. floor
        System.out.println(driver.findElement(By.tagName("body")).getText());

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
