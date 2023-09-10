package POM;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class HomePagePOM {

    public HomePagePOM open() {
        Selenide.open("https://www.tesvan.com/en");
        return this;
    }

    public SelenideElement contactModal() {
        return $("#__next > div.ContactModal_overlay__qoYke");
    }

    public SelenideElement contactModalCloseBtn() {
        return $("div.ContactModal_close__KCzRf");
    }

    public SelenideElement pageTitle() {
        return $("head > title");
    }

    public SelenideElement pageLogo() {
        return $("#navMenu > div.Logo_logo__oGIB8.NavMenu_logo___kegW");
    }

    public ElementsCollection menuBar() {
        return $$("#navMenu > div.MenuItems_items__JQKN4");
    }

    public SelenideElement header() {
        return $("#header > h1");
    }

    public SelenideElement subTitle() {
        return $("#header > h2");
    }

    public SelenideElement seeMoreBtn() {
        return $("#headerButton");
    }

    public SelenideElement block() {
        return $(".Main_wrapper__mGLsi > div:nth-child(4) > div > div > div.HomePageHeaderOffers_offersBorder__58hyD");
    }

    public SelenideElement servicesBtn() {
        return $("h2.TitleWithUnderline_whiteTitle__32CZt");
    }


    public SelenideElement servicesBlock() {
        return $("div[class*='placeholder']");
    }

    public SelenideElement servicesContainer1() {
        return $x("//*[@id=\"__next\"]/div/div[3]/div[4]/div/div/div[4]/div[1]");
    }

    public SelenideElement servicesContainer2() {
        return $x("//*[@id=\"__next\"]/div/div[3]/div[4]/div/div/div[4]/div[2]");
    }


    public SelenideElement servicesContainer3() {
        return $x("//*[@id=\"__next\"]/div/div[3]/div[4]/div/div/div[4]/div[3]");
    }

    public SelenideElement servicesContainer4() {
        return $x("//*[@id=\"__next\"]/div/div[3]/div[4]/div/div/div[4]/div[4]");
    }

    public SelenideElement servicesArrow() {
        return $x("/html/body/div[1]/div/div[3]/div[4]/div/div/div[4]/div[3]/h1");
    }

    public SelenideElement backToHomeBtn() {
        return $x("//a[@href='/en']");

    }

    public SelenideElement whyWeBlock() {
        return $("div[class='WhyWe_content__FCHYj']");
    }

    public SelenideElement aboutUsImage() {
        return $("img[alt='about_us_image']");
    }

    public SelenideElement learnMoreBtn() {
        return $x("//button[contains(@class, 'WhyWe_button__lk3NT')]");
    }

    public SelenideElement slickSliderBlock() {
        return $("html > body > div:nth-of-type(1) > div > div:nth-of-type(3) > div:nth-of-type(6) > div > div > div:nth-of-type(2) > div");
    }

    public SelenideElement sliderNextBtn() {
        return $("html > body > div:nth-of-type(1) > div > div:nth-of-type(3) > div:nth-of-type(6) > div > div > div:nth-of-type(2) > div > button:nth-of-type(2)");
    }

    public SelenideElement sliderPreviousBtn() {
        return $("html > body > div:nth-of-type(1) > div > div:nth-of-type(3) > div:nth-of-type(6) > div > div > div:nth-of-type(2) > div > button:nth-of-type(1)");
    }

    public SelenideElement languageMenu() {
        return $("li[class^='LanguageMenu']");
    }

    public SelenideElement languageAM() {
        return $("html > body > div:nth-of-type(1) > div > div:nth-of-type(1) > div:nth-of-type(3) > ul > li:nth-of-type(1)");
    }

    public SelenideElement languageRU() {
        return $("html > body > div:nth-of-type(1) > div > div:nth-of-type(1) > div:nth-of-type(3) > ul > li:nth-of-type(3)");
    }

    public SelenideElement languageEN() {
        return $("div.LanguageMenu_languageMenu__EGn_f > ul > li:nth-child(3)");
    }

    public SelenideElement contactBorder() {
        return $("div[class='Contact_border__M_Q_v']");
    }

    public SelenideElement fullNameField() {
        return $("html > body > div:nth-of-type(1) > div > div:nth-of-type(3) > div:nth-of-type(9) > div > div > div > div > div:nth-of-type(1) > form > div:nth-of-type(1) > div:nth-of-type(1) > label > div > input");
    }

    public SelenideElement emailField() {
        return $("div.ContactForm_first__qs9ba > div:nth-child(2) > label > div > input");
    }

    public SelenideElement phoneNumberField() {
        return $("div.ContactForm_second__WI9Zd > div:nth-child(1) > label > div > input");
    }

    public SelenideElement companyNameField() {
        return $("div.ContactForm_second__WI9Zd > div:nth-child(2) > label > div > input");
    }

    public SelenideElement descriptionField() {
        return $("div.ContactForm_textareaGroup__sXAWN > label > div > textarea");
    }

    public SelenideElement checkbox() {
        return $("div.ContactForm_control__w9zQ_ > label > div> input");
    }

    public SelenideElement sendMessageBtn() {
        return $("div.ContactForm_container__7Fof9 > form > button");
    }

    public SelenideElement responseMessage() {
        return $("div.ResponseMessages_message__gcPjy");
    }

    public SelenideElement nameInputError() {
        return $x("/html/body/div[1]/div/div[3]/div[9]/div/div/div/div/div[1]/form/div[1]/div[1]/label/div/p");
    }

    public SelenideElement emailInputError() {
        return $x("/html/body/div[1]/div/div[3]/div[9]/div/div/div/div/div[1]/form/div[1]/div[2]/label/div/p");
    }

    public SelenideElement phoneNumberInputError() {
        return $("html > body > div:nth-of-type(1) > div > div:nth-of-type(3) > div:nth-of-type(9) > div > div > div > div > div:nth-of-type(1) > form > div:nth-of-type(2) > div:nth-of-type(1) > label > div > p");
    }

    public SelenideElement descriptionInputError() {
        return $x("//p[@class='Textarea_error__FdPs5']");
    }

    public SelenideElement checkboxInputError() {
        return $x("//p[contains(@class, 'ContactForm_error__hJN9R')]");
    }

    public SelenideElement contactInfoTitle() {
        return $("h2[class^='ContactInfo']");
    }

    public SelenideElement contactAddress() {
        return $("p[class^='ContactInfo']");
    }

    public SelenideElement contactPhoneNumber() {
        return $x("/html/body/div[1]/div/div[3]/div[9]/div/div/div/div/div[2]/label[1]");
    }

    public SelenideElement contactSocialMedia() {
        return $x("/html/body/div[1]/div/div[3]/div[9]/div/div/div/div/div[2]/label[2]");
    }

    public SelenideElement contactPhoneDigits() {
        return $("a[class^='ContactInfo']");
    }

    public SelenideElement upworkLink() {
        return $x("/html/body/div[1]/div/div[3]/div[9]/div/div/div/div/div[2]/div/a[1]/div");
    }

    public SelenideElement linkedinLink() {
        return $x("/html/body/div[1]/div/div[3]/div[9]/div/div/div/div/div[2]/div/a[2]/div");
    }

    public SelenideElement facebookLink() {
        return $x("/html/body/div[1]/div/div[3]/div[9]/div/div/div/div/div[2]/div/a[3]/div");
    }


}

