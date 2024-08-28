package io.vikunja.api;

import io.vikunja.models.LoginBodyModel;
import io.vikunja.models.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static io.vikunja.specs.LoginSpec.loginRequestSpec;
import static io.vikunja.specs.LoginSpec.loginResponseSpec;

public class LoginApi {

    public static LoginResponseModel login(LoginBodyModel credentials) {

        return given(loginRequestSpec)
                .body(credentials)
                .when()
                .post("/login")
                .then()
                .spec(loginResponseSpec)
                .extract().as(LoginResponseModel.class);

    }
}
