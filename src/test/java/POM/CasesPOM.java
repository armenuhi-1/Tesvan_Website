package POM;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CasesPOM {

    public CasesPOM open() {
        Selenide.open("https://www.tesvan.com/en/cases");
        return this;
    }

    public SelenideElement contactModal() {
        return $("#__next > div.ContactModal_overlay__qoYke");
    }

    public SelenideElement contactModalCloseBtn() {
        return $("div.ContactModal_close__KCzRf");
    }

    public ElementsCollection filterPartContainer() {
        return $$("div[class='FilterPart_container__H_rge']");
    }

    public SelenideElement managementFilter() {
        return $("#Management");
    }

    public SelenideElement allFilter() {
        return $("div[id='All']");
    }

    public ElementsCollection casesContainer() {
        return $$("div[class='Cases_container__NUqaC']");
    }

    public SelenideElement managementContainer() {
        return $("#casesContainer > div > div > div.Cases_container__NUqaC > div:nth-child(1) > div > img");
    }

    public SelenideElement managementContainerCaseTech() {
        return $("p.Case_tech__d6R7o.Case_tech_eng__fuRz_");
    }

    public SelenideElement managementCaseIndustry() {
        return $x("/html/body/div[1]/div[7]/div/div/div[1]/div[1]/div/div/p[2]");
    }

    public SelenideElement readMoreBtn() {
        return $x("/html/body/div[1]/div[7]/div/div/div[1]/div[1]/div/div/button");
    }

    public SelenideElement customertimesHeaderTitle() {
        return $("#header > h1");
    }

    public SelenideElement casesPagination() {
        return $("div[class='Cases_pagination__afV_k']");
    }

    public SelenideElement previousPage() {
        return $("div[class='Cases_prevDis__PRgBd']");
    }

    public SelenideElement nextPage() {
        return $("div[class*='next']");
    }

    public SelenideElement secondPage() {
        return $("#\\32");
    }

    public SelenideElement backToCasesBtn() {
        return $x("/html/body/div[1]/div[4]/div/div/div[2]/a[2]");
    }


}

