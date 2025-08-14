package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebDriverProvider {
    static WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
    static AuthConfig authconfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    public void setUp() {
        Configuration.baseUrl = webConfig.getBaseUrl();
        Configuration.browser = webConfig.getBrowser();
        Configuration.browserSize = webConfig.getBrowserSize();
        Configuration.browserVersion = webConfig.getBrowserVersion();
        Configuration.pageLoadStrategy = "eager";
        String remoteUrl = "https://" + authconfig.login() + ":" + authconfig.password() + "@" + authconfig.remoteUrl() + "/wd/hub";

        if (webConfig.isRemote()) {
            Configuration.remote = remoteUrl;

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true

            ));
            Configuration.browserCapabilities = capabilities;
        }
    }
}
