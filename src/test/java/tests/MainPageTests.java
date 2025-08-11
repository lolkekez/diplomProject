package tests;

import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.components.CityModalComponent;
import pages.components.HeadersCopmonents;

public class MainPageTests extends BaseTest {

    MainPage mainPage = new MainPage();
    CityModalComponent cityModalComponent = new CityModalComponent();
    HeadersCopmonents headersCopmonents = new HeadersCopmonents();

    @BeforeEach
    void prepareData() {
        mainPage.openMainPage()
                .approveCookieButtonClick();
        cityModalComponent.modalLocationButtonOtherClick()
                .selectCityButtonClick();
    }

    @Test
    @DisplayName("Проверяем наличие заголовков на странице")
    void headersMainPageCheckWithComponentsTest() {
        headersCopmonents.checkHeadersSection()
                .checkFaqAndProgramLoyalOnHeader()
                .checkCityOnHeader()
                .checkMobileNumberOnHeader();
    }

}
