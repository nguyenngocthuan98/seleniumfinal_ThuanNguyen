package pages;

import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.Link;

public class BasePage {
    //Locators
    private final Label greetingMsg = new Label("css=div.account > strong");
    private final Label welcomeMsg = new Label("css=div#content h1[align='center']");
    private final Label pageNameLabel = new Label("css=div#content h1[align='center']");
    private final Link loginTab = new Link("css=li a[href='/Account/Login.cshtml']");
    private final Link bookTicketTab = new Link("css=li a[href='/Page/BookTicketPage.cshtml']");
    private final Link changePasswordTab = new Link("css=li a[href='/Account/ChangePassword.cshtml']");
    private final Link myTicketTab = new Link("css=li a[href='/Page/ManageTicket.cshtml']");
    private final Link logoutTab = new Link("css=li a[href='/Account/Logout']");
    private final Link registerTab = new Link("css=li a[href='/Account/Register.cshtml']");

    //Methods
    public String getGreetingMsg() {
        greetingMsg.waitForDisplay();
        return greetingMsg.getText();
    }

    public String getWelcomeMsg() {
        welcomeMsg.waitForDisplay();
        return welcomeMsg.getText();
    }

    public void goToLoginPage() {
        loginTab.click();
    }

    public void goToBookTicketPage() {
        bookTicketTab.click();
    }

    public String getPageNameLabel() {
        pageNameLabel.waitForDisplay();
        return pageNameLabel.getText();
    }

    public void goToChangePasswordPage() {
        changePasswordTab.click();
    }

    public void goToMyTicketPage() {
        myTicketTab.click();
    }

    public boolean doesMyTicketTabDisplay() {
        return myTicketTab.isVisible();
    }

    public boolean doesChangePasswordTabDisplay() {
        return changePasswordTab.isVisible();
    }

    public boolean doesLogoutTabDisplay() {
        return logoutTab.isVisible();
    }

    public void goToRegisterPage() {
        registerTab.click();
    }
}
