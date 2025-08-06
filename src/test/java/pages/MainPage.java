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
            profileHeaderIconButton = $("div.header__icons").$("span.header__profile-icon"),
            favouritesHeaderIconButton = $("div.header__icons").$("div[data-v-7ced5273]"),
            showCatalogButton = $$("button[data-v-0f3c88d5]").find(text("ПОКАЗАТЬ ВСЕ НОВИНКИ"));

    private final String randomEmail = faker.getRandomEmail(),
            randomPassword = faker.getRandomPassword(),
            randomLine = faker.getRandomLine();

    @Step("Нажимаем на кнопку подтвердить Cookie")
    public MainPage approveCookieButtonClick() {
        approveCookieButton.click();

        return this;
    }

    @Step("Жмем на кнопку профиля в заголовке")
    public MainPage profileIconButtonClick() {
        profileHeaderIconButton.click();

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

    @Step("Жму на кнопку показать все новинки")
    public MainPage showCatalogButtonClick() {
        showCatalogButton.click();

        return this;
    }












}
