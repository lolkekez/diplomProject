package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.components.modal.CityModalComponent;
import pages.components.modal.HeadersCopmonent;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class HeadersShouldHaveAllPageTest extends BaseTest {

    MainPage mainPage = new MainPage();
    CityModalComponent cityModalComponent = new CityModalComponent();
    HeadersCopmonent headersCopmonent = new HeadersCopmonent();

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
    @DisplayName("Отображение заголовков на всех страницах")
    void displayingHeadingsOnAllPagesTest() {

        step("Проверяем заголовки на главное странице", () -> {
            headersCopmonent.checkHeadersSection()
                    .checkFaqAndProgramLoyalOnHeader()
                    .checkCityOnHeader()
                    .checkMobileNumberOnHeader();
        });

        step("Проверяем заголовки на странице корзины", () -> {
            open("/cart");
            headersCopmonent.checkHeadersSection()
                    .checkFaqAndProgramLoyalOnHeader()
                    .checkCityOnHeader()
                    .checkMobileNumberOnHeader();
        });

        step("Проверяем заголовки на странице каталога", () -> {
            open("/catalog");
            headersCopmonent.checkHeadersSection()
                    .checkFaqAndProgramLoyalOnHeader()
                    .checkCityOnHeader()
                    .checkMobileNumberOnHeader();
        });

        step("Проверяем заголовки на странице новости", () -> {
            open("/news");
            headersCopmonent.checkHeadersSection()
                    .checkFaqAndProgramLoyalOnHeader()
                    .checkCityOnHeader()
                    .checkMobileNumberOnHeader();
        });
    }

}
