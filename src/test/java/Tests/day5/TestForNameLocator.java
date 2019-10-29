package Tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestForNameLocator {
    public static void main(String[] args) throws InterruptedException {
        //for mac user we dont need to use webdriver manager , sfari embedded webdriver suppor
        WebDriver driver= BrowserFactory.getDriver("chrome");
        //maximize screen
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
        //if you want to do in one line without creatin webelement referance variable

        //enter full name
        driver.findElements(By.name("full_name"));
        //enter email

        driver.findElements(By.name("email"));
         //click sign

        driver.findElements(By.name("wooden_spoon"));
        //pause for 3 seconds
                BrowserUtils.wait(3);
        driver.quit();

    }
}
