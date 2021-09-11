package tests;

import entities.Account;
import helpers.Constants;
import helpers.DataHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTests extends BaseTests {
    private final RegisterPage registerPage = new RegisterPage();
    private Account account;

    @Test(testName = "User can create new account")
    public void tc07_RegisterTest() {
        LogHelper.logInfo("Set Email, Password, Confirm Password and PID valid values for Account object");
        account = new Account(DataHelper.getRandomEmail(), Constants.PASSWORD, Constants.PASSWORD,
                DataHelper.getRandomNumber());

        LogHelper.logInfo("Go to register page");
        registerPage.goToRegisterPage();

        LogHelper.logInfo("Register new account");
        registerPage.register(account);

        LogHelper.logInfo("Check register success message");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "You're here",
                "Register success message doesn't display as expected");
    }

    @Test(testName = "User can't create account with Confirm password is not the same with Password")
    public void tc10_ConfirmPasswordNotTheSamePasswordTest() {
        LogHelper.logInfo("Set valid Email, Password, and PID values; Confirm password is not the same with Password");
        String notSameWithPassword = "notSameWithPassword";
        account = new Account(DataHelper.getRandomEmail(), Constants.PASSWORD, notSameWithPassword,
                DataHelper.getRandomNumber());

        LogHelper.logInfo("Go to register page");
        registerPage.goToRegisterPage();

        LogHelper.logInfo("Register new account");
        registerPage.register(account);

        LogHelper.logInfo("Check register form error message");
        Assert.assertEquals(registerPage.getRegisterFormErrorMessage(),
                "There're errors in the form. Please correct the errors and try again.",
                "Register success message doesn't display as expected");
    }

    @Test(testName = "User can't create account while password and PID fields are empty")
    public void tc11_PasswordAndPIDFieldsEmptyTest() {
        LogHelper.logInfo("Set valid Email value and invalid Password, Confirm Password PID values for Account object");
        account = new Account(DataHelper.getRandomEmail(), "", "", "");

        LogHelper.logInfo("Go to register page");
        registerPage.goToRegisterPage();

        LogHelper.logInfo("Register new account with invalid Account");
        registerPage.register(account);

        LogHelper.logInfo("Check register form error message");
        Assert.assertEquals(registerPage.getRegisterFormErrorMessage(),
                "There're errors in the form. Please correct the errors and try again.",
                "Register success message doesn't display as expected");
        LogHelper.logInfo("Check password length error message next to password field");
        Assert.assertEquals(registerPage.getPasswordErrorMessage(),
                "Invalid password length",
                "Register success message doesn't display as expected");
        LogHelper.logInfo("Check pid length error message next to pid field");
        Assert.assertEquals(registerPage.getPidErrorMessage(),
                "Invalid ID length",
                "Register success message doesn't display as expected");

    }
}
