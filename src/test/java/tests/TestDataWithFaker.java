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
            year = String.valueOf(faker.number().numberBetween(1970, 2004)),
            day = String.valueOf(faker.number().numberBetween(1, 28));


   // public final static String day = faker.number().numberBetween(1, 28);
   // year = String.valueOf(faker.number().numberBetween(1970, 2022)),



  //  NUMBER = "9291027606",
  //  MONTH = "June",
  //  YEAR = "1990",
  //  SUBJECT = "Maths",
  //  HOBBY = "Sports",
  //  PATH = "src\\test\\resources\\1.txt",
  //  ADDRESS = "Saint Petersburg",
 //   STATE = "Haryana",
 //   CITY = "Panipat";



}
