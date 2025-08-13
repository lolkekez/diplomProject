package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;

public class SimpleSelenideTest {
    @BeforeEach
    void setUp() {
        System.out.println(">>> BeforeEach thread: " + Thread.currentThread().getId());
        Configuration.baseUrl = "https://example.com";
        try {
            open("/"); // должен запустить браузер и привязать WebDriver
            System.out.println("open() ok. hasWebDriverStarted=" + WebDriverRunner.hasWebDriverStarted());
            System.out.println("WebDriver = " + WebDriverRunner.getWebDriver());
        } catch (Exception e) {
            System.out.println("open() threw:");
            e.printStackTrace();
            throw e;
        }
    }

    @Test
    void simpleTest() {
        System.out.println(">>> Test thread: " + Thread.currentThread().getId());
        System.out.println("title: " + title());
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}