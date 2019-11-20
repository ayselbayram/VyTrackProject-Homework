package Tests.day10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class PopUpPractice {
    private WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");


    }
    @Test(description = "click OK on button 1 and click  in popup message")
    public void test1(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        BrowserUtils.wait(2);
        //to deal with popup, we can create object of Alert
        //switches to the currently active modal dialog
        Alert alert=driver.switchTo().alert();
        alert.accept();

    }
    @Test(description = "click on button 2 and cancel in popup message")
    public void test2(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        //[2] means second button out of available, since there are 3 buttons
        //I use index
        driver.findElement(By.xpath("//button[2]")).click();
        BrowserUtils.wait(2);
        Alert alert=driver.switchTo().alert();
        //print text of the popup message
        System.out.println(alert.getText());
        //to click cancel
        alert.dismiss();
        BrowserUtils.wait(2);
        //to print text of result
        System.out.println(driver.findElement(By.id("result")).getText());
    }
    @Test(description = "click on button 3, enter some text and then click ok")
    public void test3(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        BrowserUtils.wait(2);
        driver.switchTo().alert().sendKeys("Java is fun");
        BrowserUtils.wait(5);
        driver.switchTo().alert().accept();
        //to print text result
        //should be java is fun
        System.out.println(driver.findElement(By.id("result")).getText());

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
