package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080"; //задание размера окна
    }

    @Test
    void successfulTest() {
        String name = "Alex";

        open("/text-box");
        //команды, которые прячут рекламу от гугла и нижний блок
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

    //ВВодим значения в поля
        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue("alex@egorov.com");
        $("[id=currentAddress]").setValue("Some address 1");
        $("[id=permanentAddress]").setValue("Another address 2");
        $("[id=submit]").click();

        //проверка выводимого результата
        $("[id=output]").shouldHave(text(name), text("alex@egorov.com"),
                text("Some address 1"), text("Another address 2"));
    }
}