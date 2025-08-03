package tests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import pages.MainPage;
import org.junit.jupiter.api.Test;

public class CheckBlockOnMainPageTest extends BaseTest {

    MainPage mainPage = new MainPage();
    @Test
    void headersTest() {
        mainPage.openPage()
                .clickHeaderFamilyTree();
    }

}
