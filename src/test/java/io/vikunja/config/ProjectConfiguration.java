package io.vikunja.config;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class ProjectConfiguration {

    private final WebConfig config;

    public ProjectConfiguration(WebConfig config) {
        this.config = config;
    }

    public void webConfig() {
        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = config.browser();
        RestAssured.baseURI = config.baseUri();
        Configuration.browserVersion = config.browserVersion();
        Configuration.browserSize = config.browserSize();
        if (config.isRemote()) {
            Configuration.remote = config.remoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }
}
