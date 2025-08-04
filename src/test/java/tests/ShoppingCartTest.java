package tests;

import org.junit.jupiter.api.*;
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

    @Test
    void addItemOnShoppingCartWithAuthorizationTest() {
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
