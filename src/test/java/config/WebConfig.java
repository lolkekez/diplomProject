package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface WebConfig extends Config{
    @Key("baseUrl")
    @DefaultValue("https://krosspark.ru")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("browserVersion")
    @DefaultValue("139.0")
    String getBrowserVersion();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();
}
