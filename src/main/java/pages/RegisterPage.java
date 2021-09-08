package pages;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.TextBox;
import entities.Account;

public class RegisterPage extends BasePage {
    //Locates
    private final TextBox emailField = new TextBox("id=email");
    private final TextBox passwordField = new TextBox("id=password");
    private final TextBox confirmPasswordField = new TextBox("id=confirmPassword");
    private final TextBox pidField = new TextBox("id=pid");
    private final Button registerButton = new Button("css=input[type='submit']");
    private final Label registerSuccessMsg = new Label("css=div#content p");

    //Methods
    public String getRegisterSuccessMessage() {
        registerSuccessMsg.waitForVisibility();
        return registerSuccessMsg.getText();
    }

    public void register(Account account) {
        emailField.scrollToView();
        emailField.enter(account.getEmail());
        passwordField.enter(account.getPassword());
        confirmPasswordField.clear();
        confirmPasswordField.enter(account.getConfirmPassword());
        pidField.enter(account.getPid());
        registerButton.click();
    }
}
