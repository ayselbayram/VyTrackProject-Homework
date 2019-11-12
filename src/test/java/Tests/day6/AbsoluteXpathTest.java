package Tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class AbsoluteXpathTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/company/");
        //click on log in without entering user name and password
        //to invoke warnin message
        driver.findElement(By.className("login-btn")).click();
        BrowserUtils.wait(2);
        WebElement warningMessage=driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/div/div/div[2]"));
        //command+z+shift --step forward
        System.out.println(warningMessage.getText());//to read the text of warning message
        //to end the text execution
        driver.close();




    }
}
