package pages;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.TextBox;
import entities.Account;

public class LoginPage extends BasePage {
    //Locators
    private final TextBox emailField = new TextBox("id=username");
    private final TextBox passwordField = new TextBox("id=password");
    private final Button loginButton = new Button("css=p.form-actions input[type='submit']");
    private final Label loginFormErrorMsg = new Label("css=p[class='message error LoginForm']");
    private final Label emailErrorMsg = new Label("css=li.username label.validation-error");

    //Methods
    public String getLoginFormErrorMessage() {
        return loginFormErrorMsg.getText();
    }

    public String getEmailErrorMessage() {
        return emailErrorMsg.getText();
    }

    public void login(Account account) {
        emailField.scrollToView();
        emailField.clear();
        emailField.enter(account.getEmail());
        passwordField.clear();
        passwordField.enter(account.getPassword());
        loginButton.click();
    }

    public void loginSeveralTimes(Account account, int timesNumber) {
        emailField.scrollToView();
        emailField.clear();
        emailField.enter(account.getEmail());
        for (int i = 1; i <= timesNumber; i++) {
            passwordField.waitForDisplay();
            passwordField.scrollToView();
            passwordField.clear();
            passwordField.enter(account.getPassword());
            loginButton.click();
        }
    }
}
