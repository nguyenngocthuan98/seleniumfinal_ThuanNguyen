package tests;

import entities.Account;
import helpers.Constants;
import helpers.DataHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BookTicketPage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.TimeTablePage;

public class TimeTableTests extends BaseTests {
    private final RegisterPage registerPage = new RegisterPage();
    private final LoginPage loginPage = new LoginPage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();
    private final TimeTablePage timeTablePage = new TimeTablePage();
    private static Account account;
    String validPassword = Constants.PASSWORD;

    @BeforeMethod
    public void preConditions() {
        LogHelper.logInfo("Pre-conditions");
        LogHelper.logInfo("Set valid values for Account object");
        account = new Account(DataHelper.getRandomEmail(), validPassword, validPassword, DataHelper.getRandomNumber());

        LogHelper.logInfo("Go to register page and register new account");
        registerPage.goToRegisterPage();
        registerPage.register(account);
    }

    @Test(testName = "User can open Book ticket page by clicking on Book ticket link in Train timetable page")
    public void tc15_BookOneTicketTest() {
        String departFrom = "Huế";
        String arriveAt = "Sài Gòn";

        LogHelper.logInfo("Go to Login page and login");
        registerPage.goToLoginPage();
        loginPage.login(account);

        LogHelper.logInfo("Go to Time Table page");
        timeTablePage.goToTimeTablePage();

        LogHelper.logInfo("Click Book ticket link with Depart Station and Arrive Station values");
        timeTablePage.clickBookTicket(departFrom, arriveAt);

        LogHelper.logInfo("Check Depart Station value selected matched");
        Assert.assertEquals(bookTicketPage.getDepartStationSelectedValue(), departFrom,
                "Depart Station selected not matched");
        LogHelper.logInfo("Check Arrive Station value selected matched");
        Assert.assertEquals(bookTicketPage.getArriveStationSelectedValue(), arriveAt,
                "Arrive Station selectedValue not matched");
    }
}
