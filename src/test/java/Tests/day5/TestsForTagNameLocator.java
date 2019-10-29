package Tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestsForTagNameLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
        //if you want to do in one line without creatin webelement referance variable
        driver.findElements(By.name("full_name"));
        //enter email

        driver.findElements(By.name("email"));
        //click sign

        driver.findElements(By.name("wooden_spoon"));
        //pause for 3 seconds
        BrowserUtils.wait(3);
        WebElement sub_header =driver.findElement(By.tagName("h3"));

        System.out.println(sub_header);






        driver.quit();
    }
}
