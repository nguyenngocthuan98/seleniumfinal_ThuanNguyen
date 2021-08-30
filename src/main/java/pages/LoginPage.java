package pages;

import entities.Account;
import helpers.Constants;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    //Locators
    private final By emailField = By.cssSelector("li.username input#username");
    private final By passwordField = By.cssSelector("li.password input#password");
    private final By btnSubmit = By.cssSelector("input[type='submit']");

    //Elements
    private WebElement emailFieldElement() {
        return Constants.WEBDRIVER.findElement(emailField);
    }

    private WebElement passwordFieldElement() {
        return Constants.WEBDRIVER.findElement(passwordField);
    }

    private WebElement btnLoginElement() {
        return Constants.WEBDRIVER.findElement(btnSubmit);
    }

    //Methods
    public void login(Account account) {
        ElementHelper.scrollTo(emailFieldElement());
        emailFieldElement().clear();
        emailFieldElement().sendKeys(account.getEmail());
        passwordFieldElement().clear();
        passwordFieldElement().sendKeys(account.getPassword());
        btnLoginElement().click();
    }
}
