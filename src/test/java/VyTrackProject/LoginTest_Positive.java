package VyTrackProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.StringUtility;

public class LoginTest_Positive {
    public static void main(String[] args) {
        //set up the chrome browser

        WebDriver driver= BrowserFactory.getDriver("chrome");
        //get the vytrack log in page
        driver.get("http://qa2.vytrack.com/user/login");
        //find the user name locator
        WebElement userNameButton=driver.findElement(By.name("_username"));
        //enter the user name
        userNameButton.sendKeys("user20 ");
        //find the password locator
        driver.findElement(By.name("_password")).sendKeys("UserUser123");;
        //enter the password

       //find the login button locator
       WebElement submitButton=driver.findElement(By.id("_submit"));
       //click button
       submitButton.click();
      //check the expected url and actuall url results for test
       String expectedURL="https://qa2.vytrack.com/";
       String actualURL = driver.getCurrentUrl();
       StringUtility.verifyEquals(expectedURL,actualURL);

       driver.close();





    }

}
