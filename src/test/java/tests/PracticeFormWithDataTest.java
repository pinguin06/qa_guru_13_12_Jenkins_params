package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class PracticeFormWithDataTest extends TestBase {
    @Test
    void successfulTest() {
      //  String fname = "Olga";
     //   String lname = "Romanshchak";
     //   String email = "email@test.qa";

        open("/automation-practice-form");
        //команды, которые прячут рекламу от гугла и нижний блок
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        //ВВодим значения в поля
        $("#firstName").setValue(FIRST_NAME);
        $("#lastName").setValue(LAST_NAME);
        $("#userEmail").setValue(EMAIL);
        $("#userNumber").setValue(NUMBER);

        //Выбираем пол
        $("#genterWrapper").$(byText(SEX)).click();

        //Вводим дату рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(MONTH);
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption(YEAR);
        $(".react-datepicker__day--016").click();

        //Выбираем предмет
        $("#subjectsInput").sendKeys("M");
        $(byText(SUBJECT)).click();

        //Выбираем хобби
        $("#hobbiesWrapper").$(byText(HOBBY)).click();

        //Выбираем файл
        $("#uploadPicture").uploadFile(new File(PATH));

        //Адрес
        $("#currentAddress").setValue(ADDRESS);

        //Штат / город
        $("#state").click();
        $(byText(STATE)).click();

        $("#city").click();
        $(byText(CITY)).click();


        $("#submit").click();

        //проверка выводимого результата
        $(".modal-content").shouldHave(
                text(FIRST_NAME),
                text(LAST_NAME),
                text(EMAIL),
                text(NUMBER),
                text(SEX),
                text("16 " + MONTH + ","+ YEAR),
                text(SUBJECT),
                text(HOBBY),
                text("1.txt"),
                text(ADDRESS),
                text(STATE + " " + CITY));

    }
}
