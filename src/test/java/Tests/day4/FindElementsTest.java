package Tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FindElementsTest {
    /*Go to http://practice.cybertekschool.com/forgot_password
Click on retrieve password button
Verify that page title didn't change (in this case, we verify that same page is still open)

     */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        //once we open the page, we have to capture the title
        String expectedTitle=driver.getTitle();

        //step 1:Open ispector in chrome and find locator for the element
        //step2: Create object of webElement
        //step3: use webelement
        WebElement button=driver.findElement(By.id("form_submit"));
        //to click on the elemet
        button.click();
        String actuallTitle=driver.getTitle();
        //in this way we are making sure after the clicking we stay on the same page
        //wait for 2 seconds
        if(actuallTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
            System.out.println("expected title: "+expectedTitle);
            System.out.println("Actual title: "+actuallTitle);
        }
        BrowserUtils.wait(2);
        driver.close();

    }
}

