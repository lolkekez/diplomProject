package tests;

import io.qameta.allure.Step;
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

    @Test
    @DisplayName("Отображение блока Новости на главное странице")
    void shouldDisplayNewsBlockTest() {
        mainPage.openMainPage()
                .checkHeaderNewsBlock()
                .newsItemsShouldBeVisible();
    }

    @Test
    @DisplayName("Отображение блока Доставка и оплата")
    void shouldDisplayDeliveryAndPaymentBlockTest() {
        mainPage.openMainPage()
                .checkHeaderDeliveryAndPaymentBlock()
                .checkDeliveryAndPaymentInfoText()
                .checkImgOnBlockDeliveryAndPayment();
    }
}
