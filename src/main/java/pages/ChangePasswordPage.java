package pages;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.TextBox;
import entities.Account;

public class ChangePasswordPage extends BasePage {
    //Locates
    private final TextBox txtCurrentPassword = new TextBox("id=currentPassword");
    private final TextBox txtNewPassword = new TextBox("id=newPassword");
    private final TextBox txtConfirmPassword = new TextBox("id=confirmPassword");
    private final Button btnChangePassword = new Button("css=input[type='submit']");
    private final Label lblChangePasswordSuccessMsg = new Label("css=p.message");

    //Methods
    public String getChangePasswordSuccessMsg() {
        lblChangePasswordSuccessMsg.waitForDisplay();
        return lblChangePasswordSuccessMsg.getText();
    }

    public void changePassword(Account account, String newPassword) {
        txtCurrentPassword.scrollToView();
        txtCurrentPassword.enter(account.getPassword());
        txtNewPassword.enter(newPassword);
        txtConfirmPassword.enter(newPassword);
        btnChangePassword.click();
    }
}
