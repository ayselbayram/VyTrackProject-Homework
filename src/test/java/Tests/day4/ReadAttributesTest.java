package Tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class ReadAttributesTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement input=driver.findElement(By.name("email"));
        //to read value of any attribute
        //name:"email"name ist and attribute, email is the value of the attribute
        System.out.println(input.getAttribute("pattern"));


        input.sendKeys("randonm@email.com");
        //hot to read entered text?
        //it is going to be inside the "value" attribute
        System.out.println(input.getAttribute("value"));
        //if button has a type "submit"
        //we can use .submit() instead of click() aswell
        WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));
        //alternative to clik, only if type="submit"
        retrievePasswordButton.submit();
        BrowserUtils.wait(3);
        driver.close();
    }
}
