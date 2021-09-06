package tests;

import entities.Account;
import entities.Ticket;
import helpers.Constants;
import helpers.DataHelper;
import helpers.ElementHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BookTicketPage;
import pages.LoginPage;
import pages.RegisterPage;

public class BookTicketTests extends BaseTests {
    private final LoginPage loginPage = new LoginPage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();
    private final RegisterPage registerPage = new RegisterPage();
    private Account account;
    private Ticket ticket;

    @BeforeMethod(onlyForGroups = {"tc14"})
    public void preConditions() {
        LogHelper.logInfo("Pre-conditions");
        LogHelper.logInfo("Set valid values for Account object");
        account = new Account(DataHelper.getRandomEmail(), Constants.PASSWORD, Constants.PASSWORD,
                DataHelper.getRandomNumber());

        LogHelper.logInfo("Go to register page and register new account");
        registerPage.goToRegisterPage();
        registerPage.register(account);
    }

    @Test(testName = "Login page displays when un-logged User clicks on Book ticket tab")
    public void tc04_BookTicketWithUnloggedUserTest() {
        LogHelper.logInfo("Go to Book Ticket page");
        bookTicketPage.goToBookTicketPage();

        LogHelper.logInfo("Check login page name");
        Assert.assertEquals(loginPage.getPageNameLabel(), "Login Page",
                "Login page name doesn't display as expected.");
    }

    @Test(testName = "User can book 1 ticket at a time", groups = "tc14")
    public void tc14_BookOneTicketTest() {
        String departDay = ElementHelper.departDay();
        String departFrom = "Sài Gòn";
        String arriveAt = "Nha Trang";
        String seatType = "Soft bed with air conditioner";
        String ticketAmount = "1";

        LogHelper.logInfo("Set valid values for Ticket object");
        ticket = new Ticket(departDay, departFrom, arriveAt, seatType, ticketAmount);

        LogHelper.logInfo("Go to Login page and login");
        registerPage.goToLoginPage();
        loginPage.login(account);
        LogHelper.logInfo("Go to Book Ticket page");
        loginPage.goToBookTicketPage();

        LogHelper.logInfo("Book ticket");
        bookTicketPage.bookTicket(ticket);

        LogHelper.logInfo("Check title of Book ticket page when book ticket successfully");
        Assert.assertEquals(bookTicketPage.getPageTitle(), "Ticket Booked Successfully!",
                "Title of page doesn't display as expected");
        LogHelper.logInfo("Check Depart Date is match");
        Assert.assertEquals(bookTicketPage.getValueOfDepartDate(), departDay, "Depart Date is not match");
        LogHelper.logInfo("Check Depart Station is match");
        Assert.assertEquals(bookTicketPage.getValueOfDepartFrom(), departFrom, "Depart Station is not match");
        LogHelper.logInfo("Check Arrive Station is match");
        Assert.assertEquals(bookTicketPage.getValueOfArriveAt(), arriveAt, "Arrive Station is not match");
        LogHelper.logInfo("Check Seat Type is match");
        Assert.assertEquals(bookTicketPage.getValueOfSeatType(), seatType, "Seat Type is not match");
        LogHelper.logInfo("Check Ticket Amount is match");
        Assert.assertEquals(bookTicketPage.getValueOfTicketAmount(), ticketAmount, "Ticket Amount is not match");
    }
}
