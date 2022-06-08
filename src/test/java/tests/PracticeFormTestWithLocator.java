package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

    public class PracticeFormTestWithLocator extends TestBase {
        @Test
        void successfulTest() {
            String fname = "Olga";
            String lname = "Romanshchak";
            String email = "email@test.qa";

            open("/automation-practice-form");
            //команды, которые прячут рекламу от гугла и нижний блок
            executeJavaScript("$('footer').remove()");
            executeJavaScript("$('#fixedban').remove()");

            //ВВодим значения в поля
            $("#firstName").setValue(fname);
            $("#lastName").setValue(lname);
            $("#userEmail").setValue(email);
            $("#userNumber").setValue("9291027606");

            //Выбираем пол
            $("#genterWrapper").$(byText("Female")).click();

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
            $("#currentAddress").setValue("Saint Petersburg");

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
                    text("9291027606"),
                    text("Female"),
                    text("16 June,1990"),
                    text("Maths"),
                    text("Sports, Music"),
                    text("1.txt"),
                    text("Saint Petersburg"),
                    text("Haryana Panipat"));

        }
    }
