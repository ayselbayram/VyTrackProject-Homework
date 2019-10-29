package Tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class EnterTextPractice2 {
    /*
    1. Go to "http://practice.cybertekschool.com/forgot_password"
2. Enter any valid email
3. Click on retrieve password button
4. Verify that message "Your e-mail's been sent!" is displayed
     */
    public static void main(String[] args) {
        //as usually we are starting from driver set up
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement login=driver.findElement(By.name("email"));
        login.sendKeys("random@email.com", Keys.ENTER);
        WebElement confirmationmessage=driver.findElement(By.name("confirmation_message"));
        String expectedMessage="Your e-mail's been sent!";
        //to get the text from element
        String actualMessage=confirmationmessage.getText();
        if(expectedMessage.equals(actualMessage)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");

        }
        driver.close();




    }
}
