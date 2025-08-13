package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CartPage;
import pages.CatalogPage;
import pages.MainPage;
import pages.components.modal.AuthorizationModalComponent;
import pages.components.modal.CityModalComponent;
import pages.components.HeadersComponent;

public class ShoppingCartTests extends BaseTest {

    MainPage mainPage = new MainPage();
    CatalogPage catalogPage = new CatalogPage();
    AuthorizationModalComponent authorizationModalComponent = new AuthorizationModalComponent();
    CityModalComponent cityModalComponent = new CityModalComponent();
    CartPage cartPage = new CartPage();
    HeadersComponent headersComponent = new HeadersComponent();

    @Tag("Cart")
    @ParameterizedTest(name = "addItemOnShoppingCartAuthorization{0}Test")
    @ValueSource(booleans = {true, false})
    void addItemOnShoppingCarTest(boolean isAuthorized) {

        mainPage.openMainPage();

        if (isAuthorized) {
            mainPage.profileIconButtonClick();

            authorizationModalComponent.setInputProfileModalEmail("4ybt2@somoj.com")
                    .setInputProfileModalPassword("Warcraft_Goblin331")
                    .loginConfirmButtonClick();
        }

        mainPage.showCatalogButtonClick();
        headersComponent.headerShoesButtonClick();
        catalogPage.firstItemOnCatalogClick()
                .checkAddCartButtonDisabled()
                .firstSizeClick()
                .addCartButtonClick()
                .checkSuccessAddItemOnCartMessage()
                .checkNumberItemsInCartBadge()
                .cartShoppingHeadersClick();
        cartPage.cartDetailsVisible();
    }

    @Tag("Cart")
    @ParameterizedTest(name = "deleteItemOnShoppingCartAuthorization{0}Test")
    @ValueSource(booleans = {true, false})
    void deleteItemOnShoppingCarTest(boolean isAuthorized) {

        mainPage.openMainPage();

        if (isAuthorized) {
            mainPage.profileIconButtonClick();

            authorizationModalComponent.setInputProfileModalEmail("4ybt2@somoj.com")
                    .setInputProfileModalPassword("Warcraft_Goblin331")
                    .loginConfirmButtonClick();
        }

        mainPage.showCatalogButtonClick();
        headersComponent.headerShoesButtonClick();
        catalogPage.firstItemOnCatalogClick()
                .checkAddCartButtonDisabled()
                .firstSizeClick()
                .addCartButtonClick()
                .checkSuccessAddItemOnCartMessage()
                .checkNumberItemsInCartBadge()
                .cartShoppingHeadersClick();
        cartPage.cartDetailsVisible()
                .minusItemButtonClick()
                .checkCartIsEmpty();
    }
}