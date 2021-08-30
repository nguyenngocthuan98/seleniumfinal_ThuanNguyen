package tests;

import entities.Account;
import helpers.Constants;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TC02_LoginBlankUsername extends BaseTests {
    private final LoginPage loginPage = new LoginPage();
    private final Account account = new Account();

    @Test(testName = "User can't login with blank \"Username\" text box")
    public void tc02_LoginBlankUsernameTest() {
        LogHelper.logInfo("Go to Login page");
        loginPage.goToLoginPage();

        LogHelper.logInfo("Set Username is blank and valid Password value for Account object");
        account.setEmail("");
        account.setPassword(Constants.PASSWORD);

        LogHelper.logInfo("Login with valid account");
        loginPage.login(account);

        LogHelper.logInfo("Check username error message");
        Assert.assertEquals(loginPage.getEmailErrorMessage(), "You must specify a username.",
                "Username error message doesn't display as expected.");
        LogHelper.logInfo("Check login form error message");
        Assert.assertEquals(loginPage.getTopErrorMessage(),
                "There was a problem with your login and/or errors exist in your form.", 
                "Login form error message doesn't display as expected.");
    }
}
