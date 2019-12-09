package Tests.vytrack;

import Pages.CreatCarPage;
import Pages.LoginPage;
import Pages.VehiclesPage;
import Tests.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.Driver;

public class CreateCarTests extends TestBase {


    @Test(description = "create some random car")
    public void test1(){

        extentTest=extentReports.createTest("create a new car");
        LoginPage loginpPage=new LoginPage();
        VehiclesPage vehiclePage=new VehiclesPage();
        CreatCarPage createCarPage=new CreatCarPage();

        loginpPage.login("storemanager85","UserUser123");
        loginpPage.navigateTo("Fleet","Vehicles");

        loginpPage.waitUntilLoaderMaskDisappear();
        vehiclePage.clickToCreateACar();

        loginpPage.waitUntilLoaderMaskDisappear();
        Driver.get().findElement(By.cssSelector("[id^='custom_entity_type_LicensePlate']")).sendKeys("123");

//        createCarPage.licensePlateElement.sendKeys("12344");
        createCarPage.selectTags("Compact");
//        Driver.get().findElement(By.cssSelector("div[id*='FuelType']")).click();
        createCarPage.selectFuelType("Diesel");

        loginpPage.waitUntilLoaderMaskDisappear();

        createCarPage.saveAndCloseButtonElement.click();
        extentTest.pass("create a new car");



    }
}
