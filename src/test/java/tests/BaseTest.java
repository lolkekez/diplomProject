package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.MainPage;
import pages.components.AuthorizationModalComponent;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    MainPage mainPage = new MainPage();
    AuthorizationModalComponent authorizationModalComponent = new AuthorizationModalComponent();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://krosspark.ru/";
        Configuration.browserSize = "1920x1080";
        //Configuration.timeout = 100000000;
        Configuration.pageLoadStrategy = "eager";
        //Configuration.remote = "https://user1:1234@selenoid.autotest.cloud/wd/hub";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void tearDown() {

        closeWebDriver();
    }
}