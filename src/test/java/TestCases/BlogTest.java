package TestCases;

import POM.BlogPOM;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.codeborne.selenide.Configuration;


public class BlogTest {


    public static BlogPOM blog = new BlogPOM();

    @BeforeEach
    void beforeEach() {
        open("https://www.tesvan.com/en/blog/salesforce-based-applications");
        //I open a random blog here to test certain features on it.

        Configuration.timeout = 10000;

        SelenideElement popup = blog.contactModal();
        if (popup.is(visible)) {
            SelenideElement closeButton = blog.contactModalCloseBtn();
            closeButton.click();
        }
    }


    @Test
    void verifyContentItemNegotiation() {
        blog.contentItem()
                .shouldBe(visible)
                .click();

        blog.contentItem().scrollIntoView(true);
        blog.blogHeader().shouldBe(visible);
    }

    @Test
    void verifyShareContainerExist() {
        blog.shareContainer().shouldBe(visible);
        blog.shareFacebookItem().isDisplayed();
        blog.shareLinkedinItem().isDisplayed();
    }

    @Test
    void verifyFBItemNegotiation() {
        int initialTabCount = WebDriverRunner.getWebDriver().getWindowHandles().size();
        blog.shareFacebookItem().click();

        int newTabCount = WebDriverRunner.getWebDriver().getWindowHandles().size();
        assertEquals(initialTabCount + 1, newTabCount, "A new tab was not opened");
    }

    @Test
    void verifyNewTabFromArticle() {
        int initialTabCount = WebDriverRunner.getWebDriver().getWindowHandles().size();
        blog.severalProjectsURL().click();
        switchTo().window(initialTabCount);

        String newTabUrl = WebDriverRunner.url();
        assertEquals("https://tesvan.com/en/cases", newTabUrl, "New tab did not navigate to the expected URL");

        closeWindow();
        switchTo().window(0);
    }
}




