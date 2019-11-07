package VyTrackProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserFactory;
import utils.StringUtility;

public class LoginTest_Negative {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("Chrome");
        //go to the webpage
        driver.get("https://qa2.vytrack.com/user/login");
        //find the u'ser name box 'element
        driver.findElement(By.id("prependedInput")).sendKeys("filiz");
        //find the 'passeord box' element
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        //find the 'submit' key element
        driver.findElement(By.id("_submit")).click();
        String ActualMessage=driver.findElement(By.xpath("//div[@class='alert alert-error']//div")).getText();
        //*[@id="login-form"]/fieldset/div[1]/div

        String expectedMessage="Invalid user name or password.";
        //to verify the result of the expected and actual message
        StringUtility.verifyEquals(ActualMessage,expectedMessage);

        driver.close();

    }
}
