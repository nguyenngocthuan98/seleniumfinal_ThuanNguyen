package pages;

import entities.Account;
import helpers.Constants;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    //Locators
    private final By emailField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("p.form-actions input[type='submit']");
    private final By loginFormErrorMsg = By.cssSelector("p[class='message error LoginForm']");
    private final By emailErrorMsg = By.cssSelector("li.username label.validation-error");

    //Elements
    private WebElement emailFieldElement() {
        return Constants.WEBDRIVER.findElement(emailField);
    }

    private WebElement passwordFieldElement() {
        return Constants.WEBDRIVER.findElement(passwordField);
    }

    private WebElement loginButtonElement() {
        return Constants.WEBDRIVER.findElement(loginButton);
    }

    private WebElement loginFormErrorMsgElement() {
        return Constants.WEBDRIVER.findElement(loginFormErrorMsg);
    }

    private WebElement emailErrorMsgElement() {
        return Constants.WEBDRIVER.findElement(emailErrorMsg);
    }

    //Methods
    public String getLoginFormErrorMessage() {
        return loginFormErrorMsgElement().getText();
    }

    public String getEmailErrorMessage() {
        return emailErrorMsgElement().getText();
    }

    public void login(Account account) {
        ElementHelper.scrollTo(emailFieldElement());
        emailFieldElement().clear();
        emailFieldElement().sendKeys(account.getEmail());
        passwordFieldElement().clear();
        passwordFieldElement().sendKeys(account.getPassword());
        loginButtonElement().click();
    }
}
