package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement approveCookieButton = $("div.modal button"),
            locationOtherModalButton = $("div.location__button-other"),
            selectCityModalButton = $$("div.city__city-item").find(text("Москва")),
            profileIconButton = $("div.header__icons").$("span.header__profile-icon"),
            inputProfileEmail = $$("input.el-input__inner").get(0),
            inputPasswordEmail = $$("input.el-input__inner").get(1),
            loginConfirmButton = $("div.login__action-block");

    public MainPage approveCookieButtonClick() {
        approveCookieButton.click();

        return this;
    }

    public MainPage modalLocationButtonOtherClick() {
        locationOtherModalButton.click();

        return this;
    }

    public MainPage selectCityButtonClick() {
        selectCityModalButton.click();

        return this;
    }
    public MainPage profileIconButtonClick() {
        profileIconButton.click();

        return this;
    }

    public MainPage inputProfileEmailSet(String value) {
        inputProfileEmail.setValue(value);

        return this;
    }

    public MainPage inputProfilePasswordSet(String value) {
        inputPasswordEmail.setValue(value);

        return this;
    }

    public MainPage loginConfirmButtonClick() {
        loginConfirmButton.click();

        return this;
    }










}
