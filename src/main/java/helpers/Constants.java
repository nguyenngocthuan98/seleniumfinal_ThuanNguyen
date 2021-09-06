package helpers;

import org.openqa.selenium.WebDriver;

public class Constants {
    public static WebDriver WEBDRIVER;
    public final static String BASE_URL = "http://railway2.somee.com/Page/HomePage.cshtml";

    public final static String EMAIL = "test@railway.com";
    public final static String PASSWORD = "validPassword";
    public final static String NOTSAMEWITHPASSWORD = "notTheSameWithPassword";
    public final static String NEWVALIDPASSWORD = "newValidPassword";
    public final static Integer TIME_WAIT = 30;
    public final static Integer QUICK_TIME = 3;
}
