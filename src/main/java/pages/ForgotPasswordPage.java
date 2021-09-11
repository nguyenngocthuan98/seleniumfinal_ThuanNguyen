package pages;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.TextBox;

public class ForgotPasswordPage extends BasePage {
    //Locators
    private final TextBox txtEmail = new TextBox("id=email");
    private final Button btnSendInstruction = new Button("css=input[type='submit']");
    private final Label lblFormTitle = new Label("css=fieldset legend");

    //Methods
    public String getFormTitle() {
        return lblFormTitle.getText();
    }

    public void sendInstruction(String email) {
        txtEmail.scrollToView();
        txtEmail.clear();
        txtEmail.enter(email);
        btnSendInstruction.click();
    }
}
