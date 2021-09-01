package pages;

import helpers.Constants;
import helpers.ElementHelper;
import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    //Locates
    private final By greetingMsg = By.cssSelector("div.account > strong");
    private final By welcomeMsg = By.cssSelector("div#content h1[align='center']");
    private final By loginTab = By.cssSelector("li a[href='/Account/Login.cshtml']");
    private final By bookTicketTab = By.cssSelector("li a[href='/Page/BookTicketPage.cshtml']");
    private final By pageNameLabel = By.cssSelector("div#content h1[align='center']");
    private final By changePasswordTab = By.cssSelector("li a[href='/Account/ChangePassword.cshtml']");
    private final By myTicketTab = By.cssSelector("li a[href='/Page/ManageTicket.cshtml']");
    private final By logoutTab = By.cssSelector("li a[href='/Account/Logout']");

    //Elements
    private WebElement greetingMsgElement() {
        return Constants.WEBDRIVER.findElement(greetingMsg);
    }

    private WebElement welcomeMsgElement() {
        return Constants.WEBDRIVER.findElement(welcomeMsg);
    }

    private WebElement loginTabElement() {
        return Constants.WEBDRIVER.findElement(loginTab);
    }

    private WebElement bookTicketTabElement() {
        return Constants.WEBDRIVER.findElement(bookTicketTab);
    }

    private WebElement pageNameLabelElement() {
        return Constants.WEBDRIVER.findElement(pageNameLabel);
    }

    private WebElement changePasswordTabElement() {
        return Constants.WEBDRIVER.findElement(changePasswordTab);
    }

    private WebElement myTicketTabElement() {
        return Constants.WEBDRIVER.findElement(myTicketTab);
    }

    private WebElement logoutTabElement() {
        return Constants.WEBDRIVER.findElement(logoutTab);
    }

    //Methods
    public String getGreetingMsg() {
        Wait.untilElementVisible(greetingMsg, Constants.TIME_WAIT);
        return greetingMsgElement().getText();
    }

    public String getWelcomeMsg() {
        Wait.untilElementVisible(welcomeMsg, Constants.TIME_WAIT);
        return welcomeMsgElement().getText();
    }

    public void goToLoginPage() {
        loginTabElement().click();
    }

    public void goToBookTicketPage() {
        bookTicketTabElement().click();
    }

    public String getPageNameLabel() {
        Wait.untilElementVisible(pageNameLabel, Constants.TIME_WAIT);
        return pageNameLabelElement().getText();
    }

    public void goToChangePasswordPage() {
        changePasswordTabElement().click();
    }

    public void goToMyTicketPage() {
        myTicketTabElement().click();
    }

    public boolean doesMyTicketTabDisplay() {
        return ElementHelper.doesElementDisplay(myTicketTabElement());
    }

    public boolean doesChangePasswordTabDisplay() {
        return ElementHelper.doesElementDisplay(changePasswordTabElement());
    }

    public boolean doesLogoutTabDisplay() {
        return ElementHelper.doesElementDisplay(logoutTabElement());
    }
}
