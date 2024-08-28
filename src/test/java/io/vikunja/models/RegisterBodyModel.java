package io.vikunja.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RegisterBodyModel {

    String email;
    int id;
    String password;
    String username;

}
