package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CartPage;
import pages.CatalogPage;
import pages.MainPage;
import pages.components.modal.AuthorizationModalComponent;
import pages.components.modal.CityModalComponent;
import pages.components.modal.HeadersCopmonent;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ShoppingCartTests extends BaseTest {

    MainPage mainPage = new MainPage();
    CatalogPage catalogPage = new CatalogPage();
    AuthorizationModalComponent authorizationModalComponent = new AuthorizationModalComponent();
    CityModalComponent cityModalComponent = new CityModalComponent();
    CartPage cartPage = new CartPage();
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

    @Tag("Cart")
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

        headersCopmonent.headerShoesButtonClick();

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

        if (isAuthorized) {
            mainPage.profileIconButtonClick();

            authorizationModalComponent.setInputProfileModalEmail("4ybt2@somoj.com")
                    .setInputProfileModalPassword("Warcraft_Goblin331")
                    .loginConfirmButtonClick();
        }

        mainPage.showCatalogButtonClick();

        headersCopmonent.headerShoesButtonClick();

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