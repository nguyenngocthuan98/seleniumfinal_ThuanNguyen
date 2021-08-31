package tests;

import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TC04_BookTicketWithUnloggedUserTest extends BaseTests {
    private final LoginPage loginPage = new LoginPage();

    @Test(testName = "Login page displays when un-logged User clicks on Book ticket tab")
    public void tc04_BookTicketWithUnloggedUserTest() {
        LogHelper.logInfo("Go to Book Ticket page");
        loginPage.goToBookTicketPage();

        LogHelper.logInfo("Check login page name");
        Assert.assertEquals(loginPage.getPageNameLabel(), "Login Page",
                "Login page name doesn't display as expected.");
    }
}
