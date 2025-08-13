package tests;

import com.codeborne.selenide.WebDriverRunner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pages.CatalogPage;
import pages.MainPage;
import pages.components.modal.CityModalComponent;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FilterOnCatalogTest extends BaseTest{

    MainPage mainPage = new MainPage();
    CityModalComponent cityModalComponent = new CityModalComponent();
    CatalogPage catalogPage = new CatalogPage();

    @Test
    @DisplayName("Проверяем список выбора в фильтрах")
    void allFilterOptionsTest() {
        catalogPage.buttonFilterBrandsClick()
                .checkListBrandsOnFilter()
                .buttonFilterSizeClick()
                .checkListSizeOnFilter()
                .buttonFilterCategoryClick()
                .checkListCategoryOnFilter()
                .buttonFilterSeasonClick()
                .checkListSeasonOnFilter()
                .buttonFilterShopClick()
                .checkListShopOnFilter()
                .buttonFilterColorClick()
                .checkListColorOnFilter();
    }
}
