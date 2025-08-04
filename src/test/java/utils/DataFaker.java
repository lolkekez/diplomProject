package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataFaker {

    public Faker faker = new Faker(new Locale("en-GB"));

    public String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public String getRandomPassword() {
        return faker.internet().password();
    }

    public String getRandomLine() {
        return faker.internet().toString();
    }

}
