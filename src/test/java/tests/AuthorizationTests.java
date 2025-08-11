package tests;

import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.components.AuthorizationModalComponent;
import pages.components.CityModalComponent;

public class AuthorizationTests extends BaseTest {


    MainPage mainPage = new MainPage();
    AuthorizationModalComponent authorizationModalComponent = new AuthorizationModalComponent();
    CityModalComponent cityModalComponent = new CityModalComponent();

    @BeforeEach
    void prepareData() {

        mainPage.openMainPage()
                .approveCookieButtonClick();
        cityModalComponent.modalLocationButtonOtherClick()
                .selectCityButtonClick();
    }

    //4ybt2@somoj.com:Warcraft_Goblin331
    @Tag("Auth")
    @Test
    @DisplayName("Успешная авторизация")
    void accessAuthorizationTest() {

        mainPage.profileIconButtonClick();

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

        mainPage.profileIconButtonClick();

        authorizationModalComponent.setFailedInputProfileEmail()
                .setFailedInputProfilePassword()
                .loginConfirmButtonClick()
                .checkFailedAuthorizationMessageVisible();
    }


    //TO DO:: не работает автотест так как в методе setUncorrectedInputProfilePassword зачистка поля работает с помозью хоткея под винду
    @Tag("Auth")
    @Test
    @DisplayName("поля email и password валидируются на введенные данные")
    void validationEmailAndPasswordFieldsOnRegistrationModalTest() {

        mainPage.profileIconButtonClick();

        authorizationModalComponent.setUncorrectedInputProfileEmail();

        authorizationModalComponent.checkLoginConfirmButtonDisabled();

        authorizationModalComponent.setUncorrectedInputProfilePassword()
                .checkEmailFieldShouldBeUncorrectedText()
                .checkPasswordFieldShouldBeUncorrectedText();
    }

}