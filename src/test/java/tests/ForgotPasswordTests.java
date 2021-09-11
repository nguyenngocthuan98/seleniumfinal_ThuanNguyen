package tests;

import entities.Account;
import helpers.Constants;
import helpers.DataHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.RegisterPage;

public class ForgotPasswordTests extends BaseTests {
    private final ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    private final RegisterPage registerPage = new RegisterPage();
    private final LoginPage loginPage = new LoginPage();
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

    @Test(testName = "Errors display when password reset token is blank")
    public void tc12_sendInstructionsPasswordResetTest() {
        LogHelper.logInfo("Go to login page");
        registerPage.goToLoginPage();
        LogHelper.logInfo("Go to Forgot Password page by click the link");
        loginPage.goToForgotPasswordPage();

        LogHelper.logInfo("Check title of Forgot Password page");
        Assert.assertEquals(forgotPasswordPage.getFormTitle(), "Password Reset Instructions Form",
                "Title of Password Reset Instructions Form doesn't display as expected");

        LogHelper.logInfo("Send instruction forgot password");
        forgotPasswordPage.sendInstruction(account.getEmail());

        LogHelper.logInfo("Check error");
        Assert.fail("Server Error. Mailbox unavailable.");
    }

    @Test(testName = "Errors display if password and confirm password don't match when resetting password")
    public void tc13_differentValuesPasswordFieldsTest() {
        LogHelper.logInfo("Go to login page");
        registerPage.goToLoginPage();
        LogHelper.logInfo("Go to Forgot Password page by click the link");
        loginPage.goToForgotPasswordPage();

        LogHelper.logInfo("Check title of Forgot Password page");
        Assert.assertEquals(forgotPasswordPage.getFormTitle(), "Password Reset Instructions Form",
                "Title of Password Reset Instructions Form doesn't display as expected");

        LogHelper.logInfo("Send instruction forgot password");
        forgotPasswordPage.sendInstruction(account.getEmail());

        LogHelper.logInfo("Check error");
        Assert.fail("Server Error. Mailbox unavailable.");
    }
}
