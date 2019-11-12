package Tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class WarmUp {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://cybertekschool.com/");
        //how to find all links
        //every 'link' as a tag name have <a>
        List<WebElement> links=driver.findElements(By.xpath("//a"));
        //size of the links= number of links
        //findElement vs findElements
        //in case of find elements if there is no element found, you will get exception
        //NoSuchElementException
        //findElement=only 1 webElement
        //findElements=0 or more elements
        //if list is empty, that means element is not there
        //in this way we can ensure that element is not present
        // //a[.='Home'] or //a[text()='Home'] -find link with name Home
        System.out.println("Number of links: "+links.size());
        //what if I want to print text of all links, one  by one
        //since we need from start to end we can use for each loop
        for(WebElement webElement:links){
            //print text of every link
            //if text is there
            if(webElement.getText().isEmpty()){
                continue;

            }
            //or
           //  if(!webElement.getText().isEmpty())//if not empty
            System.out.println(webElement.getText());
        }
        driver.quit();
    }


}
