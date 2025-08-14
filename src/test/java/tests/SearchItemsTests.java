package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CatalogPage;
import pages.MainPage;
import pages.components.HeadersComponent;

public class SearchItemsTests extends BaseTest {
    MainPage mainPage = new MainPage();
    HeadersComponent headersComponent = new HeadersComponent();
    CatalogPage catalogPage = new CatalogPage();

    @ParameterizedTest(name = "Поиск товара по запросу")
    @ValueSource(strings = {"Кроссовки", "Футболка", "Ремень"})
    void searchProductByQueryTest(String query) {
        mainPage.openMainPage();
        headersComponent.searchHeaderButtonClick()
                .checkSearchBlockShouldBeVisible()
                .insertValueOnSearchInput(query);
        catalogPage.checkValueOnSearchInput(query)
                .checkSearchFindEnteredValue(query);
    }

    @Test
    @DisplayName("Отображение заглушки при вводе несуществующего продукта")
    void displayingStubWhenEnteringNonExistentProductTest() {
        catalogPage.openCatalogPage()
                .setValueRandomLineOnSearchInput()
                .checkShouldBeVisibleStub();
    }
}
