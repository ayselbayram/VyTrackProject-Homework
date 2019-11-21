package Tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class DragAndDropPractice {
    @Test
    public void test1(){
        WebDriver driver=BrowserFactory.getDriver("chrome");
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("button[aria-label='Accept Cookies']")).click();
        BrowserUtils.wait(1);

        Actions actions=new Actions(driver);

        WebElement moon=driver.findElement(By.id("draggable"));
        WebElement earth=driver.findElement(By.id("droptarget"));
        BrowserUtils.wait(3);

        //@param source element to emulate button down at.
        //@param target element to move to and release the mouse at.
        actions.dragAndDrop(moon,earth).perform();

        BrowserUtils.wait(3);//just for demo

        driver.quit();
    }

}
