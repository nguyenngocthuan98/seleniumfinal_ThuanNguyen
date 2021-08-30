package tests;

import entities.Account;
import helpers.Constants;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TC01_LoginTest extends BaseTests {
    private final LoginPage loginPage = new LoginPage();
    private final Account account = new Account();

    @Test(testName = "User can log into Railway with valid username and password")
    public void tc01_LoginTest() {
        LogHelper.logInfo("Go to Login page");
        loginPage.goToLoginPage();

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
}
