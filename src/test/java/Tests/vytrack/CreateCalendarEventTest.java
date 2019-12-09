package Tests.vytrack;

import Pages.CalendarEventsPage;
import Pages.CreateCalendarEventPage;
import Pages.LoginPage;
import Tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateCalendarEventTest extends TestBase {
    @Test(description = "verify owners name Stephan Hailey(it works on qa1, storemanager85")
    public void test1(){
        LoginPage loginpage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        CreateCalendarEventPage createCalendarEventPage=new CreateCalendarEventPage();

        //login as a stephan Haley
        loginpage.login("storemanager85","UserUser123");

        //go to calendarevents page
        loginpage.navigateTo("Activities","Calendar Events");

        //click on createcalendarevent button
        calendarEventsPage.clickToCreateCalendarEvent();

        String expectedOwner="Stephan Haley";
        String actualOwner=createCalendarEventPage.owner.getText();

        Assert.assertEquals(actualOwner,expectedOwner);
    }
}
