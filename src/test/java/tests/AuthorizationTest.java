package tests;

import org.junit.jupiter.api.*;
import pages.MainPage;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationTest extends BaseTest {

    MainPage mainPage = new MainPage();

    @BeforeEach
    void prepareData() {

        mainPage.openMainPage()
                .approveCookieButtonClick()
                .modalLocationButtonOtherClick()
                .selectCityButtonClick();
    }

    //4ybt2@somoj.com:Warcraft_Goblin331
    @Tag("BLOCKER")
    @Test
    void accessAuthorizationTest() {

        mainPage.profileIconButtonClick()
                .setInputProfileEmail("4ybt2@somoj.com")
                .setInputProfilePassword("Warcraft_Goblin331")
                .loginConfirmButtonClick()
                .checkFavouritesHeaderIconVisible()
                .checkRedirectionProfilePageAfterAuthorization();
    }

    @Test
    void failedAuthorizationTest() {

        mainPage.profileIconButtonClick()
                .setFailedInputProfileEmail()
                .setFailedInputProfilePassword()
                .loginConfirmButtonClick()
                .checkFailedAuthorizationMessageVisible();
    }

    @Test
    void validationEmailAndPasswordFieldsOnRegistrationModalTest() {

        mainPage.profileIconButtonClick()
                .setUncorrectedInputProfileEmail()
                .checkLoginConfirmButtonDisabled()
                .setUncorrectedInputProfilePassword()
                .checkEmailFieldShouldBeUncorrectedText()
                .checkPasswordFieldShouldBeUncorrectedText();
    }
}