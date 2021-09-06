package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ElementHelper {
    private static final Calendar calendar = Calendar.getInstance();

    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) Constants.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void selectOption(WebElement element, String option) {
        (new Select(element)).selectByVisibleText(option);
    }

    public static SimpleDateFormat formatDate() {
        return new SimpleDateFormat("M/d/yyyy");
    }

    /**
     * Choose random depart date: Get current date and add a random date number between 3-30
     * @return departDay after random add date
     */
    public static String departDay() {
        calendar.setTime(DataHelper.getCurrentDate());
        calendar.add(Calendar.DATE, DataHelper.getRandomDepartDate());
        return formatDate().format(calendar.getTime());
    }

    public static boolean doesElementDisplay(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            System.out.println("Element " + element.getText() + " doesn't exist");
            return false;
        }
    }
}
