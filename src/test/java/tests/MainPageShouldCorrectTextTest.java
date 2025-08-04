package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.MainPage;
import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageShouldCorrectTextTest extends BaseTest {
    @Test
    void mainPageShouldCorrectHeadersTextTest() {
        open("");
        $("li.prim-nav__item_0").shouldHave(text("Участники войны"));
    }
    MainPage mainPage = new MainPage();
/*
    @Test
    void mainPageShouldCorrectDisplayTextTestWithoutEnum() {
        mainPage.openPage();
        $("h1").shouldHave(text("Найдите свою семью.\n" +
                "Узнайте что-то о самом себе."));
        $("p.textBaseCss_tt5gnaq").shouldHave(text("Оживите историю своей семьи, изучая жизнь своих предшественников."));
    }

    @Test
    void mainPageShouldCorrectHeadersTextTest() {
        mainPage.openPage();
        $("[data-test-id='hdr_tree']").shouldHave(text("Семейное древо"));
    }

    @Test
    void mainPageShouldSwitchLangTest() {
        mainPage.openPage();
        $("[aria-label='Выбрать язык']").click();
        $("[lang='en']").click();
        $("[data-testid='languagePickerApply']").click();
        $("h1").shouldHave(text("Find your family.\n" + "Discover yourself."));
    }
*/
}
