package tests;

import entities.Account;
import helpers.Constants;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TC03_LoginInvalidPasswordTest extends BaseTests{
    private final LoginPage loginPage = new LoginPage();
    private final Account account = new Account();

    @Test(testName = "User can not log into Railway with invalid password")
    public void tc03_LoginInvalidPasswordTest() {
        LogHelper.logInfo("Go to Login page");
        loginPage.goToLoginPage();

        LogHelper.logInfo("Set Username value and invalid Password value for Account object");
        account.setEmail(Constants.EMAIL);
        account.setPassword("this_is_wrong_password");

        LogHelper.logInfo("Login with valid account");
        loginPage.login(account);

        LogHelper.logInfo("Check login form error message");
        Assert.assertEquals(loginPage.getLoginFormMessage(),
                "There was a problem with your login and/or errors exist in your form.",
                "Login form error message doesn't display as expected.");
    }
}
