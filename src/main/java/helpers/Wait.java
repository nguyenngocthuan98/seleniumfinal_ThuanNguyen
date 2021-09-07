package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
    public static void untilElementVisible(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(Constants.WEBDRIVER, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void untilElementStillAttached(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(Constants.WEBDRIVER, seconds);
        wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(element)));
    }

    public static void untilAlertPopupDisplays(int seconds) {
        WebDriverWait wait = new WebDriverWait(Constants.WEBDRIVER, seconds);
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
