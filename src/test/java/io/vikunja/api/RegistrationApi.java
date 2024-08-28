package io.vikunja.api;

import io.vikunja.models.RegisterBodyModel;
import io.vikunja.models.RegisterResponseModel;

import static io.restassured.RestAssured.given;
import static io.vikunja.specs.RegSpec.regRequestSpec;
import static io.vikunja.specs.RegSpec.regResponseSpec;

public class RegistrationApi {

    public static RegisterResponseModel registration(RegisterBodyModel regData) {

        return given(regRequestSpec)
                .body(regData)
                .when()
                .post("/register")
                .then()
                .spec(regResponseSpec)
                .extract().as(RegisterResponseModel.class);
    }

}
