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
            mobileNumberOnHeader = $("a.header__phone");


    @Step("Проверяем наличие разделов в заголовках")
    public HeadersCopmonents checkHeadersSection() {
        actualHeadersSectionList.shouldBe(CollectionCondition.texts(getExpectedHeadersSectionList()));

        return this;
    }

    @Step("Проверяем наличие кнопок faq и программы лояльности")
    public HeadersCopmonents checkFaqAndProgramLoyalOnHeader() {
        actualHeadersFaqAndProgramLoyalList.shouldBe(CollectionCondition.texts(getExpectedHeadersQAandProgramLoyalList()));

        return this;
    }

    @Step("Проверяем наличие города в заголовках")
    public HeadersCopmonents checkCityOnHeader() {
        cityHeader.shouldBe(text("Москва"));

        return this;
    }

    @Step("Проверяем наличие контактного номера на страница")
    public HeadersCopmonents checkMobileNumberOnHeader() {
        mobileNumberOnHeader.shouldBe(text("+7 (995) 568-50-58"));

        return this;
    }
}
