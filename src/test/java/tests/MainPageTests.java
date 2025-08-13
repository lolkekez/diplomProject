package tests;

import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.components.modal.CityModalComponent;
import pages.components.HeadersComponent;

import static com.codeborne.selenide.Selenide.open;

public class MainPageTests extends BaseTest {

    MainPage mainPage = new MainPage();
    CityModalComponent cityModalComponent = new CityModalComponent();
    HeadersComponent headersComponent = new HeadersComponent();

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
