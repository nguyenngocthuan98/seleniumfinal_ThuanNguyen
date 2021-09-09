package pages;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.TextBox;
import entities.Account;

public class RegisterPage extends BasePage {
    //Locates
    private final TextBox txtEmail = new TextBox("id=email");
    private final TextBox txtPassword = new TextBox("id=password");
    private final TextBox txtConfirmPassword = new TextBox("id=confirmPassword");
    private final TextBox txtPid = new TextBox("id=pid");
    private final Button btnRegister = new Button("css=input[type='submit']");
    private final Label lblRegisterSuccessMsg = new Label("css=div#content p");

    //Methods
    public String getRegisterSuccessMessage() {
        lblRegisterSuccessMsg.waitForVisibility();
        return lblRegisterSuccessMsg.getText();
    }

    public void register(Account account) {
        txtEmail.scrollToView();
        txtEmail.enter(account.getEmail());
        txtPassword.enter(account.getPassword());
        txtConfirmPassword.clear();
        txtConfirmPassword.enter(account.getConfirmPassword());
        txtPid.enter(account.getPid());
        btnRegister.click();
    }
}
