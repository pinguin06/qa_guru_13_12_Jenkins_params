package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;
import pages.components.UploadPictureComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm {

    CalendarComponent calendarComponent = new CalendarComponent();
    UploadPictureComponent uploadPictureComponent = new UploadPictureComponent();
    public ResultTableComponent resultsTableComponent = new ResultTableComponent();

    public RegistrationForm openPage() {
        open("/automation-practice-form");
     //   $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }
    public RegistrationForm setFirstName(String value) {
        $("#firstName").setValue(value);

        return this;
    }
    public RegistrationForm setLastName(String value) {
        $("#lastName").setValue(value);

        return this;
    }
    public RegistrationForm setEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationForm setGender(String value) {
        $("#genterWrapper").$(byText("Female")).click();

        return this;
    }
    public RegistrationForm setNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationForm setAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;
    }
    public RegistrationForm setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationForm setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationForm setSubject(String value) {
        $("#subjectsInput").sendKeys(value);
        $(byText("Maths")).click();

        return this;
    }

    public RegistrationForm uploadFile(String path) {
        uploadPictureComponent.pictureUpload(path);

        return this;
    }

    public RegistrationForm setState(String value) {
        $("#state").click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationForm setCity(String value) {
        $("#city").click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationForm checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);

        return this;
    }
}
