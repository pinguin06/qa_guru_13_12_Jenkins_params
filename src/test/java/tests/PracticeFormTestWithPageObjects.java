package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


    public class PracticeFormTestWithPageObjects extends TestBase {

        @Test
        void successfulTest() {
            String fname = "Olga";
            String lname = "Romanshchak";
            String email = "email@test.qa";

            registrationForm.openPage()
                    .setFirstName(fname)
                    .setLastName(lname)
                    .setEmail(email)
                    .setGender("Female")
                    .setNumber("9291027606")
                    .setDateOfBirth("16", "June", "1990")
                    .setSubject("M")
                    .setHobbies("Sports")
                    .uploadFile("src\\test\\resources\\1.txt")
                    .setAddress("Saint Petersburg")
                    .setState("Haryana")
                    .setCity("Panipat")
                    .clickSubmit()
                    .checkResult("Student Name", fname + " " + lname)
                    .checkResult("Student Email", email)
                    .checkResult("Date of Birth", "16 June,1990")
                    .checkResult("Gender", "Female")
                    .checkResult("Mobile", "9291027606")
                    .checkResult("Subjects", "Maths")
                    .checkResult("Hobbies", "Sports")
                    .checkResult("Address", "Saint Petersburg")
                    .checkResult("State and City", "Haryana Panipat");
        }
    }
