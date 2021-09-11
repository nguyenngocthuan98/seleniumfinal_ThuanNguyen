package pages;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.Link;
import com.logigear.control.common.imp.TextBox;
import entities.Account;

public class LoginPage extends BasePage {
    //Locators
    private final TextBox txtEmail = new TextBox("id=username");
    private final TextBox txtPassword = new TextBox("id=password");
    private final Button btnLogin = new Button("css=p.form-actions input[type='submit']");
    private final Label lblLoginFormErrorMsg = new Label("css=p[class='message error LoginForm']");
    private final Label lblEmailErrorMsg = new Label("css=li.username label.validation-error");
    private final Link lnkForgotPasswordPage = new Link("css=li a[href='/Account/ForgotPassword.cshtml']");

    //Methods
    public String getLoginFormErrorMessage() {
        return lblLoginFormErrorMsg.getText();
    }

    public String getEmailErrorMessage() {
        return lblEmailErrorMsg.getText();
    }

    public void goToForgotPasswordPage() {
        lnkForgotPasswordPage.click();
    }

    public void login(Account account) {
        txtEmail.scrollToView();
        txtEmail.clear();
        txtEmail.enter(account.getEmail());
        txtPassword.clear();
        txtPassword.enter(account.getPassword());
        btnLogin.click();
    }

    public void loginSeveralTimes(Account account, int timesNumber) {
        txtEmail.scrollToView();
        txtEmail.clear();
        txtEmail.enter(account.getEmail());
        for (int i = 1; i <= timesNumber; i++) {
            txtPassword.waitForDisplay();
            txtPassword.scrollToView();
            txtPassword.clear();
            txtPassword.enter(account.getPassword());
            btnLogin.click();
        }
    }
}
