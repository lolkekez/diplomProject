package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.components.CityModalComponent;
import pages.components.HeadersCopmonents;

import static com.codeborne.selenide.Selenide.executeJavaScript;

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

    @AfterEach
    void clearSessionStorage() {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        executeJavaScript("window.localStorage.clear(); window.sessionStorage.clear();");
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
