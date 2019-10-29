package Tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class EnterTextPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement inputBox=driver.findElement(By.name("email"));
        //we enter the text
        inputBox.sendKeys("random@email.com");
        WebElement button=driver.findElement(By.id("form_submit"));
        //to click on the element
        button.click();
        String expectedURL= "http://practice.cybertekschool.com/email_sent";
        String actualURL=driver.getCurrentUrl();
        if(expectedURL.equalsIgnoreCase((actualURL))){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
        BrowserUtils.wait(2);
        driver.close();
    }
}
