package tests;

import com.codeborne.selenide.WebDriverRunner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.CatalogPage;
import pages.MainPage;
import pages.components.CityModalComponent;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FilterOnCatalogTest extends BaseTest{

    MainPage mainPage = new MainPage();
    CityModalComponent cityModalComponent = new CityModalComponent();
    CatalogPage catalogPage = new CatalogPage();

    @BeforeEach
    void prepareData() {
        catalogPage.openPage();
        mainPage.approveCookieButtonClick();
        cityModalComponent.modalLocationButtonOtherClick()
                .selectCityButtonClick();
    }

    @AfterEach
    void clearSessionStorage() {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        executeJavaScript("window.localStorage.clear(); window.sessionStorage.clear();");
    }

    @Test
    void filterBrandsOptionsTest() {
        catalogPage.buttonFilterBrandsClick()
                .checkListBrandsOnFilter();

    }

    @Test
    void filterCategoryOptionsTest() {
        catalogPage.buttonFilterCategoryClick()
                .checkListCategoryOnFilter();

    }

    @Test
    void filterSizeOptionsTest() {
        catalogPage.buttonFilterSizeClick()
                .checkListSizeOnFilter();

    }
}
