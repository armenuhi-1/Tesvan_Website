package POM;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class BlogPOM {

    public BlogPOM open() {
        Selenide.open("https://www.tesvan.com/en/blog/salesforce-based-applications");
        return this;
    }

    public SelenideElement contactModal() {
        return $("#__next > div.ContactModal_overlay__qoYke");
    }

    public SelenideElement contactModalCloseBtn() {
        return $("div.ContactModal_close__KCzRf");
    }

    public SelenideElement shareContainer() {
        return $("div[class$='uSaiw']");
    }

    public SelenideElement shareFacebookItem() {
        return $("span[class='Share_fb__SxBa_']");
    }

    public SelenideElement shareLinkedinItem() {
        return $("span[class*='linkedin']");
    }

    public SelenideElement severalProjectsURL() {
        return $x("//a[@href='https://tesvan.com/en/cases']");
    }

    public SelenideElement contentItem() {
        return $x("//li[contains(@class, 'd')]");
    }

    public SelenideElement blogHeader() {
        return $("#Our\\ Experience\\ Testing\\ Salesforce-based\\ Applications");
    }

}

