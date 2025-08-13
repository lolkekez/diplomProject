package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:auth.properties"
})

public interface AuthConfig extends Config {

    @Key("remoteLogin")
    @DefaultValue("user1")
    String login();

    @Key("remotePass")
    @DefaultValue("1234")
    String password();

    @Key("remoteUrl")
    String remoteUrl();
}
