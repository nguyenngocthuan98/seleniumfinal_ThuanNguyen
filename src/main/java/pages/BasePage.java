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
}
