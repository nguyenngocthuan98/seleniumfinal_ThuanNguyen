package pages;

import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.Link;

public class BasePage {
    //Locators
    private final Label lblGreetingMsg = new Label("css=div.account > strong");
    private final Label lblWelcomeMsg = new Label("css=div#content h1[align='center']");
    private final Label lblPageName = new Label("css=div#content h1[align='center']");
    private final Link lnkLoginTab = new Link("css=li a[href='/Account/Login.cshtml']");
    private final Link lnkBookTicketTab = new Link("css=li a[href='/Page/BookTicketPage.cshtml']");
    private final Link lnkChangePasswordTab = new Link("css=li a[href='/Account/ChangePassword.cshtml']");
    private final Link lnkMyTicketTab = new Link("css=li a[href='/Page/ManageTicket.cshtml']");
    private final Link lnkLogoutTab = new Link("css=li a[href='/Account/Logout']");
    private final Link lnkRegisterTab = new Link("css=li a[href='/Account/Register.cshtml']");
    private final Link lnkTimeTableTab = new Link("css=li a[href='TrainTimeListPage.cshtml']");

    //Methods
    public String getGreetingMsg() {
        lblGreetingMsg.waitForDisplay();
        return lblGreetingMsg.getText();
    }

    public String getWelcomeMsg() {
        lblWelcomeMsg.waitForDisplay();
        return lblWelcomeMsg.getText();
    }

    public void goToLoginPage() {
        lnkLoginTab.click();
    }

    public void goToBookTicketPage() {
        lnkBookTicketTab.click();
    }

    public String getPageName() {
        lblPageName.waitForDisplay();
        return lblPageName.getText();
    }

    public void goToChangePasswordPage() {
        lnkChangePasswordTab.click();
    }

    public void goToMyTicketPage() {
        lnkMyTicketTab.click();
    }

    public void goToTimeTablePage() {
        lnkTimeTableTab.click();
    }

    public boolean doesMyTicketTabDisplay() {
        return lnkMyTicketTab.isVisible();
    }

    public boolean doesChangePasswordTabDisplay() {
        return lnkChangePasswordTab.isVisible();
    }

    public boolean doesLogoutTabDisplay() {
        return lnkLogoutTab.isVisible();
    }

    public void goToRegisterPage() {
        lnkRegisterTab.click();
    }
}
