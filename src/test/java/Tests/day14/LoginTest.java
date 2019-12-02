package Tests.day14;

import Tests.TestBase;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

public class LoginTest extends TestBase {
    @Ignore
    @Test
    public void test1(){
        //read url value from properties file
        String url= ConfigurationReader.getProperty("url");
        //Driver.ger()--will return webdriver object
        //and then we can call webdriver methods like get(), find element()....
        //WebDriver driver=Driver.get();
        Driver.get().get(url);
        //print page title
        System.out.println(Driver.get().getTitle());
        BrowserUtils.wait(2);
        //to close
        Driver.close();

    }
    @Test

    public void test2(){
        System.out.println(Driver.get().getTitle());
        BrowserUtils.wait(2);
    }
}
