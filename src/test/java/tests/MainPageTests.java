package tests;

import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.components.modal.CityModalComponent;
import pages.components.HeadersCopmonent;

import static com.codeborne.selenide.Selenide.open;

public class MainPageTests extends BaseTest {

    MainPage mainPage = new MainPage();
    CityModalComponent cityModalComponent = new CityModalComponent();
    HeadersCopmonent headersCopmonent = new HeadersCopmonent();

    @Test
    @DisplayName("Отображение лейбла на карточке товара в зависимости от таба")
    void displayLabelOnProductCardDependingOnTabTest() {
        mainPage.tabNewItemClick()
                .checkLabelItemsWithNewItem()
                .tabSaleClick()
                .checkLabelItemsWithSale()
                .tabBestSellersClick()
                .checkLabelItemsWithBestSellers();
    }
}
