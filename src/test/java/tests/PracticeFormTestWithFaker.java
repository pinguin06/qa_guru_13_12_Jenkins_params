package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestDataWithFaker.*;
import static utils.RandomUtils.*;

public class PracticeFormTestWithFaker extends TestBase {
    @Test
    void successfulTest() {
        String gender = getGender();
        open("/automation-practice-form");

        //команды, которые прячут рекламу от гугла и нижний блок
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(phone);
        $("#genterWrapper").$(byText(gender)).click();

        //Вводим дату рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--016").click();

        //Выбираем предмет
        $("#subjectsInput").sendKeys("M");
        $(byText("Maths")).click();

        //Выбираем хобби
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        //Выбираем файл
        $("#uploadPicture").uploadFile(new File("src\\test\\resources\\1.txt"));

        //Адрес
        $("#currentAddress").setValue(currentAddress);

        //Штат / город
        $("#state").click();
        $(byText("Haryana")).click();

        $("#city").click();
        $(byText("Panipat")).click();


        $("#submit").click();

        //проверка выводимого результата
        $(".modal-content").shouldHave(
                text(firstName),
                text(lastName),
                text(email),
                text(phone),
                text(gender),
                text("16 June," + year),
                text("Maths"),
                text("Sports, Music"),
                text("1.txt"),
                text(currentAddress),
                text("Haryana Panipat"));

    }
}


