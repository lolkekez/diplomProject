package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Cat;
import io.qameta.allure.Step;
import pages.components.filter.*;
import utils.DataFaker;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {
    DataFaker dataFaker = new DataFaker();

    private final SelenideElement addCartButton = $("button[data-v-0f3c88d5]"),
            successAddItemOnCartMessage = $("div.el-message--success"),
            cartShoppingHeader = $("div.el-badge").$("div.global-icon"),
            numberItemsInCartBadge = $("div.el-badge"),
            searchInputFilter = $("input[placeholder='Ищи здесь']"),
            buttonFilterBrands = $$("div.fixed-title").findBy(text("Бренды")),
            buttonFilterCategory = $$("div.fixed-title").findBy(text("Категория")),
            buttonFilterSize = $$("div.fixed-title").findBy(text("Размеры")),
            buttonFilterSeason = $$("div.fixed-title").findBy(text("Сезон")),
            buttonFilterShop = $$("div.fixed-title").findBy(text("Магазины")),
            buttonFilterColor = $$("div.fixed-title").findBy(text("Цвет")),
            imgStub = $("img[data-v-fd545783]"),
            textUnderStub = $("p.description");

    private final ElementsCollection itemsOnCatalog = $$("div.card-search"),
            sizes = $$("div.el-radio-group .el-radio-button"),
            listBrandsOnFilter = $$("div.content-container").get(0).$$("div"),
            listCategoryOnFilter = $$("div.content-container").get(1).$$("div"),
            listSizeOnFilter = $$("div.content-container").get(2).$$("div"),
            listSeasonOnFilter = $$("div.content-container").get(3).$$("div"),
            listShopOnFilter = $$("div.content-container").get(4).$$("div"),
            listColorOnFilter = $$("div.content-container").get(5).$$("div");

    @Step("Открываем страницу Каталога")
    public CatalogPage openCatalogPage() {
        open("/catalog");

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

    @Step("Вводим в поле поиска рандомную строку")
    public CatalogPage setValueRandomLineOnSearchInput() {
        searchInputFilter.setValue(dataFaker.getRandomLine());

        return this;
    }

    @Step("Проверяем отображение заглушки")
    public CatalogPage checkShouldBeVisibleStub() {
        imgStub.shouldBe(visible).shouldHave(attributeMatching("src", ".*assets/mascot-new-J1KLOXPA.webp$"));
        textUnderStub.shouldHave(text("К сожалению ничего не найдено, попробуйте очистить фильтры."));

        return this;
    }

    @Step("Проверяем, что в каталоге отображаются товары введенные в поиске")
    public CatalogPage checkSearchFindEnteredValue(String query) {
        itemsOnCatalog.get(0).shouldBe(visible);
        for (SelenideElement item : itemsOnCatalog) {
            item.shouldHave(text(query));
        }

        return this;
    }

    @Step("Жмем на кнопку Бренды в фильтрах")
    public CatalogPage buttonFilterBrandsClick() {
        buttonFilterBrands.click();

        return this;
    }

    @Step("Проверяем список брендов")
    public CatalogPage checkListBrandsOnFilter() {
        listBrandsOnFilter.shouldHave(CollectionCondition.containExactTextsCaseSensitive((BrandsFilterComponent.ALL)));

        return this;
    }

    @Step("Жмем на кнопку Категория в фильтрах")
    public CatalogPage buttonFilterCategoryClick() {
        buttonFilterCategory.click();

        return this;
    }

    @Step("Проверяем список категорий")
    public CatalogPage checkListCategoryOnFilter() {
        listCategoryOnFilter.shouldHave(CollectionCondition.containExactTextsCaseSensitive((CategoryFilterComponent.ALL)));

        return this;
    }

    @Step("Жмем на кнопку Размеры в фильтрах")
    public CatalogPage buttonFilterSizeClick() {
        buttonFilterSize.click();

        return this;
    }

    @Step("Проверяем список размеров")
    public CatalogPage checkListSizeOnFilter() {
        listSizeOnFilter.shouldHave(CollectionCondition.containExactTextsCaseSensitive((SizeFilterComponent.ALL)));

        return this;
    }

    @Step("Жмем на кнопку Сезон в фильтрах")
    public CatalogPage buttonFilterSeasonClick() {
        buttonFilterSeason.click();

        return this;
    }

    @Step("Проверяем список сезонов")
    public CatalogPage checkListSeasonOnFilter() {
        listSeasonOnFilter.shouldHave(CollectionCondition.containExactTextsCaseSensitive((SeasonFilterComponent.ALL)));

        return this;
    }

    @Step("Жмем на кнопку Магазин в фильтрах")
    public CatalogPage buttonFilterShopClick() {
        buttonFilterShop.click();

        return this;
    }

    @Step("Проверяем список Магазинов")
    public CatalogPage checkListShopOnFilter() {
        listShopOnFilter.shouldHave(CollectionCondition.containExactTextsCaseSensitive((ShopFilterComponent.ALL)));

        return this;
    }

    @Step("Жмем на кнопку Цвет в фильтрах")
    public CatalogPage buttonFilterColorClick() {
        buttonFilterColor.click();

        return this;
    }

    @Step("Проверяем список цветов")
    public CatalogPage checkListColorOnFilter() {
        listColorOnFilter.shouldHave(CollectionCondition.containExactTextsCaseSensitive((ColorFilterComponent.ALL)));

        return this;
    }
}
