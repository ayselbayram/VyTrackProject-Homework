package Tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestsForIDLocator {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
//  id="disappearing button"
        WebElement button=driver.findElement(By.id("disappearing_button"));
        button.click();
        WebElement result=driver.findElement(By.id("result"));
        //Now it's gone--- text, .getText() will return this text
        System.out.println(result.getText());



        driver.quit();
    }
}
