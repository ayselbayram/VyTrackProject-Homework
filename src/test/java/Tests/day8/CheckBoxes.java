package Tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

//command+option+L--to organize code
public class CheckBoxes {
    //private bc it will be used only in this class
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        //find the check box end click
        driver.findElement(By.linkText("Checkboxes")).click();
    }

    @Test(description = "Click on all the cehckboxes")
    public void test1(){
        //find all checkboxes
        //any check box will have[type='checkbox']
        List<WebElement> checkBoxes=driver.findElements(By.cssSelector("[type='checkbox'"));
        int index=1;
        for(WebElement checkbox:checkBoxes){
            if(!checkbox.isSelected() && checkbox.isEnabled()){
                checkbox.click();
                System.out.println("checkbox "+index +" is clicked: ");
            }else{
                System.out.println("checkbox "+index +" is not clicked: ");
            }index++;
        }

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }




}
