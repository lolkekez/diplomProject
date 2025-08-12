package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import config.WebConfig;

import io.qameta.allure.selenide.AllureSelenide;

import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.confirm;

public class BaseTest {

    protected static final String getLoginAuth = System.getProperty("loginTest");
    protected static final String getPassAuth = System.getProperty("passTest");

    private static WebConfig config;

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://krosspark.ru/";
        Configuration.browserSize = "1920x1080";
        //Configuration.timeout = 100000000;
        Configuration.pageLoadStrategy = "eager";
        //Configuration.remote = "https://user1:1234@selenoid.autotest.cloud/wd/hub";
        SelenideLogger.addListener("allure", new AllureSelenide());
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