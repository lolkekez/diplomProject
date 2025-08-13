package tests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;

import config.TestDataConfig;
import config.WebDriverProvider;

import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import pages.CatalogPage;
import pages.MainPage;
import pages.components.modal.CityModalComponent;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    CatalogPage catalogPage = new CatalogPage();
    MainPage mainPage = new MainPage();
    CityModalComponent cityModalComponent = new CityModalComponent();

    static TestDataConfig testDataConfig = ConfigFactory.create(TestDataConfig.class, System.getProperties());
    static WebDriverProvider webDriverProvider = new WebDriverProvider();

    protected static final String getLoginAuth = testDataConfig.getLogin();
    protected static final String getPassAuth = testDataConfig.getPassword();

    @BeforeAll
    static void beforeAll() {
        webDriverProvider.setUp();
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    void prepareData() {
        mainPage.openMainPage()
                .approveCookieButtonClick();
        cityModalComponent.modalLocationButtonOtherClick()
                .selectCityButtonClick();
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        executeJavaScript("window.localStorage.clear(); window.sessionStorage.clear();");
        closeWebDriver();
    }
}
/*
    @BeforeAll
    static void beforeAll(){
        config = ConfigFactory.create(WebConfig.class, System.getProperties());
        WebDriverProvider webConfig = new WebDriverProvider(config);
        webConfig.setUp();
    }
    @AfterEach
    void tearDown() {

        closeWebDriver();
    }

 */
