package TestCases;

import POM.CasesPOM;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverConditions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;
import static com.codeborne.selenide.WebDriverRunner.url;


public class CasesTest {

    public static CasesPOM cs = new CasesPOM();

    @BeforeAll
    static void beforeAll() {
        open("https://www.tesvan.com/en/cases");

        SelenideElement popup = cs.contactModal();
        if (popup.is(visible)) {
            SelenideElement closeButton = cs.contactModalCloseBtn();
            closeButton.click();
        }
    }


    @Test
    void verifyFilterPartContainerContent() {
        cs.filterPartContainer()
                .shouldHave(CollectionCondition.itemWithText("All\n" +
                        "Management\n" +
                        "Sales\n" +
                        "Entertainment\n" +
                        "Medical\n" +
                        "Gambling\n" +
                        "Marketing\n" +
                        "Finance\n" +
                        "Communication\n" +
                        "Mobile Game\n" +
                        "Legal\n" +
                        "Telecommunication\n" +
                        "Blockchain\n" +
                        "AR/VR"));
    }


    @Test
    void verifyFilterPartContainerSelection() {
        cs.managementFilter()
                .shouldBe(appear)
                .click();

        cs.managementFilter().isDisplayed();
        cs.managementFilter().getCssValue("cursor: pointer");

        cs.filterPartContainer().shouldHave(CollectionCondition.sizeGreaterThan(0));
    }


    @Test
    void verifyDeselectFilters() {
        cs.managementFilter()
                .shouldBe(visible)
                .click();
        cs.managementFilter().getCssValue("cursor: pointer");

        cs.allFilter()
                .shouldBe(visible)
                .click();
        cs.allFilter().getCssValue("cursor: pointer");
    }


    @Test
    void verifyFilterBehavior() {
        cs.managementFilter()
                .shouldBe(visible)
                .click();

        cs.casesContainer().forEach(item -> item.shouldHave(text("Customertimes")));
    }


    @Test
    void verifyFilterResponseTime() {
        cs.open();
        long startTime = System.currentTimeMillis();
        cs.managementFilter()
                .shouldBe(visible)
                .click();
        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;

        assert (responseTime < 5000);
    }


    @Test
    void verifyNoPageReloadOnFilter() {
        cs.managementFilter()
                .shouldBe(visible)
                .click();

        String currentUrl = url();
        assert (currentUrl.equals("https://www.tesvan.com/en/cases"));
    }


    @Test
    void verifyManagementContainerWhenHoverOver() {
        String expectedCaseTech = "Mobile Automation testing, Manual testing";
        String expectedCaseIndustry = "Management";

        cs.managementContainer().hover();
        cs.managementContainerCaseTech()
                .should(appear)
                .shouldHave(text(expectedCaseTech));

        cs.managementCaseIndustry().isDisplayed();
        cs.managementCaseIndustry().shouldHave(text(expectedCaseIndustry));

        cs.readMoreBtn().isDisplayed();
        cs.readMoreBtn().isEnabled();
    }


    @Test
    void verifyReadMoreButtonFunctionality() {
        String expectedHeaderTitle = "CUSTOMERTIMES";

        cs.managementContainer()
                .shouldBe(visible)
                .hover();
        cs.readMoreBtn()
                .should(appear)
                .click();

        webdriver().shouldHave(currentFrameUrl("https://www.tesvan.com/en/cases/" + "customertimes"));

        cs.customertimesHeaderTitle().isDisplayed();
        cs.customertimesHeaderTitle().shouldHave(text(expectedHeaderTitle));
        cs.customertimesHeaderTitle().shouldHave(cssValue("font-size", "100px"));

        cs.backToCasesBtn().click();
        webdriver().shouldHave(WebDriverConditions.url("https://www.tesvan.com/en/cases"));
    }


    @Test
    void verifyPaginationControlsDisplayed() {
        cs.casesPagination().isDisplayed();
        cs.previousPage().isDisplayed();
        cs.nextPage().isDisplayed();
    }
}

