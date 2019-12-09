package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CreateCalendarEventPage extends BasePage{

    @FindBy(css = "[class='select2-chosen']")
    public WebElement owner;


}