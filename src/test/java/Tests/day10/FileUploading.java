package Tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FileUploading {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    @Test(description = "verify that file is uploaded")
    public void test(){
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("/Users/Filiz/Desktop/FlipgridQuestions.txt ");
        //click submit
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(4);
        String expectedFileName="FlipgridQuestions.txt";
        String actualFileName=driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName,expectedFileName,"wrong file");

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
