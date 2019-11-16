package Tests.day9_review;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class Locators_review {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    //we have, id, name, tag name, class name, link text, partial link text, xpath, css selector
    @Test(description = "verify checkboxes")
    public void test1(){
        driver.findElement(By.linkText("Checkboxes")).click();
        //[type='checkbox']:nth-of-type(1)-- since there are 2 elements with a same locator
        //and I need only first one, I can uuse in css:nth-of-type(index)--1. 2. 7.
        //its very useful if you have more than one element under same css selector
        //any tag or tag=attributes: nth-of-type(index)
        WebElement checkbox1=driver.findElement(By.cssSelector("[type='checkbox']:nth-of-type(1)"));
        //how to veriy if checkbox is not clicked
        Assert.assertFalse(checkbox1.isSelected());//assert that checkbox is not selected

        //[index] --to specify index of the element, if there are multiple elements with this xpath
        WebElement checkbox2=driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        Assert.assertTrue(checkbox2.isSelected(),"checkbox2 was not selected");
        //css selector is preferable, because of speed.
        //assertion is like if statement,
//        if(true){
//            "test passed"
//        }else{
//            "test failed"
//                     throws new RuntimeException("Expected true but was false")
//        }
    }
    @Test(description = "radio buttons test")
    public void test2(){
        driver.findElement(By.linkText("Radio Button")).click();
        WebElement blueButton=driver.findElement(By.xpath("//*[text()='Blue']/preceding-sibling::input[@type='radio']"));
        Assert.assertTrue(blueButton.isSelected(),"Blue button is not selected");
    }









    @AfterMethod
    public void teardown(){
        driver.quit();
    }




}
