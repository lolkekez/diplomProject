package pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import utils.DataFaker;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {

    DataFaker faker = new DataFaker();

    private final SelenideElement approveCookieButton = $("div.modal button"),
            profileHeaderIconButton = $("div.header__icons").$("span.header__profile-icon"),
            favouritesHeaderIconButton = $("div.header__icons").$("div[data-v-7ced5273]"),
            showCatalogButton = $$("button[data-v-0f3c88d5]").find(text("ПОКАЗАТЬ ВСЕ НОВИНКИ")),
            tabNewItem = $$("label.el-radio-button").findBy(text("Новинки")),
            tabBestSellers = $$("label.el-radio-button").findBy(text("Хиты продаж")),
            tabSale =  $$("label.el-radio-button").findBy(text("Распродажа"));

    private final ElementsCollection labelsOnItemCard = $$("div.product-slider-grid__row div.status-block"),
            labelOnItemCardForSale = $$("div.card-catalog__content");


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
        open("/");

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

    @Step("Открываем таб 'Новинки'")
    public MainPage tabNewItemClick() {
        tabNewItem.click();

        return this;
    }

    @Step("Открываем таб 'Хиты продаж'")
    public MainPage tabBestSellersClick() {
        tabBestSellers.click();

        return this;
    }

    @Step("Открываем таб 'Скидки'")
    public MainPage tabSaleClick() {
        tabSale.click();

        return this;
    }

    @Step("Проверяем наличие лейбла 'Распродажа' на карточке товара")
    public MainPage checkLabelItemsWithSale() {
       labelOnItemCardForSale.get(0).shouldBe(visible, Duration.ofSeconds(5000)).shouldHave(text("Распродажа"));
        for (SelenideElement labelOnItem : labelsOnItemCard) {
            labelOnItem.shouldHave(text("Распродажа"));
        }

        return this;
    }

    @Step("Проверяем наличие лейбла 'Хит-продаж' на карточке товара")
    public MainPage checkLabelItemsWithBestSellers() {
        labelsOnItemCard.get(0).shouldBe(visible, Duration.ofSeconds(5000)).shouldHave(text("Хит-продаж"));
        for (SelenideElement labelOnItem : labelsOnItemCard) {
            labelOnItem.shouldHave(text("Хит-продаж"));
        }

        return this;
    }

    @Step("Проверяем наличие лейбла 'Новинка' на карточке товара")
    public MainPage checkLabelItemsWithNewItem() {
        labelsOnItemCard.get(0).shouldBe(visible, Duration.ofSeconds(5000)).shouldHave(text("Новинка"));
        for (SelenideElement labelOnItem : labelsOnItemCard) {
            labelOnItem.shouldHave(text("Новинка"));
        }

        return this;
    }
}
