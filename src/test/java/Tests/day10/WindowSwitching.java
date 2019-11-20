package Tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Set;

public class WindowSwitching {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();

    }
    @Test(description = "verify that title is still practice")
    public void test1(){
        driver.findElement(By.linkText("New tab")).click();
        //after 3 seconds another website will be opened, in the second window
        //selenium doesnt switch automatically to the new window
        BrowserUtils.wait(4);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Practice","title is wrong");
    }
    @Test(description = "verify that user is able to see new window, switch between the windows")
    public void test2(){
        driver.findElement(By.linkText("New tab")).click();
        //record id of original window, that we opened initially
        String oldWindow=driver.getWindowHandle();
        //after 3 seconds another website will be opened, in the second window
        //selenium doesnt switch automatically to the new window
        BrowserUtils.wait(5);
        //in the selenium every window has an ID. that id calls window handle
        //to read window handle we use method "getWindowHandle()"
        //after new window was open we can get list of all window id's, or window handles

        //list is a data structure
        //set is also data structure, like list but it does not allowed duplicates
        //also you can not easily access anything from there
        //there is no .get()
        //that is why we need to loop through the set to read a data from there
        //set can store only unique values
        Set<String> windowHandles=driver.getWindowHandles();
        //loop through the collection of window handles
        for(String windowHandle:windowHandles){
            //if it is not an old
            if(!windowHandle.equals(oldWindow)){
                //switch to that windo
                driver.switchTo().window(windowHandle);
            }
        }
        //lets verify that title of new window is a Fresh tab
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Fresh tab","title is wrong");

        //come back tp original page
        //we can build a function, that will jump, in between windows
        //based on page title, we can determine where to stop
        String pageTitle="Practice";//title of the page that we want
        for(String windowHandle:windowHandles){
            //keep jumping from window to window
            driver.switchTo().window(windowHandle);
            //once we found page title, of the window that we need
            if(driver.getTitle().equals(pageTitle)){
                //just exit
                //stop jumping
                break;
            }
        }System.out.println(driver.getTitle());


    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
