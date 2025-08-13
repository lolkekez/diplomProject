package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pages.CatalogPage;
import pages.MainPage;
import pages.components.modal.CityModalComponent;

public class FilterOnCatalogTest extends BaseTest{

    MainPage mainPage = new MainPage();
    CityModalComponent cityModalComponent = new CityModalComponent();
    CatalogPage catalogPage = new CatalogPage();

    @Test
    @DisplayName("Проверяем список выбора в фильтрах")
    void allFilterOptionsTest() {
        catalogPage.openCatalogPage()
                .buttonFilterBrandsClick()
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
