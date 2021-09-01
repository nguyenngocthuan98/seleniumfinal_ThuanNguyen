package pages;

import helpers.Constants;
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
}
