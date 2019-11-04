package Tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestsForNameLocator {
    public static void main(String[] args) throws InterruptedException {

        //for mac user we dont need to use webdriver manager , sfari embedded webdriver suppor
        WebDriver driver = BrowserFactory.getDriver("chrome");
        //maximize screen
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
        //if you want to do in one line without creatin webelement referance variable
        //enter full name
        driver.findElement(By.name("full_name")).sendKeys("name");
        driver.findElement(By.name("email")).sendKeys("mail@gmail.com");
        driver.findElement(By.name("wooden_spoon")).click();
        BrowserUtils.wait(3);

        driver.quit();
    }
}
