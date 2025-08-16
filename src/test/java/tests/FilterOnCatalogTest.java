package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.CatalogPage;

public class FilterOnCatalogTest extends BaseTest{
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

    @ParameterizedTest(name = "Работа фильтра {0} с опцией {1}")
    @CsvSource({
            "Бренды, Balenciaga",
            "Категория, Джинсы",
            "Размеры, 39",
    })
    void shouldDisplayOnlySelectedFilter(String filter, String option) {
        catalogPage.openCatalogPage()
                .buttonFilterClick(filter)
                .selectOptionOnFilter(option)
                .checkResultSearchWithFilter(option);
    }
}
