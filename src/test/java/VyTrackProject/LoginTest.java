package VyTrackProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {
        //set up the chrome browser
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        //get the vytrack log in page
        driver.get("http://qa2.vytrack.com/user/login");
        //find the user name locator
        WebElement button=driver.findElement(By.name("_username"));
        //enter the user name
        button.sendKeys("user20 ");
        //find the password locator
        WebElement button2=driver.findElement(By.name("_password"));
        //enter the password
        button2.sendKeys("UserUser123");
       //find the login button locator
       WebElement button3=driver.findElement(By.id("_submit"));
       //click button
       button3.click();
      //check the expected url and actuall url results for test
       String expectedURL="https://qa2.vytrack.com/";
       String actualURL = driver.getCurrentUrl();
       if(expectedURL.equals(actualURL)){
           System.out.println("Pass");
       }else{
           System.out.println("Failed");
       }
       driver.close();



    }

}
