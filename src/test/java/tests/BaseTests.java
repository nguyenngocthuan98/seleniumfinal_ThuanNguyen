package tests;

import com.logigear.driver.DriverProperty;
import com.logigear.driver.DriverUtils;
import com.logigear.helper.BrowserSettingHelper;
import helpers.Constants;
import helpers.LogHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTests {
    @BeforeMethod
    @Parameters("Browser")
    public void beforeMethod(@Optional("firefox.local") String browser) throws Exception {
        LogHelper.logInfo("Before method");
        DriverProperty driverProperty = BrowserSettingHelper.getDriverProperty(Constants.BROWSER_SETTING_FILE, browser);
        DriverUtils.getDriver(driverProperty);
        DriverUtils.setTimeOut(Constants.LONG_WAITING_TIME);
        DriverUtils.navigate(Constants.BASE_URL);
    }

    @AfterMethod
    public void afterMethod() {
        LogHelper.logInfo("After method");
        DriverUtils.quitBrowser();
    }
}
