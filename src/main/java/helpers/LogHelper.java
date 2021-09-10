package helpers;

import java.text.SimpleDateFormat;

public class LogHelper {
    public static void logInfo(String message) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(DataHelper.getCurrentDate()) +
                " [Log INFO] - " + message);
    }
}
