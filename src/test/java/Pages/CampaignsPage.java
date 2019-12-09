package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.Driver;

import java.util.List;

public class CampaignsPage extends BasePage{
    @FindBy(xpath = "//button/input[@type='checkbox']")
    public WebElement checkBox;
    @FindBy(xpath = "//div//button[@class='btn dropdown-toggle ']")
    public WebElement viewPerPage;
    @FindBy(xpath = "//a[@title='Reset']")
    public WebElement resetButton;
    @FindBy(xpath = "//i[@class='fa-cog hide-text']")
    public WebElement gridButton;
    @FindBy(xpath = "//input[@placeholder='Quick Search']")
    public WebElement searchbutton;




    public  void clickTheCheckBox(){
        checkBox.click();
    }

    public void verifyIsSelected(){
        List<WebElement> checkboxes= Driver.get().findElements(By.xpath("//table//tbody//tr[1]//td//input[1]"));

        for(WebElement checkBox: checkboxes ){
            Assert.assertTrue(checkBox.isSelected(),"is not selected");
        }

    }

    public void selectViewPerPage(String value){
        viewPerPage.click();
        String locator="//a[@data-size='"+value+"']";
        WebElement valueViewPage=Driver.get().findElement(By.xpath(locator));
        valueViewPage.click();

    }
    public void gridSearchButton(String message){
        gridButton.click();
        searchbutton.sendKeys(message);

    }

}
