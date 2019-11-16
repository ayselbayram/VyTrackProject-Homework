package Tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class RadioButtons {
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        //to go to radio buttons page
        //<a href="/radio_buttons">Radio Buttons</a>, <a means link
        //link text locator works only with<a> elements
        //link text only in between >text<

        //this step is common for all test cases that is why I put it beforemethod
        driver.findElement(By.linkText("Radio Buttons")).click();
    }
    @Test(description = "verify that blue button is selected")
    public void test1(){

        //find blue button radio
        WebElement bluebutton=driver.findElement(By.id("blue"));
        //lets verify that radio button is selected
        //if button selected it will return true, otherwise false
        //isSelected() returns true if it is selected or not
        Assert.assertTrue(bluebutton.isSelected());//will expected that isselected is tru

    }
    @Test(description = "verify that red button is not selected")
    public void test2(){
        WebElement redbutton=driver.findElement(By.id("red"));
        //isSelected() return true if button is clciked
        Assert.assertFalse(redbutton.isSelected());//assertFalse will expect that condition is false
    }

    @Test(description = "verify that green button is not  clickable")
    public void test3(){
        WebElement greenbutton=driver.findElement(By.id("green"));
        //isEnabled() will return true if button is available for interaction
        //that means you can click on it
        Assert.assertFalse(greenbutton.isEnabled());

    }

    //lets find all radio buttons and click on them one by one
    @Test(description = "click on all radio buttons")
    public void test4(){
        //hot to find all radio buttons
        //find all radio buttons
        //any radio button will have type='radio' and input as a element type
        List<WebElement> radiobuttons=driver.findElements(By.cssSelector("input[type='radio']"));
        //lets clcik onlt if button is not clciked and available for click
        for (WebElement button:radiobuttons ){
      //if button is available for clicking and is not click yet
            if(button.isEnabled() && !button.isSelected()){
                //then click
                button.click();
                //in this case id attribute represent of the color
                //also there is no text in this element that is why I print attribute value
                //attributes, type, id, name, disabled
                System.out.println("Button clciked: "+button.getAttribute("id"));
            }else{
                System.out.println("Button was not clicked: "+button.getAttribute("id"));
            }
            BrowserUtils.wait(1);//just for demo
        }

    }












    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
