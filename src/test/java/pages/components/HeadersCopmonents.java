package pages.components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import io.qameta.allure.Step;
import pages.CatalogPage;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HeadersCopmonents {

    public static List<String> getExpectedHeadersSectionList() {
        return Arrays.asList("Обувь",
                "Одежда",
                "Аксессуары",
                "Новинки",
                "Хиты продаж",
                "Распродажа",
                "Новости");
    }

    public static List<String> getExpectedHeadersQAandProgramLoyalList() {
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
            headerShoesButton = $$("label.el-radio-button").findBy(text("ОБУВЬ"));


    @Step("Проверяем наличие разделов в заголовках")
    public HeadersCopmonents checkHeadersSection() {
        actualHeadersSectionList.shouldHave(CollectionCondition.texts(getExpectedHeadersSectionList()));

        return this;
    }

    @Step("Нажимаем на заголовок 'Обувь'")
    public HeadersCopmonents headerShoesButtonClick() {
        headerShoesButton.click();

        return this;
    }

    @Step("Проверяем наличие кнопок faq и программы лояльности")
    public HeadersCopmonents checkFaqAndProgramLoyalOnHeader() {
        actualHeadersFaqAndProgramLoyalList.shouldHave(CollectionCondition.texts(getExpectedHeadersQAandProgramLoyalList()));

        return this;
    }

    @Step("Проверяем наличие города в заголовках")
    public HeadersCopmonents checkCityOnHeader() {
        cityHeader.shouldHave(text("Москва"));

        return this;
    }

    @Step("Проверяем наличие контактного номера на страница")
    public HeadersCopmonents checkMobileNumberOnHeader() {
        mobileNumberOnHeader.shouldHave(text("+7 (995) 568-50-58"));

        return this;
    }

    @Step("Жмем на кнопку поиска")
    public HeadersCopmonents searchHeaderButtonClick() {
        searchHeaderButton.click();

        return this;
    }

    @Step("Проверяем наличие блока поиска")
    public HeadersCopmonents checkSearchBlockShouldBeVisible() {
        searchBlock.shouldBe(visible);

        return this;
    }

    @Step("Вводим в поле поиска значение")
    public HeadersCopmonents insertValueOnSearchInput(String value) {
        searchInput.setValue(value).pressEnter();

        return this;
    }


}
