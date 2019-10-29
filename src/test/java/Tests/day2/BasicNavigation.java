package Tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
/*
   .get("url")--> to open a website
   .close() method-->to close the browser
   .quit()method-->
    ####difference between close and quit method?
    .close()-->closes only that current tab
    .quit()-->will shutdown entire browser,regardless on number of tabs.
     because we can have opened multiple tabs/windows int the same browse.
     Also, .quit() will make driver /sessionid null.
 */

public class BasicNavigation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        //to maximize browser
        driver.manage().window().maximize();
        driver.get("http:/google.com");
        //we want to navigate to the different page
        //within same browser
        //we not open new browser or new tab
        //URL can be passed as an object ar a string
        driver.navigate().to("http://Amazon.com");
        //if I want to come back to the previous page

        driver.navigate().back();
        //if I want to know URl for current website
        String url=driver.getCurrentUrl();
        System.out.println(url);
        //selenium does not close browser automatically for this we use method close()
        driver.close();


    }

}
