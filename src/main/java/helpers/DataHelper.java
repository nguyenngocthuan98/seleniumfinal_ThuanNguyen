package helpers;

import com.github.javafaker.Faker;

import java.util.Date;

public class DataHelper {
    private static final Faker faker = new Faker();

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomNumber() {
        return faker.numerify("########");
    }

    public static Date getCurrentDate() {
        return new Date();
    }

    public static int getRandomNumber3To30() {
        return faker.number().numberBetween(3, 30);
    }
}
