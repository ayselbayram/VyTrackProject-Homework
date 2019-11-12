package Tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class BitrixLogin {
    //credentials username=helpdesk37@cybertekschool.com
    //password: UserUser
    public static void main(String[] args) {
        //get driver methdo returns object of webdriver
        //we need webdriver reference to send commands to the browser
        //left side id reference variable to reuse this object
        //but it is gonna be possible to use object more than  one
        WebDriver driver= BrowserFactory.getDriver("chrome");
        //go to Bitrix

        driver.get("https://login1.nextbasecrm.com/");
        //enter e-mail
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk37@cybertekschool.com");
        //enter the password
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("UserUser");
        //click the Login button
        // '*' is wildcard, matches any element
        //it is better to specify tagname to avoid issues with finding element
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.quit();
    }
}
