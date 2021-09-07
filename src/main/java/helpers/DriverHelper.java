package helpers;

public class DriverHelper {
    public static void acceptAlert() {
        Constants.WEBDRIVER.switchTo().alert().accept();
    }
}
