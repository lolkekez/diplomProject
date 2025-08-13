package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CatalogPage;
import pages.MainPage;
import pages.components.modal.CityModalComponent;
import pages.components.modal.HeadersCopmonent;

import static com.codeborne.selenide.Selenide.*;

public class SearchItemsTests extends BaseTest {
    MainPage mainPage = new MainPage();
    CityModalComponent cityModalComponent = new CityModalComponent();
    HeadersCopmonent headersCopmonent = new HeadersCopmonent();
    CatalogPage catalogPage = new CatalogPage();

    @ParameterizedTest
    @ValueSource(strings = {"Кроссовки", "Футболка", "Ремень"})
    void searchTest(String query) {
        mainPage.openMainPage();
        headersCopmonent.searchHeaderButtonClick()
                .checkSearchBlockShouldBeVisible()
                .insertValueOnSearchInput(query);

        catalogPage.checkValueOnSearchInput(query)
                .checkSearchFindEnteredValue(query);
    }
}
