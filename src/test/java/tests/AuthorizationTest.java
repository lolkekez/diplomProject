package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.MainPage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationTest extends BaseTest {

    MainPage mainPage = new MainPage();

    //4ybt2@somoj.com:Warcraft_Goblin331
    @Tag("BLOCKER")
    @Test
    void accessAuthorizationTest() {
        open("");
        mainPage.approveCookieButtonClick()
                .modalLocationButtonOtherClick()
                .selectCityButtonClick()
                .profileIconButtonClick()
                .inputProfileEmailSet("4ybt2@somoj.com")
                .inputProfilePasswordSet("Warcraft_Goblin331");
        $("div.header__icons").$("svg.iconify--carbon").

    }

    @Test
    void failedAuthorizationTest() {
        open("");
        mainPage.approveCookieButtonClick()
                .modalLocationButtonOtherClick()
                .selectCityButtonClick()
                .profileIconButtonClick()
                .inputProfilePasswordSet("")
                .inputProfilePasswordSet("")
                .selectCityButtonClick();
    }
}
