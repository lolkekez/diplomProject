package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.mifmif.common.regex.Main;
import groovy.lang.GString;
import org.openqa.selenium.Keys;
import utils.DataFaker;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {

    DataFaker faker = new DataFaker();

    private SelenideElement approveCookieButton = $("div.modal button"),
            locationOtherModalButton = $("div.location__button-other"),
            selectCityModalButton = $$("div.city__city-item").find(text("Москва")),
            profileHeaderIconButton = $("div.header__icons").$("span.header__profile-icon"),
            inputProfileEmail = $$("input.el-input__inner").get(0),
            inputProfilePassword = $$("input.el-input__inner").get(1),
            loginConfirmButton = $("div.login__action-block button"),
            favouritesHeaderIconButton = $("div.header__icons").$("div[data-v-7ced5273]"),
            uncorrectedEmailModalText = $$("div.el-form-item__error").get(0),
            uncorrectedPasswordModalText = $$("div.el-form-item__error").get(1),
            failedAuthorizationMessage = $("div.el-message--error");

    private String randomEmail = faker.getRandomEmail(),
            randomPassword = faker.getRandomPassword(),
            randomLine = faker.getRandomLine();

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
        profileHeaderIconButton.click();

        return this;
    }

    public MainPage setInputProfileEmail(String value) {
        inputProfileEmail.setValue(value);

        return this;
    }

    public MainPage setInputProfilePassword(String value) {
        inputProfilePassword.setValue(value);

        return this;
    }

    public MainPage loginConfirmButtonClick() {
        loginConfirmButton.click();

        return this;
    }

    public MainPage favouritesHeaderIconButtonClick() {
        favouritesHeaderIconButton.click();

        return this;
    }


    public MainPage openMainPage() {
        open("");

        return this;
    }


    public MainPage setUncorrectedInputProfilePassword() {
        inputProfilePassword.setValue(randomLine);
        inputProfilePassword.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);

        return this;
    }

    public MainPage setUncorrectedInputProfileEmail() {
        inputProfileEmail.setValue(randomLine);

        return this;
    }

    public MainPage setFailedInputProfileEmail() {
        inputProfileEmail.setValue(randomEmail);

        return this;
    }

    public MainPage setFailedInputProfilePassword() {
        inputProfilePassword.setValue(randomPassword);

        return this;
    }

    public MainPage checkFavouritesHeaderIconVisible() {
        favouritesHeaderIconButton.shouldBe(visible);

        return this;
    }

    public MainPage checkRedirectionProfilePageAfterAuthorization() {
        profileHeaderIconButton.click();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("https://krosspark.ru/profile", currentUrl);

        return this;
    }

    public MainPage checkEmailFieldShouldBeUncorrectedText() {
        uncorrectedEmailModalText.shouldBe(text("Пожалуйста введите корректный email"));

        return this;
    }

    public MainPage checkPasswordFieldShouldBeUncorrectedText() {
        uncorrectedPasswordModalText.shouldBe(text("Это поле обязательно для заполнения"), Duration.ofSeconds(10));

        return this;
    }

    public MainPage checkLoginConfirmButtonDisabled() {
        loginConfirmButton.shouldBe(disabled);

        return this;
    }

    public MainPage checkFailedAuthorizationMessageVisible() {
        failedAuthorizationMessage.shouldBe(visible, Duration.ofSeconds(2));
        failedAuthorizationMessage.shouldBe(text("Неверные данные для входа"));

        return this;
    }












}
