package pages;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utils.DataFaker;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatalogPage {

    private final SelenideElement headerShoesButton = $$("label.el-radio-button").findBy(text("ОБУВЬ")),
            addCartButton = $("button[data-v-0f3c88d5]"),
            successAddItemOnCartMessage = $("div.el-message--success"),
            numberItemsInCartBadge = $("div.el-badge");

    private final ElementsCollection itemsOnCatalog = $$("div.card-search"),
            sizes = $$("div.el-radio-group .el-radio-button");

    @Step("Нажимаем на заголовок 'Обувь'")
    public CatalogPage headerShoesButtonClick() {
        headerShoesButton.click();

        return this;
    }

    @Step("Нажимаем на первый товар из каталога")
    public CatalogPage firstItemOnCatalogClick() {
        itemsOnCatalog.shouldBe(CollectionCondition.sizeGreaterThan(0));
        itemsOnCatalog.first().click();

        return this;
    }

    @Step("Выбираем первый размер товара")
    public CatalogPage firstSizeClick() {
        sizes.shouldBe(CollectionCondition.sizeGreaterThan(0));
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
        numberItemsInCartBadge.shouldBe(text("1"));

        return this;
    }

}
