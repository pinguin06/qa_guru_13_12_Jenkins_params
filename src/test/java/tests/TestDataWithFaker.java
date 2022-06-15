package tests;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;

//вынесли переменные в новый класс
public class TestDataWithFaker {

    static Faker faker = new Faker(new Locale("ru"));
    static Faker fakerEN = new Faker(new Locale("en"));

    public final static  String firstName = faker.address().firstName(),
            lastName = faker.address().lastName(),
            email = fakerEN.internet().emailAddress(),
            currentAddress = faker.witcher().quote(),
            phone = faker.phoneNumber().subscriberNumber(10),
            year = String.valueOf(faker.number().numberBetween(1970, 2004));

}
