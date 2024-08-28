package io.vikunja.helpers;

import io.vikunja.api.LoginApi;
import io.vikunja.api.RegistrationApi;
import io.vikunja.models.LoginBodyModel;
import io.vikunja.models.LoginResponseModel;
import io.vikunja.utils.TestData;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.open;
import static io.vikunja.utils.TestData.regData;

public class LoginExtension implements BeforeEachCallback {


    @Override
    public void beforeEach(ExtensionContext extensionContext) {

        RegistrationApi.registration(regData);

        LoginBodyModel credentials = new LoginBodyModel(TestData.longToken, regData.getPassword(), regData.getUsername());
        LoginResponseModel loginResponse = LoginApi.login(credentials);

        open("/images/icons/android-chrome-192x192.png");
        localStorage().setItem("token", loginResponse.getToken());

    }

}
