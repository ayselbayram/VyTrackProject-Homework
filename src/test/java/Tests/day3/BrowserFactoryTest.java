package Tests.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class BrowserFactoryTest {
    public static void main(String[] args) {
        //we can get driver with getDriver method, will return webdriver object
        //and we can use reference variable to work with taht object
        WebDriver driver=BrowserFactory.getDriver("chrome");
        driver.get("http://http://practice.cybertekschool.com/");
        //how we can print a source code of the page
        System.out.println(driver.getPageSource());
        driver.quit();

    }
}
