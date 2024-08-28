package io.vikunja.config;


import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})
public interface WebConfig extends Config {

    @Key("browser")
    String browser();

    @Key("browserVersion")
    String browserVersion();

    @Key("browserSize")
    String browserSize();

    @Key("baseUrl")
    String baseUrl();

    @Key("baseUri")
    String baseUri();

    @Key("isRemote")
    boolean isRemote();

    @Key("remoteUrl")
    String remoteUrl();

}
