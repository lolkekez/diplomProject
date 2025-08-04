package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.Keys;
import pages.MainPage;
import pages.components.VerifyAuthorizationResult;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationTest extends BaseTest {

    MainPage mainPage = new MainPage();
    VerifyAuthorizationResult verifyAuthorizationResult = new VerifyAuthorizationResult();

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
