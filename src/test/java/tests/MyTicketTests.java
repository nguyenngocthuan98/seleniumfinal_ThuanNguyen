package tests;

import entities.Account;
import entities.Ticket;
import helpers.Constants;
import helpers.DataHelper;
import helpers.DateTimeHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BookTicketPage;
import pages.LoginPage;
import pages.MyTicketPage;
import pages.RegisterPage;

public class MyTicketTests extends BaseTests {
    private final LoginPage loginPage = new LoginPage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();
    private final RegisterPage registerPage = new RegisterPage();
    private final MyTicketPage myTicketPage = new MyTicketPage();
    private Account account;
    private Ticket ticket;

    @BeforeMethod
    public void preConditions() {
        LogHelper.logInfo("Pre-conditions");
        LogHelper.logInfo("Set valid values for Account object");
        account = new Account(DataHelper.getRandomEmail(), Constants.PASSWORD, Constants.PASSWORD,
                DataHelper.getRandomNumber());

        LogHelper.logInfo("Go to register page and register new account");
        registerPage.goToRegisterPage();
        registerPage.register(account);
    }

    @Test(testName = "User can cancel a ticket")
    public void tc16_CancelTicketTest() throws InterruptedException {
        String departDay = DateTimeHelper.getDateFromToday(16);
        String departFrom = "Sài Gòn";
        String arriveAt = "Nha Trang";
        String seatType = "Soft bed with air conditioner";
        String ticketAmount = "1";

        LogHelper.logInfo("Set valid values for Ticket object.");
        ticket = new Ticket(departDay, departFrom, arriveAt, seatType, ticketAmount);

        LogHelper.logInfo("Go to Book Ticket page.");
        registerPage.goToBookTicketPage();
        LogHelper.logInfo("Login page displays and login.");
        loginPage.login(account);

        LogHelper.logInfo("Book ticket.");
        bookTicketPage.bookTicket(ticket);

        LogHelper.logInfo("Go to My ticket page.");
        bookTicketPage.goToMyTicketPage();

        LogHelper.logInfo("Check ticket exist in My ticket.");
        Assert.assertTrue(myTicketPage.doesTicketExist(ticket), "Ticket not exist after book ticket");

        LogHelper.logInfo("Cancel ticket.");
        myTicketPage.cancelTicket(ticket);

        LogHelper.logInfo("Check ticket canceled successfully.");
        Assert.assertFalse(myTicketPage.doesTicketExist(ticket), "Ticket still exist after cancel ticket");
    }
}
