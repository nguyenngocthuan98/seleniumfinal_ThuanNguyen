package tests;

import entities.Account;
import helpers.DataHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTests extends BaseTests {
    private final RegisterPage registerPage = new RegisterPage();
    private final String email = DataHelper.getRandomEmail();
    private final String password = DataHelper.getRandomPassword();
    private final String pid = DataHelper.getRandomNumber();

    @Test(testName = "User can create new account")
    public void tc07_RegisterTest() {
        LogHelper.logInfo("Set Email, Password, Confirm Password and PID valid values for Account object");
        Account account = new Account(email, password, password, pid);

        LogHelper.logInfo("Go to register page");
        registerPage.goToRegisterPage();

        LogHelper.logInfo("Register new account");
        registerPage.register(account);

        LogHelper.logInfo("Check register success message");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Thank you for registering your account",
                "Register success message doesn't display as expected");
    }
}
