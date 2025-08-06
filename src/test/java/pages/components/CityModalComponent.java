package pages.components;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import pages.MainPage;
import utils.DataFaker;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class CityModalComponent {

    MainPage mainPage = new MainPage();

    private final SelenideElement locationOtherModalButton = $("div.location__button-other"),
            selectCityModalButton = $$("div.city__city-item").find(text("Москва"));

    @Step("В модальном окне локации жмем на кнопку 'Другой город'")
    public CityModalComponent modalLocationButtonOtherClick() {
        locationOtherModalButton.click();

        return this;
    }

    @Step("Выбираем город Москва")
    public CityModalComponent selectCityButtonClick() {
        selectCityModalButton.click();

        return this;
    }

}
