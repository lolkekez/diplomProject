package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    public MainPage openPage() {
        open("ru/global");
        return this;
    }

    public MainPage clickHeaderFamilyTree() {
        $(".headerNavGroupStyle_h6qlbgz button").click();
        return this;
    }
}
