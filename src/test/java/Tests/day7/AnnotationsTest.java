package Tests.day7;

import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationsTest {
    //runs only ones before  class  and before all tests
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }
    //runs only ones after  class  and after all tests
    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }
    @BeforeMethod
    public void setup(){
        //some  code will be running before every test, like: test1, test2, test3..
        //we can use method with @BeforeMethod annotation
        //runs aotomatically before every test
        System.out.println("Before method");

    }
    // runs aotomatically after every test
    @AfterMethod
    public void teardown(){
        System.out.println("After method");
    }
    @Test
    public void Test1(){
        System.out.println("Test 1");
        Assert.assertTrue(5==5);

    }
    @Test
    public void teat2(){
        System.out.println("Test2");

    }
    @Test
    public void test3(){
        System.out.println("Test 3");

    }




}
