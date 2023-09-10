package TestCases;

import POM.CareersPOM;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class CareersTest {

    public static CareersPOM careers = new CareersPOM();

    @BeforeAll
    static void beforeAll() {
        open("https://www.tesvan.com/en/company/careers/sales_specialist?sent=success");

        SelenideElement popup = careers.contactModal();
        if (popup.is(visible)) {
            SelenideElement closeButton = careers.contactModalCloseBtn();
            closeButton.click();
        }
    }

    @Test
    void verifyFullNameFieldsAcceptsOnlyLetters() {
        careers.fullNameField().setValue("Armenuhi Khachatryan").shouldHave(Condition.value("Armenuhi Khachatryan"));
        careers.applyBtn().click();
        careers.fullNameField().setValue("Armenuhi123").shouldNotHave(Condition.value("Armenuhi123"));
        careers.fullNameField().clear();
    }

    @Test
    void verifyEmailFieldAcceptanceCredentials() {
        String validEmail = "armenuhi.khachatryan2000@gmail.com";
        careers.emailField().shouldBe(visible).setValue(validEmail);
        careers.applyBtn().click();
        careers.emailField().clear();
    }


    @Test
    void verifyApplyNowSectionValidation() {
        careers.applyNowBlock().isDisplayed();

        careers.fullNameField().setValue("Armneuhi Khachatryan");
        careers.emailField().setValue("armenuhi.khachatryan2000@gmail.com");
        careers.phoneNumberField().setValue("+37499244210");
        careers.coverLetterField().setValue("Cover Letter");

        careers.attachCVField().uploadFile(new File("src/test/Data/Test.CV.pdf"));

        careers.checkbox().setSelected(true);
        careers.applyBtn().click();
        careers.responseMessage().shouldHave(text("Your message has been sent successfully."));
    }


    @Test
    void verifyApplySectionWithoutCredentials() {
        careers.applyBtn()
                .shouldBe(visible)
                .click();

        careers.nameInputError()
                .shouldBe(visible)
                .shouldHave(text("Full Name can not be blank"));

        careers.phoneInputError()
                .shouldBe(visible)
                .shouldHave(text("Phone can not be blank"));
    }


    //  @Test
    void verifyPhoneFieldAcceptsOnlyNumbers() {
        String invalidInput = "abc123";
        careers.phoneNumberField().setValue(invalidInput);
        careers.applyBtn().click();

        careers.phoneInputError().should(Condition.text("Please enter a valid phone number"));

        careers.phoneNumberField().clear();

        String validInput = "1234567890";
        careers.phoneNumberField().setValue(validInput);
        careers.applyBtn().click();

        careers.phoneInputError().shouldNotBe(exist);
    }
}
