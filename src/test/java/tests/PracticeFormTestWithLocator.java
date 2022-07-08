package tests;

import com.codeborne.selenide.Configuration;
import helpers.Attach;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class PracticeFormTestWithLocator extends TestBase {

    @Test
    @Owner("ORomanshchak")
    @DisplayName("Successful fill form")
    void successfulTest() {
        String fname = "Olga";
        String lname = "Romanshchak";
        String email = "email@test.qa";

        step("Открываем форму регистрации", () -> {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript("$('footer').remove()");
            executeJavaScript("$('#fixedban').remove()");
            Attach.screenshotAs("Last screenshot_open");
        });

        step("Заполняем поля на форме", () -> {
            $("#firstName").setValue(fname);
            $("#lastName").setValue(lname);
            $("#userEmail").setValue(email);
            $("#userNumber").setValue("9291027606");
            $("#genterWrapper").$(byText("Female")).click();
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").click();
            $(".react-datepicker__month-select").selectOption("June");
            $(".react-datepicker__year-select").click();
            $(".react-datepicker__year-select").selectOption("1990");
            $(".react-datepicker__day--016").click();
            $("#subjectsInput").sendKeys("M");
            $(byText("Maths")).click();
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#hobbiesWrapper").$(byText("Music")).click();
            $("#uploadPicture").uploadFile(new File("src\\test\\resources\\1.txt"));
            $("#currentAddress").setValue("Saint Petersburg");
            $("#state").click();
            $(byText("Haryana")).click();
            Attach.screenshotAs("Last screenshot_fill");
            $("#city").click();
            $(byText("Panipat")).click();
            $("#submit").click();
        });

        step("Проверяем результат регистрации", () -> {
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
        });
    }
}
