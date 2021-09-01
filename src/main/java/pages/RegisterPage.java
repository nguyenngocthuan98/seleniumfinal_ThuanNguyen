package pages;

import entities.Account;
import helpers.Constants;
import helpers.ElementHelper;
import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    //Locates
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By confirmPasswordField = By.id("confirmPassword");
    private final By pidField = By.id("pid");
    private final By registerButton = By.cssSelector("input[type='submit']");
    private final By registerSuccessMsg = By.cssSelector("div#content p");
    private final By registerFormErrorMsg = By.cssSelector("p[class='message error']");
    private final By passwordErrorMsg = By.cssSelector("li.password label.validation-error");
    private final By pidErrorMsg = By.cssSelector("li.pid-number label.validation-error");

    //Element
    private WebElement emailFieldElement() {
        return Constants.WEBDRIVER.findElement(emailField);
    }

    private WebElement passwordFieldElement() {
        return Constants.WEBDRIVER.findElement(passwordField);
    }

    private WebElement confirmPasswordFieldElement() {
        return Constants.WEBDRIVER.findElement(confirmPasswordField);
    }

    private WebElement pidFieldElement() {
        return Constants.WEBDRIVER.findElement(pidField);
    }

    private WebElement registerButtonElement() {
        return Constants.WEBDRIVER.findElement(registerButton);
    }

    private WebElement registerSuccessMsgElement() {
        return Constants.WEBDRIVER.findElement(registerSuccessMsg);
    }

    private WebElement registerFormErrorMsgElement() {
        return Constants.WEBDRIVER.findElement(registerFormErrorMsg);
    }

    private WebElement passwordErrorMsgElement() {
        return Constants.WEBDRIVER.findElement(passwordErrorMsg);
    }

    private WebElement pidErrorMsgElement() {
        return Constants.WEBDRIVER.findElement(pidErrorMsg);
    }

    //Methods
    public String getRegisterSuccessMessage() {
        Wait.untilElementVisible(registerSuccessMsg, Constants.TIME_WAIT);
        return registerSuccessMsgElement().getText();
    }

    public String getRegisterFormErrorMessage() {
        Wait.untilElementVisible(registerFormErrorMsg, Constants.TIME_WAIT);
        return registerFormErrorMsgElement().getText();
    }

    public String getPasswordErrorMessage() {
        Wait.untilElementVisible(passwordErrorMsg, Constants.TIME_WAIT);
        return passwordErrorMsgElement().getText();
    }

    public String getPidErrorMessage() {
        Wait.untilElementVisible(pidErrorMsg, Constants.TIME_WAIT);
        return pidErrorMsgElement().getText();
    }

    public void register(Account account) {
        ElementHelper.scrollTo(emailFieldElement());
        emailFieldElement().clear();
        emailFieldElement().sendKeys(account.getEmail());
        passwordFieldElement().clear();
        passwordFieldElement().sendKeys(account.getPassword());
        confirmPasswordFieldElement().clear();
        confirmPasswordFieldElement().sendKeys(account.getConfirmPassword());
        pidFieldElement().clear();
        pidFieldElement().sendKeys(account.getPid());
        registerButtonElement().click();
    }
}
