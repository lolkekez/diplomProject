package tests;

import org.junit.jupiter.api.*;
import pages.MainPage;

public class MainPageTests extends BaseTest {
    MainPage mainPage = new MainPage();

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
