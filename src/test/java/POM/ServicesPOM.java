package POM;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ServicesPOM {

    public ServicesPOM open() {
        Selenide.open("https://www.tesvan.com/en/services");
        return this;
    }

    public SelenideElement contactModal() {
        return $("#__next > div.ContactModal_overlay__qoYke");
    }

    public SelenideElement contactModalCloseBtn() {
        return $("div.ContactModal_close__KCzRf");
    }


    public SelenideElement header() {
        return $("#header > h1");
    }

    public SelenideElement pageTitle() {
        return $("#header > h1 > span:nth-child(1)");
    }

    public SelenideElement headerBtn() {
        return $("#headerButton");
    }

    public SelenideElement movableMenuContainer() {
        return $("#Functional\\ Testing");
    }

    public ElementsCollection movableMenuContent() {
        return $$("div[class='Card_card__AvT0A MovableMenu_content__dlfNf']");
    }

    public SelenideElement functionalTestingItem() {
        return $(".MovableMenu_move__DSgZ1 div:nth-child(2)");
    }

    public SelenideElement functionalTestingContainer() {
        return $("div[id^='Functional']");
    }

    public SelenideElement functionalTesting() {
        return $x("/html/body/div[1]/div[6]/div/div/div/div[1]/div[1]/ul/div[1]/li[1]/a");
    }

    public SelenideElement backToServicesBtn() {
        return $x("/html/body/div[1]/div[4]/div/div/div/a[2]");
    }
}

