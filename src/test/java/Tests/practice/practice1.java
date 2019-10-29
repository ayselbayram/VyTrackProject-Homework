package Tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");
        Thread.sleep(3000);
        driver.navigate().to("http://instagram.com");
        Thread.sleep(3000);
        driver.navigate().back();
        String url=driver.getCurrentUrl();
        System.out.println(url);
        driver.navigate().to("http://practice.cybertekschool.com/");
//        driver.close();



    }
}
