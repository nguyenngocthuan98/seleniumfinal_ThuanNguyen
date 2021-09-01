package tests;

import entities.Account;
import helpers.DataHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTests {
    private final LoginPage loginPage = new LoginPage();
    private final Account account = new Account();

    @BeforeMethod
    public void preConditions() {
        LogHelper.logInfo("Pre-condition");
        LogHelper.logInfo("Go to Login page");
        loginPage.goToLoginPage();
    }

    @Test(testName = "User can log into Railway with valid username and password")
    public void tc01_LoginValidAccountTest() {
        LogHelper.logInfo("Set Email and Password values for Account object");
        DataHelper.setValidLoginAccount(account);

        LogHelper.logInfo("Login with valid account");
        loginPage.login(account);

        LogHelper.logInfo("Check greeting message");
        Assert.assertEquals("Welcome " + account.getEmail(), loginPage.getGreetingMsg(),
                "Greeting doesn't display as expected.");
        LogHelper.logInfo("Check welcome message");
        Assert.assertEquals("Welcome to Safe Railway", loginPage.getWelcomeMsg(),
                "Welcome message doesn't display as expected.");
    }

    @Test(testName = "User can't login with blank Username text box")
    public void tc02_LoginBlankUsernameTest() {
        LogHelper.logInfo("Set Username is blank and valid Password value for Account object");
        DataHelper.setBlankEmailLoginAccount(account);

        LogHelper.logInfo("Login with invalid account");
        loginPage.login(account);

        LogHelper.logInfo("Check username error message");
        Assert.assertEquals(loginPage.getEmailErrorMessage(), "You must specify a username.",
                "Username error message doesn't display as expected.");
        LogHelper.logInfo("Check login form error message");
        Assert.assertEquals(loginPage.getLoginFormErrorMessage(),
                "There was a problem with your login and/or errors exist in your form.",
                "Login form error message doesn't display as expected.");
    }

    @Test(testName = "User can not log into Railway with invalid password")
    public void tc03_LoginInvalidPasswordTest() {
        LogHelper.logInfo("Set Username value and invalid Password value for Account object");
        DataHelper.setInvalidPasswordLoginAccount(account);

        LogHelper.logInfo("Login with invalid account");
        loginPage.login(account);

        LogHelper.logInfo("Check login form error message");
        Assert.assertEquals(loginPage.getLoginFormErrorMessage(),
                "There was a problem with your login and/or errors exist in your form.",
                "Login form error message doesn't display as expected.");
    }

    @Test(testName = "System shows message when user enters wrong password several times.")
    public void tc05_WrongPasswordSeveralTimesTest() {
        int numberOfTimesForWarningMsg = 4;

        LogHelper.logInfo("Go to Login page");
        loginPage.goToLoginPage();

        LogHelper.logInfo("Set Username value and wrong Password value for Account object");
        DataHelper.setInvalidPasswordLoginAccount(account);

        LogHelper.logInfo("Login with wrong password several times util warning message appear");
        loginPage.loginSeveralTimes(account, numberOfTimesForWarningMsg);

        LogHelper.logInfo("Check login warning message");
        Assert.assertEquals(loginPage.getLoginFormErrorMessage(),
                "You have used 4 out of 5 login attempts. " +
                        "After all 5 have been used, you will be unable to login for 15 minutes.",
                "Login form error message doesn't display as expected.");
    }

    @Test(testName = "Additional pages display once user logged in")
    public void tc06_AdditionalPagesUponLoginTest() {
        LogHelper.logInfo("Set Email and Password values for Account object");
        DataHelper.setValidLoginAccount(account);

        LogHelper.logInfo("Login with valid account");
        loginPage.login(account);

        LogHelper.logInfo("Check My ticket tab display");
        Assert.assertTrue(loginPage.doesMyTicketTabExist(), "My ticket tab name doesn't display.");
        LogHelper.logInfo("Check Change password tab display");
        Assert.assertTrue(loginPage.doesChangePasswordTabExist(), "Change password tab name doesn't display.");
        LogHelper.logInfo("Check Log out tab display");
        Assert.assertTrue(loginPage.doesLogoutTabExist(), "Log out tab name doesn't display.");

        LogHelper.logInfo("Go to My ticket page");
        loginPage.goToMyTicketPage();
        LogHelper.logInfo("Check My ticket page name");
        Assert.assertEquals(loginPage.getPageNameLabel(), "Manage Tickets",
                "My Ticket page name doesn't display as expected.");

        LogHelper.logInfo("Go to Change password page");
        loginPage.goToChangePasswordPage();
        LogHelper.logInfo("Check Change password page name");
        Assert.assertEquals(loginPage.getPageNameLabel(), "Change password",
                "Change password page name doesn't display as expected.");
    }
}
