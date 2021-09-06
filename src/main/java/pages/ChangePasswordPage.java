package pages;

import entities.Account;
import helpers.Constants;
import helpers.ElementHelper;
import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage {
    //Locates
    private final By currentPasswordField = By.id("currentPassword");
    private final By newPasswordField = By.id("newPassword");
    private final By confirmPasswordField = By.id("confirmPassword");
    private final By changePasswordButton = By.cssSelector("input[type='submit']");
    private final By changePasswordSuccessMsg = By.cssSelector("p.message");

    //Element
    private WebElement currentPasswordFieldElement() {
        return Constants.WEBDRIVER.findElement(currentPasswordField);
    }

    private WebElement newPasswordFieldElement() {
        return Constants.WEBDRIVER.findElement(newPasswordField);
    }

    private WebElement confirmPasswordFieldElement() {
        return Constants.WEBDRIVER.findElement(confirmPasswordField);
    }

    private WebElement changePasswordButtonElement() {
        return Constants.WEBDRIVER.findElement(changePasswordButton);
    }

    private WebElement changePasswordSuccessMsgElement() {
        return Constants.WEBDRIVER.findElement(changePasswordSuccessMsg);
    }

    //Methods
    public String getChangePasswordSuccessMessage() {
        Wait.untilElementVisible(changePasswordSuccessMsg, Constants.TIME_WAIT);
        return changePasswordSuccessMsgElement().getText();
    }

    public void changePassword(Account account, String newPassword) {
        ElementHelper.scrollTo(currentPasswordFieldElement());
        currentPasswordFieldElement().clear();
        currentPasswordFieldElement().sendKeys(account.getPassword());
        newPasswordFieldElement().clear();
        newPasswordFieldElement().sendKeys(newPassword);
        confirmPasswordFieldElement().clear();
        confirmPasswordFieldElement().sendKeys(newPassword);
        changePasswordButtonElement().click();
    }
}
