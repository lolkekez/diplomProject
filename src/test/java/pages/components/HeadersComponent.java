package pages.components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import io.qameta.allure.Step;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HeadersComponent {
    private static List<String> getExpectedHeadersSectionList() {
        return Arrays.asList("Обувь",
                "Одежда",
                "Аксессуары",
                "Новинки",
                "Хиты продаж",
                "Распродажа",
                "Новости");
    }

    private static List<String> getExpectedHeadersQAandProgramLoyalList() {
        return Arrays.asList("Частые вопросы",
                "Программа лояльности");
    }

    private final ElementsCollection actualHeadersSectionList = $$("div.header__bottom div.header__link"),
            actualHeadersFaqAndProgramLoyalList = $$("div.header__top div.header__link");

    private final SelenideElement cityHeader = $("div.header__location"),
            mobileNumberOnHeader = $("a.header__phone"),
            searchHeaderButton = $$("div.header__icons div.global-icon").get(0),
            searchBlock = $("div.search-block__content"),
            searchInput = $("input.el-input__inner"),
            headerShoesButton = $$("label.el-radio-button").findBy(text("ОБУВЬ")),
            headerNews = $$("div.header__link").findBy(text("Новости"));

    @Step("Кликаем на хедер Новости")
    public HeadersComponent headerNewsClick() {
        headerNews.click();

        return this;
    }

    @Step("Проверяем наличие разделов в заголовках")
    public HeadersComponent checkHeadersSection() {
        actualHeadersSectionList.shouldHave(CollectionCondition.texts(getExpectedHeadersSectionList()));

        return this;
    }

    @Step("Нажимаем на заголовок 'Обувь'")
    public HeadersComponent headerShoesButtonClick() {
        headerShoesButton.click();

        return this;
    }

    @Step("Проверяем наличие кнопок faq и программы лояльности")
    public HeadersComponent checkFaqAndProgramLoyalOnHeader() {
        actualHeadersFaqAndProgramLoyalList.shouldHave(CollectionCondition.texts(getExpectedHeadersQAandProgramLoyalList()));

        return this;
    }

    @Step("Проверяем наличие города в заголовках")
    public HeadersComponent checkCityOnHeader() {
        cityHeader.shouldHave(text("Москва"));

        return this;
    }

    @Step("Проверяем наличие контактного номера на страница")
    public HeadersComponent checkMobileNumberOnHeader() {
        mobileNumberOnHeader.shouldHave(text("+7 (995) 568-50-58"));

        return this;
    }

    @Step("Жмем на кнопку поиска")
    public HeadersComponent searchHeaderButtonClick() {
        searchHeaderButton.click();

        return this;
    }

    @Step("Проверяем, что блока поиска отображается")
    public HeadersComponent checkSearchBlockShouldBeVisible() {
        searchBlock.shouldBe(visible);

        return this;
    }

    @Step("Вводим в поле поиска значение")
    public HeadersComponent insertValueOnSearchInput(String value) {
        searchInput.setValue(value).pressEnter();

        return this;
    }
}
