package Tests;
//this class be a test foundation for all test classes
//we will put here only before and after parts

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigurationReader;
import utils.Driver;

public abstract class TestBase {
    @BeforeMethod
    public void setup() {
        String url = ConfigurationReader.getProperty("url");
        Driver.get().get(url);
    }
    @AfterMethod
    public void teardown(){
        Driver.close();
    }
}
