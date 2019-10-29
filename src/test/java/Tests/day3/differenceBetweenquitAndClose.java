package Tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class differenceBetweenquitAndClose {
    /*
    we will use  http://practice.cybertekschool.com/
    after 3 seconds new tab will be open
    question
    question: do we need to write code to allow for pop up in the future?
    ---no, by default. when we are running test , this feature is disabled
    *will pause program execution for 4 seconds
    //sleep methods throws checked exception, that you need to take care of,
    //before running the program otherwise you get compilation er.
    //At this point just add "throws InterruptedException" int the method signature
    when you see mills, its not a value that you pass, its the name of parameter.
    it is a place holder.
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();//to set up web driver
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(4000);
        //lets try to close browser
        //driver.close();//current tap closed only not the whole browser
        driver.quit();//to shutdown entire browser
    }
}
