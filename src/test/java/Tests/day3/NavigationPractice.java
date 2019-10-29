package Tests.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class NavigationPractice {
    public static void main(String[] args) throws InterruptedException {
        //create a webdriver object, to work with browser
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();//to maximize browser window
        driver.get("http://google.com");
        //wait for 3 seconds
        //this is our costom methods
        //since methods is tatic we use class name to call method
        //as a parameter we provide number of seconds(time in secinds)
        BrowserUtils.wait(3);
        //how to print page title

        System.out.println(driver.getTitle());
        driver.navigate().to("http://amazon.com");
        //navigate back to google(previous url)
        driver.navigate().back();
        //move forward to the amazon again
        driver.navigate().forward();
        //to refresh /reload web page/website
        driver.navigate().refresh();
        //shut down brpwser
       // driver.close();//if we have only tab it will close the whole browser,we can not use driver anymore
        //we have to recreate object of webdrive
        //if we have more than tab we can keep working
        driver.quit();
        //what will happen, if I call driver again after quit
        //you can not call driver after quit, otherwise you get an exception
//        driver.get("http://google.com");

    }
    /*
getTilte() - to get page title
getCurrentUrl() - to get URL of the current website
close() - to close current tab. it's it's a last tab - it will also shutdown a browser and session.
quit() - to close all tabs that were opened by webdriver.
navigate().to(URL) - to jump to other website. It will not open a new tab/browser.
navigate().back() - comeback to previous website
navigate().forward() - to move forward in the browser history. Usually, used after navigate().back().
navigate().refresh() - to refresh a website.
manage().window().maximize() - to maximize window
manage().window().fullscreen() - to run browser in the fullscreeen mode
     */
}
