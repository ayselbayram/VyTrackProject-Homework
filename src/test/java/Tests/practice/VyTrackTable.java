package Tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BrowserUtils;
import utils.Driver;

public class VyTrackTable {
    public static void main(String[] args) {
        Driver.get().get("http://qa2.vytrack.com/user/login");
        Driver.get().findElement(By.id("prependedInput")).sendKeys("storemanager85");
        Driver.get().findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        WebElement FleetModule=Driver.get().findElement(By.xpath("//*[normalize-space()='Fleet' and @class='title title-level-1']"));
        Actions action=new Actions(Driver.get());
        action.moveToElement(FleetModule).perform();
        WebElement submodule=Driver.get().findElement(By.linkText("Vehicles"));

//        action.moveToElement(submodule).click();
//        Driver.get().wait().until(ExpectedConditions.invisibilityOf(submodule));
        submodule.click();
        BrowserUtils.wait(2);

        Driver.get().quit();



    }
}
