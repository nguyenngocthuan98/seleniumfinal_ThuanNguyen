package tests;

import entities.Account;
import helpers.Constants;
import helpers.DataHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.LoginPage;
import pages.RegisterPage;

public class ChangePasswordTests extends BaseTests {
    private final RegisterPage registerPage = new RegisterPage();
    private final LoginPage loginPage = new LoginPage();
    private final ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    private Account account;

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

    @Test(testName = "User can change password")
    public void tc09_ChangePasswordTest() {
        LogHelper.logInfo("Go to login page");
        registerPage.goToLoginPage();

        LogHelper.logInfo("Login with valid account");
        loginPage.login(account);

        LogHelper.logInfo("Go to change password page");
        loginPage.goToChangePasswordPage();

        LogHelper.logInfo("Change password");
        changePasswordPage.changePassword(account, "newValidPassword");

        LogHelper.logInfo("Check change password success message");
        Assert.assertEquals(changePasswordPage.getChangePasswordSuccessMsg(),
                "Your password has been updated!",
                "Change password success message doesn't display as expected");
    }
}
