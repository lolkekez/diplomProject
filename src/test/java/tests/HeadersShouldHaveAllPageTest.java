package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.components.CityModalComponent;
import pages.components.HeadersCopmonents;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class HeadersShouldHaveAllPageTest extends BaseTest {

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
    @DisplayName("Проверяем наличие заголовков на всех страницах")
    void headersMainPageCheckTest() {

        step("Проверяем заголовки на главное странице", () -> {
            headersCopmonents.checkHeadersSection()
                    .checkFaqAndProgramLoyalOnHeader()
                    .checkCityOnHeader()
                    .checkMobileNumberOnHeader();
        });

        step("Проверяем заголовки на странице корзины", () -> {
            open("/cart");
            headersCopmonents.checkHeadersSection()
                    .checkFaqAndProgramLoyalOnHeader()
                    .checkCityOnHeader()
                    .checkMobileNumberOnHeader();
        });

        step("Проверяем заголовки на странице каталога", () -> {
            open("/catalog");
            headersCopmonents.checkHeadersSection()
                    .checkFaqAndProgramLoyalOnHeader()
                    .checkCityOnHeader()
                    .checkMobileNumberOnHeader();
        });

        step("Проверяем заголовки на странице новости", () -> {
            open("/news");
            headersCopmonents.checkHeadersSection()
                    .checkFaqAndProgramLoyalOnHeader()
                    .checkCityOnHeader()
                    .checkMobileNumberOnHeader();
        });
    }

}
