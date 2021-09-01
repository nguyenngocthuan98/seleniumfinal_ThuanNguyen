package tests;

import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookTicketPage;
import pages.LoginPage;

public class BookTicketTests extends BaseTests {
    private final LoginPage loginPage = new LoginPage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(testName = "Login page displays when un-logged User clicks on Book ticket tab")
    public void tc04_BookTicketWithUnloggedUserTest() {
        LogHelper.logInfo("Go to Book Ticket page");
        bookTicketPage.goToBookTicketPage();

        LogHelper.logInfo("Check login page name");
        Assert.assertEquals(loginPage.getPageNameLabel(), "Login Page",
                "Login page name doesn't display as expected.");
    }
}
