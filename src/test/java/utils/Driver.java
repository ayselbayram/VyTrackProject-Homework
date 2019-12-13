package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static WebDriver driver;
    //to prevent instantiate of the class
    //you can not do like this, is constructor is private
    //Driver obj=new Driver();
    private Driver(){

    }
    //if switch statement complaints on string parameter
    //change java version for 7+ atleast
    public static WebDriver get(){
        //if webdriver object was not created yet
        if(driver==null){
            //create webdriver object from on browser value from properties file
            String browser=ConfigurationReader.getProperty("browser");
            switch(browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    //to run test without interface
//                    ChromeOptions chromeOptions=new ChromeOptions();
//                    chromeOptions.setHeadless(true);
//                    driver=new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                default:
                    //if browser is wrong, stop tests throw exception
                    //no browser will be open
                    throw new RuntimeException("wrong browser type!");
            }
        }
        //if webdriver object was created -you can use it
        return driver;
    }
    public static void close(){
        //if driver still exist
        if(driver!=null){
            //close all browsers
            driver.quit();
            //destroy driver object, ready fog GC(garbage collector)
            driver=null;
        }
    }

}
