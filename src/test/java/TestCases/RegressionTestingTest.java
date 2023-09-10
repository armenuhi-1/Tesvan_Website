package TestCases;

import POM.RegressionTestingPOM;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;
import static com.codeborne.selenide.WebDriverConditions.url;

public class RegressionTestingTest {

    public static RegressionTestingPOM reg = new RegressionTestingPOM();

    @BeforeAll
    static void beforeAll() {
        open("https://www.tesvan.com/en/services/functional_testing_regression_testing");

        SelenideElement popup = reg.contactModal();
        if (popup.is(visible)) {
            SelenideElement closeButton = reg.contactModalCloseBtn();
            closeButton.click();
        }
    }


    @Test
    void verifyRegressionTestingPageContent() {

        reg.headline()
                .shouldBe(visible)
                .shouldHave(text("Regression"))
                .shouldHave(cssValue("font-size", "100px"));

        reg.headerContent()
                .shouldHave(matchText("Along with the whole QA lifecycle"))
                .shouldNotBe(empty);

        reg.underlinedTitle()
                .shouldBe(visible);

    }


    @Test
    void verifyContactUsButtonNavigation() {
        reg.contactUsBtn().isDisplayed();
        reg.contactUsBtn()
                .shouldBe(enabled)
                .click();

        webdriver().shouldHave(currentFrameUrl("https://www.tesvan.com/en" + "/contacts"));

        reg.backToHomeBtn()
                .shouldBe(enabled)
                .click();
        webdriver().shouldHave(url("https://www.tesvan.com/en"));
    }


    @Test
    void verifyContactUsButtonHoverEffect() {
        reg.contactUsBtn()
                .hover()
                .shouldHave(cssValue("color", "rgba(18, 34, 45, 1)"));
    }


    @Test
    void verifyFAQContainerContent() {
        reg.FAQHeader().isDisplayed();
        reg.FAQHeader()
                .shouldHave(text("Frequently Asked Questions"))
                .shouldHave(cssValue("font-weight", "400"));

        reg.FAQContainer().isDisplayed();
        reg.FAQContainer().shouldHave(innerText("What is regression testing?"));
    }


    @Test
    void verifyFAQContainerOpenerFunctionality() {
        reg.FAQOpener().isDisplayed();
        reg.FAQOpener()
                .shouldBe(enabled)
                .click();
        reg.FAQAnswer().isDisplayed();
    }
}
