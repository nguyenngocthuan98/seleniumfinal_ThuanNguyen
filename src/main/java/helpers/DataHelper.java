package helpers;

import com.github.javafaker.Faker;
import entities.Account;

import java.util.Date;

public class DataHelper {
    private static final Faker faker = new Faker();

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomPassword() {
        return faker.letterify("????????");
    }

    public static String getRandomNumber() {
        return faker.numerify("########");
    }

    public static Date getCurrentDate(){
        return new Date();
    }

    public static void setValidLoginAccount(Account account){
        account.setEmail(Constants.EMAIL);
        account.setPassword(Constants.PASSWORD);
    }

    public static void setBlankEmailLoginAccount(Account account){
        account.setEmail("");
        account.setPassword(Constants.PASSWORD);
    }

    public static void setInvalidPasswordLoginAccount(Account account){
        account.setEmail(Constants.EMAIL);
        account.setPassword("this_is_wrong_password");
    }
}
