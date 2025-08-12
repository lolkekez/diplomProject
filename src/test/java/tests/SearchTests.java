package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CatalogPage;
import pages.MainPage;
import pages.components.CityModalComponent;
import pages.components.HeadersCopmonents;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.*;

public class SearchTests extends BaseTest {
    MainPage mainPage = new MainPage();
    CityModalComponent cityModalComponent = new CityModalComponent();
    HeadersCopmonents headersCopmonents = new HeadersCopmonents();
    CatalogPage catalogPage = new CatalogPage();

    @BeforeEach
    void prepareData() {
        mainPage.openMainPage();
        mainPage.approveCookieButtonClick();
        cityModalComponent.modalLocationButtonOtherClick()
                .selectCityButtonClick();
    }

    @AfterEach
    void clearSessionStorage() {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        executeJavaScript("window.localStorage.clear(); window.sessionStorage.clear();");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Футболка", "Кроссовки"})
    void searchTest(String query) {
        headersCopmonents.searchHeaderButtonClick()
                .checkSearchBlockShouldBeVisible()
                .insertValueOnSearchInput(query);

        catalogPage.checkValueOnSearchInput(query)
                .checkSearchFindEnteredValue(query);

    }
}
