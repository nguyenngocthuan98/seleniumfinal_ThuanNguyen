package tests;

import entities.Account;
import helpers.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TC01_LoginTest extends BaseTests {
    private final LoginPage loginPage = new LoginPage();
    private final Account account = new Account();

    @Test(testName = "User can log into Railway with valid username and password")
    public void tc01_LoginTest() {
        loginPage.goToLoginPage();
        account.setEmail(Constants.EMAIL);
        account.setPassword(Constants.PASSWORD);

        loginPage.login(account);

        Assert.assertEquals("Welcome " + account.getEmail(), loginPage.getGreeting(),
                "Greeting doesn't display as expected.");
        Assert.assertEquals("Welcome to Safe Railway", loginPage.getWelcomeMsg(),
                "Welcome message doesn't display as expected.");
    }
}
