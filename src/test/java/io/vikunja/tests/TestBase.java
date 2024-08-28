package io.vikunja.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.vikunja.config.ConfigReader;
import io.vikunja.config.ProjectConfiguration;
import io.vikunja.config.WebConfig;
import io.vikunja.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    private static final WebConfig config = ConfigReader.Instance.read();

    @BeforeAll
    static void setUp() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        ProjectConfiguration projectConfiguration = new ProjectConfiguration(config);
        projectConfiguration.webConfig();
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }


}
