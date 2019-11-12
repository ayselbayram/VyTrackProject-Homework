package Tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class CssSelectorPractice {
    //which locator tu use
    //#1 id
    //#2 css
    //#3 xpath
    //#4 whatever
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //lets find all buttons and click on them one by one
        //why I put .  instead of space? because it's 2 class names btn.btn-primary
        //int his case we will find all buttons that have class=".btn.btn-primary"
        // or like this  [class='btn btn-primary], no need for .
        //. means class name
        //# mean id
        List<WebElement> buttons=driver.findElements(By.cssSelector(".btn.btn-primary"));
        //loop through  list of buttons
        for (WebElement button:buttons){
            //click every button one by one
            button.click();
            BrowserUtils.wait(1);
            //get the message after clidk
            WebElement message=driver.findElement(By.cssSelector("#result"));
            //print a text of that message
            System.out.println(message.getText());
        }
        //find element with a tag name h3, that has a parent element , with class name 'containe'
            WebElement header=driver.findElement(By.cssSelector(".container>h3"));
        System.out.println(header.getText());
        //both using css class locator is fine
            WebElement p=driver.findElement(By.cssSelector("[class='container'] p"));
        System.out.println(p.getText());



        driver.quit();
    }
}
