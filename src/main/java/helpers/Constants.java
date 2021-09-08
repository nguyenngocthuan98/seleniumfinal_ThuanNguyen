package helpers;

import org.openqa.selenium.WebDriver;

public class Constants {
    public static final String BROWSER_SETTING_FILE = "src/test/resources/browsers.setting.ini";
    public static WebDriver WEBDRIVER;
    public final static String BASE_URL = "http://railway2.somee.com/Page/HomePage.cshtml";

    public final static String EMAIL = "test@railway.com";
    public final static String PASSWORD = "validPassword";
    public final static int TIME_WAIT = 30;
    public final static int QUICK_TIME = 3;
}
