package POM;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CareersPOM {

    public CareersPOM open() {
        Selenide.open("https://www.tesvan.com/en/company/careers/sales_specialist?sent=success");
        return this;
    }

    public SelenideElement contactModal() {
        return $("#__next > div.ContactModal_overlay__qoYke");
    }

    public SelenideElement contactModalCloseBtn() {
        return $("div.ContactModal_close__KCzRf");
    }

    public SelenideElement applyNowBlock(){
        return $("div[class='Form_container__JGl78']");
    }


    public SelenideElement fullNameField() {
        return $x("/html/body/div[1]/div[6]/div/div/div/div[2]/div[2]/form/div[1]/label[2]/div/input");
    }

    public SelenideElement emailField() {
        return $("div.Form_formContainer__15aXe > form > div:nth-child(2) > label:nth-child(2) > div > input");
    }

    public SelenideElement phoneNumberField() {
        return $x("/html/body/div[1]/div[6]/div/div/div/div[2]/div[2]/form/div[3]/label[2]/div/input");
    }

    public SelenideElement coverLetterField() {
        return $x("//textarea");
    }

    public SelenideElement attachCVField() {
        return $("#actual-btn");
    }

    public SelenideElement checkbox() {
        return $("input[class^='Checkbox']");
    }

    public SelenideElement applyBtn() {
        return $("button[class*='OdALW']");
    }

    public SelenideElement responseMessage() {
        return $x("//*[@id=\"__next\"]/div[6]/div/div/div/div[2]/div[3]");
    }

    public SelenideElement nameInputError(){
        return $("div.Form_formContainer__15aXe > form > div:nth-child(1) > label:nth-child(2) > div > p");
    }

    public SelenideElement emailInputError(){
        return $("div:nth-of-type(2) > label:nth-of-type(2) > div > p");
    }

    public SelenideElement phoneInputError(){
        return $("div.Form_formContainer__15aXe > form > div:nth-child(3) > label:nth-child(2) > div > p");
    }

}

