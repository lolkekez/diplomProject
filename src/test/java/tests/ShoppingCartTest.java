package tests;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CartPage;
import pages.CatalogPage;
import pages.MainPage;
import pages.components.AuthorizationModalComponent;
import pages.components.CityModalComponent;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static io.qameta.allure.Allure.step;

public class ShoppingCartTest extends BaseTest {

    MainPage mainPage = new MainPage();
    CatalogPage catalogPage = new CatalogPage();
    AuthorizationModalComponent authorizationModalComponent = new AuthorizationModalComponent();
    CityModalComponent cityModalComponent = new CityModalComponent();
    CartPage cartPage = new CartPage();

    @BeforeEach
    void prepareData() {
        mainPage.openMainPage()
                .approveCookieButtonClick();
        cityModalComponent.modalLocationButtonOtherClick()
                        .selectCityButtonClick();
    }


    @ParameterizedTest(name = "addItemOnShoppingCartAuthorization{0}Test")
    @ValueSource(booleans = {true, false})
    void addItemOnShoppingCarTest(boolean isAuthorized) {

        if (isAuthorized) {
            mainPage.profileIconButtonClick();

            authorizationModalComponent.setInputProfileModalEmail("4ybt2@somoj.com")
                    .setInputProfileModalPassword("Warcraft_Goblin331")
                    .loginConfirmButtonClick();
        }

        mainPage.showCatalogButtonClick();

        catalogPage.headerShoesButtonClick()
                .firstItemOnCatalogClick()
                .checkAddCartButtonDisabled()
                .firstSizeClick()
                .addCartButtonClick()
                .checkSuccessAddItemOnCartMessage()
                .checkNumberItemsInCartBadge();

        cartPage.cartDetailsVisible();
    }


    @ParameterizedTest(name = "addItemOnShoppingCartAuthorization{0}Test")
    @ValueSource(booleans = {true, false})
    void deleteItemOnShoppingCarTest(boolean isAuthorized) {

        if (isAuthorized) {
            mainPage.profileIconButtonClick();

            authorizationModalComponent.setInputProfileModalEmail("4ybt2@somoj.com")
                    .setInputProfileModalPassword("Warcraft_Goblin331")
                    .loginConfirmButtonClick();
        }

        mainPage.showCatalogButtonClick();

        catalogPage.headerShoesButtonClick()
                .firstItemOnCatalogClick()
                .checkAddCartButtonDisabled()
                .firstSizeClick()
                .addCartButtonClick()
                .checkSuccessAddItemOnCartMessage()
                .checkNumberItemsInCartBadge()
                .cartShoppingHeadersClick();

        cartPage.cartDetailsVisible();
    }
}