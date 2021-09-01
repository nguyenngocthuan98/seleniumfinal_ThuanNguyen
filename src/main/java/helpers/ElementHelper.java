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
     * Get Depart day by index value of dropdown.
     *
     * @param indexDay
     * @return
     */
    public static String departDay(int indexDay) {
        calendar.setTime(DataHelper.getCurrentDate());

        calendar.add(Calendar.DATE, 3 + indexDay);

        return formatDate().format(calendar.getTime());
    }

    /**
     * Get Expired day by Depart day of ticket.
     * Convert Depart day value from String type to Date type, using calendar -1 day and then convert to String again.
     *
     * @param departDay
     * @return
     * @throws ParseException
     */
    public static String expiredDay(String departDay) throws ParseException {
        Date expiredDay = formatDate().parse(departDay);

        calendar.setTime(expiredDay);

        calendar.add(Calendar.DATE, -1);

        return formatDate().format(calendar.getTime());
    }

    public static boolean doesElementExist(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            System.out.println("Element " + element.getText() + " doesn't exist");
            return false;
        }
    }
}
