package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://pamyat-naroda.ru/";
        Configuration.browserSize = "1920x1080";
        // Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "eager";
        //Configuration.remote = "https://user1:1234@selenoid.autotest.cloud/wd/hub";
    }

}