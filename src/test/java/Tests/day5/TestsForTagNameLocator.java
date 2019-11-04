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

        driver.findElement(By.name("full_name")).sendKeys("name");
        //if you want to do in one line without creatin webelement referance variable
        //enter email
        driver.findElement(By.name("email")).sendKeys("email@gmail.com");
        driver.findElement(By.name("wooden_spoon")).click();
        BrowserUtils.wait(3);
        // <h3 class="h3">Multiple buttons</h3>
//        h3 - it's a class name, or value of class attribute
        WebElement sub_header=driver.findElement(By.tagName("h3"));
        //we can read the text of attribute
        System.out.println(sub_header.getText());

        driver.quit();
    }
}
