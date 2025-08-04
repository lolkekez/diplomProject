package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utils.DataFaker;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {

    DataFaker faker = new DataFaker();

    private final SelenideElement approveCookieButton = $("div.modal button"),
            locationOtherModalButton = $("div.location__button-other"),
            selectCityModalButton = $$("div.city__city-item").find(text("Москва")),
            profileHeaderIconButton = $("div.header__icons").$("span.header__profile-icon"),
            inputProfileEmail = $$("input.el-input__inner").get(0),
            inputProfilePassword = $$("input.el-input__inner").get(1),
            loginConfirmButton = $("div.login__action-block button"),
            favouritesHeaderIconButton = $("div.header__icons").$("div[data-v-7ced5273]"),
            uncorrectedEmailModalText = $$("div.el-form-item__error").get(0),
            uncorrectedPasswordModalText = $$("div.el-form-item__error").get(1),
            failedAuthorizationMessage = $("div.el-message--error"),
            showCatalogButton = $$("button[data-v-0f3c88d5]").find(text("ПОКАЗАТЬ ВСЕ НОВИНКИ"));

    private final String randomEmail = faker.getRandomEmail(),
            randomPassword = faker.getRandomPassword(),
            randomLine = faker.getRandomLine();

    @Step("Нажимаем на кнопку подтвердить Cookie")
    public MainPage approveCookieButtonClick() {
        approveCookieButton.click();

        return this;
    }

    @Step("В модальном окне локации жмем на кнопку 'Другой город'")
    public MainPage modalLocationButtonOtherClick() {
        locationOtherModalButton.click();

        return this;
    }

    @Step("Выбираем город Москва")
    public MainPage selectCityButtonClick() {
        selectCityModalButton.click();

        return this;
    }

    @Step("Жмем на кнопку профиля в заголовке")
    public MainPage profileIconButtonClick() {
        profileHeaderIconButton.click();

        return this;
    }

    @Step("В модальном окне авторизации вводим email")
    public MainPage setInputProfileEmail(String value) {
        inputProfileEmail.setValue(value);

        return this;
    }

    @Step("В модальном окне авторизации вводим password")
    public MainPage setInputProfilePassword(String value) {
        inputProfilePassword.setValue(value);

        return this;
    }

    @Step("В модальном окне авторизации жмем на кнопку 'Подтвердить'")
    public MainPage loginConfirmButtonClick() {
        loginConfirmButton.click();

        return this;
    }

    @Step("Жмем на кнопку избранное в заголовке")
    public MainPage favouritesHeaderIconButtonClick() {
        favouritesHeaderIconButton.click();

        return this;
    }

    @Step("Открываем главную страницу")
    public MainPage openMainPage() {
        open("");

        return this;
    }

    @Step("В модальном окне авторизации вводим некорректный password")
    public MainPage setUncorrectedInputProfilePassword() {
        inputProfilePassword.setValue(randomLine);
        inputProfilePassword.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);

        return this;
    }

    @Step("В модальном окне авторизации вводим некорректный email")
    public MainPage setUncorrectedInputProfileEmail() {
        inputProfileEmail.setValue(randomLine);

        return this;
    }

    @Step("В модальном окне авторизации вводим рандомный email")
    public MainPage setFailedInputProfileEmail() {
        inputProfileEmail.setValue(randomEmail);

        return this;
    }

    @Step("В модальном окне авторизации вводим рандомный password")
    public MainPage setFailedInputProfilePassword() {
        inputProfilePassword.setValue(randomPassword);

        return this;
    }

    @Step("Проверяем, что появился заголовок Избранное")
    public MainPage checkFavouritesHeaderIconVisible() {
        favouritesHeaderIconButton.shouldBe(visible);

        return this;
    }

    @Step("Проверяем что находимся на странице /profile")
    public MainPage checkRedirectionProfilePageAfterAuthorization() {
        profileHeaderIconButton.click();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("https://krosspark.ru/profile", currentUrl);

        return this;
    }

    @Step("Проверяем, что появилось сообщение 'Пожалуйста введите корректный email'")
    public MainPage checkEmailFieldShouldBeUncorrectedText() {
        uncorrectedEmailModalText.shouldBe(text("Пожалуйста введите корректный email"));

        return this;
    }

    @Step("Проверяем, что появилось сообщение 'Это поле обязательно для заполнения'")
    public MainPage checkPasswordFieldShouldBeUncorrectedText() {
        uncorrectedPasswordModalText.shouldBe(text("Это поле обязательно для заполнения"), Duration.ofSeconds(10));

        return this;
    }

    @Step("Проверяем, что в модальном окне кнопка 'Подтвердить' некликабельна")
    public MainPage checkLoginConfirmButtonDisabled() {
        loginConfirmButton.shouldBe(disabled);

        return this;
    }

    @Step("Проверяем, что появился message о неккоректном вводе данных")
    public MainPage checkFailedAuthorizationMessageVisible() {
        failedAuthorizationMessage.shouldBe(visible, Duration.ofSeconds(2));
        failedAuthorizationMessage.shouldBe(text("Неверные данные для входа"));

        return this;
    }

    @Step("Жму на кнопку показать все новинки")
    public MainPage showCatalogButtonClick() {
        showCatalogButton.click();

        return this;
    }












}
