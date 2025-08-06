package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CartPage {

    private final SelenideElement cartDetails = $("div.card-cart"),
            deleteCartButton = $("button.card-cart__delete");

    @Step("Проверяем, что в корзине есть товар")
    public CartPage cartDetailsVisible() {
        cartDetails.shouldBe(visible);

        return this;
    }

    @Step("Удаляем товар из корзины")
    public CartPage cartDetailsDelete() {
        deleteCartButton.click();

        return this;
    }
}
