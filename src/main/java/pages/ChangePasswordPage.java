package pages;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.TextBox;
import entities.Account;

public class ChangePasswordPage extends BasePage {
    //Locates
    private final TextBox currentPasswordField = new TextBox("id=currentPassword");
    private final TextBox newPasswordField = new TextBox("id=newPassword");
    private final TextBox confirmPasswordField = new TextBox("id=confirmPassword");
    private final Button changePasswordButton = new Button("css=input[type='submit']");
    private final Label changePasswordSuccessMsg = new Label("css=p.message");

    //Methods
    public String getChangePasswordSuccessMessage() {
        changePasswordSuccessMsg.waitForDisplay();
        return changePasswordSuccessMsg.getText();
    }

    public void changePassword(Account account, String newPassword) {
        currentPasswordField.scrollToView();
        currentPasswordField.enter(account.getPassword());
        newPasswordField.enter(newPassword);
        confirmPasswordField.enter(newPassword);
        changePasswordButton.click();
    }
}
