package tests;

import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.components.AuthorizationModalComponent;
import pages.components.CityModalComponent;

public class AuthorizationTest extends BaseTest {

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
    @Tag("BLOCKER")
    @Test
    void accessAuthorizationTest() {

        mainPage.profileIconButtonClick();

        authorizationModalComponent.setInputProfileModalEmail("4ybt2@somoj.com")
                .setInputProfileModalPassword("Warcraft_Goblin331")
                .loginConfirmButtonClick();

        mainPage.checkFavouritesHeaderIconVisible()
                .checkRedirectionProfilePageAfterAuthorization();
}


    @Test
    void failedAuthorizationTest() {

        mainPage.profileIconButtonClick();

        authorizationModalComponent.setFailedInputProfileEmail()
                .setFailedInputProfilePassword()
                .loginConfirmButtonClick()
                .checkFailedAuthorizationMessageVisible();
    }

    /*
    TO DO:: не работает автотест так как в методе setUncorrectedInputProfilePassword зачистка поля работает с помозью хоткея под винду
    @Test
    void validationEmailAndPasswordFieldsOnRegistrationModalTest() {

        mainPage.profileIconButtonClick();

        authorizationModalComponent.setUncorrectedInputProfileEmail();

        mainPage.checkLoginConfirmButtonDisabled();

        authorizationModalComponent.setUncorrectedInputProfilePassword()
                .checkEmailFieldShouldBeUncorrectedText()
                .checkPasswordFieldShouldBeUncorrectedText();
    }
     */
}