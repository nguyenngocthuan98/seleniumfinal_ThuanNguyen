package tests;

import helpers.Constants;
import helpers.LogHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
    @BeforeMethod
    public void beforeMethod() {
        LogHelper.logInfo("Before method");
        WebDriverManager.chromedriver().setup();
        Constants.WEBDRIVER = new ChromeDriver();
        Constants.WEBDRIVER.get(Constants.BASE_URL);
    }

    @AfterMethod
    public void afterMethod() {
        LogHelper.logInfo("After method");
        Constants.WEBDRIVER.quit();
    }
}
