package Tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TesteForLinkText {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        //<a href="/autocomplete">Autocomplete</a>
        //Autocoplite-its the text you see in the link
        //place where it will navigate you specified in href
        //it works only if tag name is<a>//if you want to use linktext or partial text locator strategy
        //elements must
        driver.findElement(By.linkText("Autocomplete")).click();

        BrowserUtils.wait(3);

        driver.quit();
    }
}
