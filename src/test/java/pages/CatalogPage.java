package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Cat;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {

    private final SelenideElement headerShoesButton = $$("label.el-radio-button").findBy(text("ОБУВЬ")),
            addCartButton = $("button[data-v-0f3c88d5]"),
            successAddItemOnCartMessage = $("div.el-message--success"),
            cartShoppingHeader = $("div.el-badge").$("div.global-icon"),
            numberItemsInCartBadge = $("div.el-badge"),
            searchInputFilter = $("input[placeholder='Ищи здесь']"),
            minusItemButton = $$("button.card-cart__button").findBy(text("-")),
            headersCartEmpty = $$("div.title").findBy(text("Корзина пуста"));

    private final ElementsCollection itemsOnCatalog = $$("div.card-search"),
            sizes = $$("div.el-radio-group .el-radio-button");

    @Step("Нажимаем на заголовок 'Обувь'")
    public CatalogPage headerShoesButtonClick() {
        headerShoesButton.click();

        return this;
    }

    @Step("Нажимаем на первый товар из каталога")
    public CatalogPage firstItemOnCatalogClick() {
        itemsOnCatalog.shouldHave(CollectionCondition.sizeGreaterThan(0));
        itemsOnCatalog.first().click();

        return this;
    }

    @Step("Выбираем первый размер товара")
    public CatalogPage firstSizeClick() {
        sizes.shouldHave(CollectionCondition.sizeGreaterThan(0));
        sizes.first().click();

        return this;
    }

    @Step("Проверем, что кнопка 'добавить в корзину' некликабельна")
    public CatalogPage checkAddCartButtonDisabled() {
        addCartButton.shouldBe(disabled);

        return this;
    }

    @Step("Нажимаем на кнопку 'Добавить в корзину'")
    public CatalogPage addCartButtonClick() {
        addCartButton.click();

        return this;
    }

    @Step("Проверяем, что появилось сообщение о добавлении товара в корзину")
    public CatalogPage checkSuccessAddItemOnCartMessage() {
        successAddItemOnCartMessage.shouldBe(visible);
        successAddItemOnCartMessage.shouldBe(text("Товар добавлен в корзину"));

        return this;
    }

    @Step("Проверяем, что появилось отображается нужное кол-во товара в корзине")
    public CatalogPage checkNumberItemsInCartBadge() {
        numberItemsInCartBadge.shouldHave(text("1"));

        return this;
    }

    @Step("Нажимаем на кнопку корзина в заголовке")
    public CatalogPage cartShoppingHeadersClick() {
        cartShoppingHeader.click();

        return this;
    }

    @Step("Проверяем, что в фильтре введено значение из первого поиска")
    public CatalogPage checkValueOnSearchInput(String query) {
        searchInputFilter.shouldBe(visible, Duration.ofSeconds(5)).shouldHave(value(query));

        return this;
    }

    @Step("Проверяем, что в каталоге отображаются товары введенные в поиске")
    public CatalogPage checkSearchFindEnteredValue(String query) {
        itemsOnCatalog.forEach(title -> title.shouldHave(text(query)));

        return this;
    }

}
