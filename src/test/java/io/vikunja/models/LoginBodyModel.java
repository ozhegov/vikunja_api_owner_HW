package io.vikunja.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class LoginBodyModel {

    @JsonProperty("long_token")
    boolean longToken;
    String password;
    String username;

}
