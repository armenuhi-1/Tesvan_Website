package TestCases;


import POM.ServicesPOM;
import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.Condition.*;

import org.junit.jupiter.api.BeforeAll;


public class ServicesTest {


    public static ServicesPOM serv = new ServicesPOM();

    @BeforeAll
    static void

    beforeAll() {
        open("https://www.tesvan.com/en/services");

        SelenideElement popup = serv.contactModal();
        if (popup.is(visible)) {
            SelenideElement closeButton = serv.contactModalCloseBtn();
            closeButton.click();
        }
    }

    @Test
    void verifyHeaderTextContent() {
        serv.header()
                .shouldBe(visible)
                .shouldHave(text("QUALITY ASSURANCE"))
                .shouldHave(cssValue("color", "rgba(255, 255, 255, 1)"));
    }

    @Test
    void verifyHeaderLength() {
        int maxTitleLength = 70;

        serv.pageTitle().shouldHave(text("QUALITY ASSURANCE"));
        serv.pageTitle().shouldHave(matchText(".{1," + maxTitleLength + "}"));
    }


    @Test
    void verifyScrollDownButtonFunctionality() {
        serv.headerBtn()
                .shouldBe(visible)
                .shouldHave(enabled)
                .click();

        serv.headerBtn().scrollIntoView(true);
        serv.movableMenuContainer().shouldBe(visible);
    }


    @Test
    void verifyMovableMenuContent() {
        serv.movableMenuContent().shouldHave(CollectionCondition.itemWithText("Content\n" +
                "Functional Testing\n" +
                "Non Functional Testing\n" +
                "TEST DESIGN & REPORTING\n" +
                "Digital Testing\n" +
                "Other Services"));
    }


    @Test
    void verifyMovableMenuNavigation() {
        serv.functionalTestingItem().click();
        serv.functionalTestingItem().scrollIntoView(true);
        serv.functionalTestingContainer().shouldBe(visible);
    }


    @Test
    void verifyRegressionTestingNavigation() {
        serv.functionalTesting().isDisplayed();
        serv.functionalTesting()
                .shouldHave(enabled)
                .click();

        webdriver().shouldHave(currentFrameUrl("https://www.tesvan.com/en/services" + "/functional_testing_regression_testing"));

        serv.backToServicesBtn().click();
        webdriver().shouldHave(url("https://www.tesvan.com/en/services"));
    }
}

