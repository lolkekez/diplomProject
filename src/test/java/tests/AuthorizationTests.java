package tests;

import org.junit.jupiter.api.*;

import pages.MainPage;
import pages.components.modal.AuthorizationModalComponent;
import pages.components.modal.CityModalComponent;

public class AuthorizationTests extends BaseTest {

    MainPage mainPage = new MainPage();
    AuthorizationModalComponent authorizationModalComponent = new AuthorizationModalComponent();

    @Tag("Auth")
    @Test
    @DisplayName("Успешная авторизация")
    void successfulAuthorizationTest() {
        mainPage.openMainPage()
                .profileIconButtonClick();
        authorizationModalComponent.setInputProfileModalEmail(getLoginAuth)
                .setInputProfileModalPassword(getPassAuth)
                .loginConfirmButtonClick();
        mainPage.checkFavouritesHeaderIconVisible()
                .checkRedirectionProfilePageAfterAuthorization();
}

    @Tag("Auth")
    @Test
    @DisplayName("Не успешная авторизация")
    void failedAuthorizationTest() {
        mainPage.openMainPage()
                .profileIconButtonClick();
        authorizationModalComponent.setFailedInputProfileEmail()
                .setFailedInputProfilePassword()
                .loginConfirmButtonClick()
                .checkFailedAuthorizationMessageVisible();
    }

    @Tag("Auth")
    @Test
    @DisplayName("поля email и password валидируются на введенные данные")
    void validationEmailAndPasswordFieldsOnRegistrationModalTest() {
        mainPage.openMainPage()
                .profileIconButtonClick();
        authorizationModalComponent.setUncorrectedInputProfileEmail();
        authorizationModalComponent.checkLoginConfirmButtonDisabled();
        authorizationModalComponent.setUncorrectedInputProfilePassword()
                .checkEmailFieldShouldHaveUncorrectedText()
                .checkPasswordFieldShouldHaveUncorrectedText();
    }
}
