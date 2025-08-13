package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${env}.properties"
})

public interface TestDataConfig extends Config {

        @Key("loginTest")
        @DefaultValue("4ybt2@somoj.com")
        String getLogin();

        @Key("passwordTest")
        @DefaultValue("Warcraft_Goblin331")
        String getPassword();
}
