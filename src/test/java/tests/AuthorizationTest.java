package tests;

import data.Language;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.MainPage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationTest extends BaseTest {

    MainPage mainPage = new MainPage();


    //4ybt2@somoj.com:Warcraft_Goblin331
    @Test
    void accessAuthorizationTest() {
        open("");
        $("div.modal button").click();
        $("div.location__button-yes").click();
        $$("div.city__city-item").find(text("Москва")).click();
        $("div.header__icons").$("span.header__profile-icon").click();
        $("input.el-input__inner").find("placeholder='Ваш e-mail'").click();
    }
}
