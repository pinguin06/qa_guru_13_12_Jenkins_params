package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.*;

public class PracticeFormTestWithRandomUtils extends TestBase {
    @Test
    void successfulTest() {
        String fname = getRandomString(10);
        String lname = getRandomString(10);
        String email = getRandomEmail();
        String userNumber = getRandomPhone();
        String gender = getGender();
        String address = getRandomMessage(1,5);

        open("/automation-practice-form");
        //команды, которые прячут рекламу от гугла и нижний блок
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(fname);
        $("#lastName").setValue(lname);
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(userNumber);
        $("#genterWrapper").$(byText(gender)).click();

        //Вводим дату рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1990");
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
        $("#currentAddress").setValue(address);

        //Штат / город
        $("#state").click();
        $(byText("Haryana")).click();

        $("#city").click();
        $(byText("Panipat")).click();


        $("#submit").click();

        //проверка выводимого результата
        $(".modal-content").shouldHave(
                text(fname),
                text(lname),
                text(email),
                text(userNumber),
                text(gender),
                text("16 June,1990"),
                text("Maths"),
                text("Sports, Music"),
                text("1.txt"),
                text(address),
                text("Haryana Panipat"));

    }
}
