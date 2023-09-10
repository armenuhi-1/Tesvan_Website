package POM;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class RegressionTestingPOM {

    public RegressionTestingPOM open() {
        Selenide.open("https://www.tesvan.com/en/services/functional_testing_regression_testing");
        return this;
    }

    public SelenideElement contactModal() {
        return $("#__next > div.ContactModal_overlay__qoYke");
    }

    public SelenideElement contactModalCloseBtn() {
        return $("div.ContactModal_close__KCzRf");
    }

    public SelenideElement headline() {
        return $x("//h1[contains(@class, 'HeaderContent_title__J10CV')]");
    }

    public SelenideElement headerContent() {
        return $x("//h2[contains(@class, 'HeaderContent_subtitle__0vDAj')]");
    }

    public SelenideElement underlinedTitle() {
        return $x("//h2[contains(@class, 'TitleWithUnderline_simpleWhite__ueOPk')]");
    }

    public SelenideElement contactUsBtn() {
        return $("#headerButton");
    }

    public SelenideElement backToHomeBtn() {
        return $x("//a[@href='/en']");

    }

    public SelenideElement FAQHeader() {
        return $x("/html/body/div[1]/div[9]/div/div/div[1]/h2");
    }

    public SelenideElement FAQContainer() {
        return $x("/html/body/div[1]/div[9]/div/div/div[2]/div[1]/div/p");
    }

    public SelenideElement FAQOpener() {
        return $x("/html/body/div[1]/div[9]/div/div/div[2]/div[1]/div/span");
    }

    public SelenideElement FAQAnswer() {
        return $x("//p[contains(@class, 'FAQ_answer__jID01')]");
    }


}

