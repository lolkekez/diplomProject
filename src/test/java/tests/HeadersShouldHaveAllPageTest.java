package tests;

import org.junit.jupiter.api.*;
import pages.CartPage;
import pages.MainPage;
import pages.components.modal.CityModalComponent;
import pages.components.HeadersCopmonent;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class HeadersShouldHaveAllPageTest extends BaseTest {

    MainPage mainPage = new MainPage();
    CityModalComponent cityModalComponent = new CityModalComponent();
    HeadersCopmonent headersCopmonent = new HeadersCopmonent();
    CartPage cartPage = new CartPage();

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
            cartPage.openCartPage();
            headersCopmonent.checkHeadersSection()
                    .checkFaqAndProgramLoyalOnHeader()
                    .checkCityOnHeader()
                    .checkMobileNumberOnHeader();
        });

        step("Проверяем заголовки на странице каталога", () -> {
            catalogPage.openCatalogPage();
            headersCopmonent.checkHeadersSection()
                    .checkFaqAndProgramLoyalOnHeader()
                    .checkCityOnHeader()
                    .checkMobileNumberOnHeader();
        });

        step("Проверяем заголовки на странице новости", () -> {
            headersCopmonent.headerNewsClick()
                    .checkHeadersSection()
                    .checkFaqAndProgramLoyalOnHeader()
                    .checkCityOnHeader()
                    .checkMobileNumberOnHeader();
        });
    }

}
