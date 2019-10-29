package Tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestsForClassNameLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //h3 it is a class name or value of class attribute
        //if class has text with a sspace, that means there are 2 class values, better be use some other locator(css)
        WebElement heading=driver.findElement(By.className("h3"));
        //we can read the text of attribute
        System.out.println(heading.getText());

        BrowserUtils.wait(3);

        driver.quit();

    }
}
