package TestCases;


import POM.HomePagePOM;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class HomePageTest {

    public static HomePagePOM home = new HomePagePOM();

    @BeforeEach
    void beforeEach() {
        open("https://www.tesvan.com/en");

        SelenideElement popup = home.contactModal();
        if (popup.is(visible)) {
            SelenideElement closeButton = home.contactModalCloseBtn();
            closeButton.click();
        }
    }

    @Test
    public void verifyPageURLAndTitle() {
        String url = "https://www.tesvan.com/en";
        home.open();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(url, currentUrl);

        home.pageTitle().shouldHave(innerText("`TESVAN A COMPANY OF QUALITY"));
    }


    @Test
    public void verifyLogoExist() {
        home.pageLogo().shouldBe(visible);
    }


    @Test
    public void verifyMenuItemsConsistency() {
        home.menuBar()
                .shouldHave(CollectionCondition.size(1))
                .shouldHave(CollectionCondition.itemWithText("COMPANY\n" +
                        "\n" +
                        "SERVICES\n" +
                        "\n" +
                        "CASES\n" +
                        "EDUCATION\n" +
                        "COURSES\n" +
                        "BLOG\n" +
                        "CONTACTS"))
                .shouldHave(CollectionCondition.texts("COMPANY"));
    }


    @Test
    public void verifyHeaderTextContent() {
        String expectedText = "TESVAN A COMPANY OF QUALITY";
        home.header()
                .shouldHave(text(expectedText))
                .shouldNotBe(empty);
    }


    @Test
    void verifyHeaderLength() {
        int maxTitleLength = 70;

        home.header().shouldHave(text("TESVAN A COMPANY OF QUALITY"));
        home.header().shouldHave(matchText(".{1," + maxTitleLength + "}"));
    }

    @Test
    public void verifyHeadlineStylingAndAppearance() {
        home.header()
                .shouldBe(visible)
                .shouldHave(cssValue("font-size", "100px"))
                .shouldHave(cssValue("color", "rgba(255, 255, 255, 1)"))
                .shouldHave(cssValue("text-align", "center"));
    }


    //  @Test
    public void VerifyHeadlineLocalizationAndInternationalization() {
        home.languageMenu()
                .click();
        if (home.languageAM().isDisplayed()) {
            home.languageAM().click();
            home.header()
                    .shouldHave(text("ՈՐԱԿԻ ԸՆԿԵՐՈՒԹՅՈՒՆ"));
            String url = WebDriverRunner.url();
            assertEquals(url, "https://www.tesvan.com/am");
        } else {
            home.languageRU().click();
            home.header()
                    .shouldHave(text("КОМПАНИЯ КАЧЕСТВА"));
        }

        home.languageMenu()
                .click();
        home.languageEN().isDisplayed();
        home.languageEN().click();

    }


    @Test
    public void verifySubtitleTextContent() {
        String expectedText = "Nothing makes the product more attractive but quality. We are here to provide high-quality of your software.";
        home.subTitle().shouldHave(matchText(expectedText))
                //  .shouldNotHave(text("Quality Company"))
                .shouldNotBe(empty);
    }


    @Test
    public void verifySubtitleStylingAndAppearance() {
        home.subTitle()
                .shouldBe(visible)
                .shouldHave(cssValue("font-size", "20px"))
                .shouldHave(cssValue("color", "rgba(212, 212, 212, 1)"))
                .shouldHave(cssValue("text-align", "center"));
    }


    @Test
    public void verifySeeMoreButton() {
        home.seeMoreBtn()
                .isDisplayed();
        home.seeMoreBtn()
                .click();

        home.seeMoreBtn().scrollIntoView(true);
        home.block().shouldBe(visible);
    }


    @Test
    public void verifyServicesContainerStylingAndAppearance() {
        home.servicesBtn()
                .shouldBe(visible)
                .shouldHave(cssValue("color", "rgba(255, 255, 255, 1)"));
    }

    @Test
    public void verifyServicesContainerContent() {
        String expectedText1 = "QUALITY ASSURANCE";
        String notExpectedText = "Tesvan provides UI/UX design";
        String expectedText2 = "WEB / MOBILE DEVELOPMENT";
        String expectedText3 = "Tesvan’s team will help you to drive automation";

        home.servicesBlock()
                .shouldBe(visible);

        home.servicesContainer1()
                .shouldHave(text(expectedText1));

        home.servicesContainer2()
                .isDisplayed();

        home.servicesContainer3()
                .shouldNotHave(innerText(notExpectedText))
                .shouldHave(text(expectedText2));

        home.servicesContainer4()
                .shouldHave(matchText(expectedText3));
    }


    @Test
    public void verifyServicesBlockNavigation() {
        home.servicesArrow()
                .isDisplayed();
        home.servicesArrow()
                .click();

        webdriver().shouldHave(currentFrameUrl("https://www.tesvan.com/en" + "/services"));

        home.backToHomeBtn().click();
        webdriver().shouldHave(url("https://www.tesvan.com/en"));
    }


    @Test
    void verifyWhyWeContainerContentAndStyling() {
        home.whyWeBlock()
                .shouldBe(visible);
        home.whyWeBlock()
                .shouldHave(matchText("Because we are a company of quality!"))
                .shouldNotBe(readonly)
                .shouldHave(cssValue("font-weight", "400"));
    }


    @Test
    public void verifyAboutUsImage() {
        home.aboutUsImage().shouldBe(visible);
    }


    @Test
    public void verifyImageStylingAndLayout() {
        home.aboutUsImage().shouldHave(attribute("fetchpriority", "high"))
                .shouldHave(attribute("width", "480"))
                .shouldHave(attribute("height", "720"));
    }

    @Test
    public void verifyImageAccessibility() {
        String altText = home.aboutUsImage().getAttribute("alt");
        assertEquals(false, altText.isEmpty(), "Alt text is missing for the image.");
    }


    @Test
    public void verifyLearnMoreButtonVisibilityAndNavigation() {
        home.learnMoreBtn()
                .shouldBe(enabled)
                .click();

        webdriver().shouldHave(currentFrameUrl("https://www.tesvan.com/en" + "/company/about"));

        home.backToHomeBtn()
                .shouldBe(visible)
                .click();
        webdriver().shouldHave(url("https://www.tesvan.com/en"));
    }


    @Test
    void verifySlickSliderFunctionality() {
        home.slickSliderBlock().shouldBe(visible);

        home.sliderNextBtn().shouldBe(visible)
                .shouldBe(enabled)
                .click();

        home.sliderPreviousBtn().shouldBe(visible)
                .shouldBe(enabled)
                .click();
    }


    @Test
    void verifySendUsAMessageSectionDataValidation() {
        home.contactBorder().isDisplayed();

        home.fullNameField().setValue("Armneuhi Khachatryan");
        home.emailField().setValue("armenuhi.khachatryan2000@gmail.com");
        home.phoneNumberField().setValue("+37499244210");
        home.companyNameField().setValue("Tesvan");
        home.descriptionField().setValue("This is a test message for the Send Us A Message form.");

        home.checkbox().setSelected(true);
        home.sendMessageBtn().click();
        home.responseMessage().shouldHave(text("Your message has been sent successfully."));
    }


    @Test
    void verifySendUsAMessageSectionWithoutCredentials() {
        String expectedTextName = "Full Name can not be blank";
        String expectedTextEmail = "Email can not be blank";
        String expectedTextNumber = "Phone can not be blank";
        String expectedTextDescbr = "Description can not be blank";
        String expectedTextCheckbox = "Please check and accept our Privacy Policy";

        home.sendMessageBtn().click();

        home.nameInputError().shouldHave(text(expectedTextName));
        home.emailInputError().shouldHave(text(expectedTextEmail));
        home.phoneNumberInputError().shouldHave(text(expectedTextNumber));
        home.descriptionInputError().shouldHave(text(expectedTextDescbr));
        home.checkboxInputError().shouldHave(text(expectedTextCheckbox));
    }


    @Test
    void verifyFullNameFieldsAcceptsOnlyLetters() {
        home.fullNameField().setValue("Armenuhi Khachatryan").shouldHave(Condition.value("Armenuhi Khachatryan"));
        home.fullNameField().setValue("Armenuhi123").shouldNotHave(Condition.value("Armenuhi123"));
    }


    @Test
    void verifyEmailFieldAcceptanceCredentials() {
        String validEmail = "armenuhi.khachatryan2000@gmail.com";
        home.emailField().shouldBe(Condition.visible).setValue(validEmail);
    }


    @Test
    void verifyDescriptionFieldAcceptanceCredentials() {
        String shortDescription = "test";

        home.descriptionField().setValue(shortDescription);
        home.descriptionInputError().shouldHave(text("Description should contain minimum 20 characters"));
    }


    //  @Test
    void verifyPhoneFieldAcceptsOnlyNumbers() {
        String invalidInput = "abc123";
        home.phoneNumberField().setValue(invalidInput);

        home.phoneNumberInputError().should(Condition.text("Please enter a valid phone number"));

        home.phoneNumberField().clear();

        String validInput = "1234567890";
        home.phoneNumberField().setValue(validInput);

        home.phoneNumberInputError().shouldNotBe(exist);
    }


    @Test
    void verifyContactInformationAppearance() {
        home.contactInfoTitle()
                .shouldBe(visible)
                .shouldHave(cssValue("color", "rgba(245, 180, 26, 1)"))
                .shouldHave(cssValue("font-size", "40px"));

        home.contactAddress()
                .shouldBe(visible)
                .shouldHave(text("Armenia"));

        home.contactPhoneNumber()
                .shouldBe(visible)
                .shouldHave(text("Phone"));

        home.contactSocialMedia()
                .shouldBe(visible)
                .shouldHave(text("Social Media"));
    }


    @Test
    void verifyPhoneNumberAccessibility() {
        home.contactPhoneDigits()
                .shouldHave(text("+(374) 99 79 02 70"))
                .shouldHave(enabled)
                .click();
    }

    @Test
    void verifySocialMediaNavigation() {
        home.upworkLink()
                .shouldHave(enabled);

        home.linkedinLink()
                .shouldHave(enabled);

        home.facebookLink()
                .shouldHave(enabled);
    }
}

