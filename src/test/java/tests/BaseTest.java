package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import config.AuthConfig;
import config.TestDataConfig;
import config.WebConfig;

import config.WebDriverProvider;
import io.qameta.allure.selenide.AllureSelenide;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.confirm;

public class BaseTest {

//    protected static final String getLoginAuth = System.getProperty("loginTest");
//    protected static final String getPassAuth = System.getProperty("passwordTest");

    static TestDataConfig testDataConfig = ConfigFactory.create(TestDataConfig.class, System.getProperties());
    static WebDriverProvider webDriverProvider = new WebDriverProvider();
    private static WebConfig config;

    protected static final String getLoginAuth = testDataConfig.getLogin();
    protected static final String getPassAuth = testDataConfig.getPassword();

    @BeforeAll
    static void beforeAll() {
        webDriverProvider.setUp();
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
}