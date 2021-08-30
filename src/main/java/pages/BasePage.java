package pages;

import helpers.Constants;
import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    //Locates
    private final By greeting = By.cssSelector("div.account > strong");
    private final By welcomeMsg = By.cssSelector("div#content h1[align='center']");
    private final By tabLogin = By.cssSelector("li a[href='/Account/Login.cshtml']");

    //Elements
    private WebElement greetingElement() {
        return Constants.WEBDRIVER.findElement(greeting);
    }

    private WebElement welcomeMsgElement() {
        return Constants.WEBDRIVER.findElement(welcomeMsg);
    }

    private WebElement tabLoginElement() {
        return Constants.WEBDRIVER.findElement(tabLogin);
    }

    //Methods
    public String getGreeting() {
        Wait.untilElementVisible(greeting, Constants.TIME_WAIT);
        return greetingElement().getText();
    }

    public String getWelcomeMsg() {
        Wait.untilElementVisible(welcomeMsg, Constants.TIME_WAIT);
        return welcomeMsgElement().getText();
    }

    public void goToLoginPage() {
        tabLoginElement().click();
    }
}
