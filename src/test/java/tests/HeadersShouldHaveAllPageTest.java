package tests;

import org.junit.jupiter.api.*;
import pages.CartPage;
import pages.MainPage;
import pages.components.modal.CityModalComponent;
import pages.components.HeadersComponent;

import static io.qameta.allure.Allure.step;

public class HeadersShouldHaveAllPageTest extends BaseTest {

    MainPage mainPage = new MainPage();
    CityModalComponent cityModalComponent = new CityModalComponent();
    HeadersComponent headersComponent = new HeadersComponent();
    CartPage cartPage = new CartPage();

    @Test
    @DisplayName("Отображение заголовков на всех страницах")
    void displayingHeadingsOnAllPagesTest() {

        step("Проверяем заголовки на главное странице", () -> {
            headersComponent.checkHeadersSection()
                    .checkFaqAndProgramLoyalOnHeader()
                    .checkCityOnHeader()
                    .checkMobileNumberOnHeader();
        });

        step("Проверяем заголовки на странице корзины", () -> {
            cartPage.openCartPage();
            headersComponent.checkHeadersSection()
                    .checkFaqAndProgramLoyalOnHeader()
                    .checkCityOnHeader()
                    .checkMobileNumberOnHeader();
        });

        step("Проверяем заголовки на странице каталога", () -> {
            catalogPage.openCatalogPage();
            headersComponent.checkHeadersSection()
                    .checkFaqAndProgramLoyalOnHeader()
                    .checkCityOnHeader()
                    .checkMobileNumberOnHeader();
        });

        step("Проверяем заголовки на странице новости", () -> {
            headersComponent.headerNewsClick()
                    .checkHeadersSection()
                    .checkFaqAndProgramLoyalOnHeader()
                    .checkCityOnHeader()
                    .checkMobileNumberOnHeader();
        });
    }

}
