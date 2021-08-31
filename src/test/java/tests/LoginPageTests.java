package tests;

import entities.Account;
import helpers.Constants;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTests extends BaseTests {
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
        account.setEmail(Constants.EMAIL);
        account.setPassword(Constants.PASSWORD);

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
        account.setEmail("");
        account.setPassword(Constants.PASSWORD);

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
        account.setEmail(Constants.EMAIL);
        account.setPassword("this_is_wrong_password");

        LogHelper.logInfo("Login with invalid account");
        loginPage.login(account);

        LogHelper.logInfo("Check login form error message");
        Assert.assertEquals(loginPage.getLoginFormErrorMessage(),
                "There was a problem with your login and/or errors exist in your form.",
                "Login form error message doesn't display as expected.");
    }
}
