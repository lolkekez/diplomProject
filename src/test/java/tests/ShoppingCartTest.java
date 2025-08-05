package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CatalogPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static io.qameta.allure.Allure.step;

public class ShoppingCartTest extends BaseTest {

    MainPage mainPage = new MainPage();
    CatalogPage catalogPage = new CatalogPage();

    @BeforeEach
    void prepareData() {
        mainPage.openMainPage()
                .approveCookieButtonClick()
                .modalLocationButtonOtherClick()
                .selectCityButtonClick();
    }


    @ParameterizedTest(name = "addItemOnShoppingCartAuthorization{0}Test")
    @ValueSource(booleans = {true, false})
    void addItemOnShoppingCarTest(boolean isAuthorized) {
        if (isAuthorized) {
            mainPage.profileIconButtonClick()
                    .setInputProfileEmail("4ybt2@somoj.com")
                    .setInputProfilePassword("Warcraft_Goblin331")
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

    }
}

/*
    @Test
    void deleteItemOnCartShoppingCartWithAuthorizationTest() {
        mainPage.profileIconButtonClick()
                .setInputProfileEmail("4ybt2@somoj.com")
                .setInputProfilePassword("Warcraft_Goblin331")
                .loginConfirmButtonClick()
                .showCatalogButtonClick();

        catalogPage.headerShoesButtonClick()
                .firstItemOnCatalogClick()
                .checkAddCartButtonDisabled()
                .firstSizeClick()
                .addCartButtonClick()
                .checkSuccessAddItemOnCartMessage()
                .checkNumberItemsInCartBadge();
    }

}
*/