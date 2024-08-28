package io.vikunja.models;

import lombok.Data;

@Data
public class RegisterResponseModel {

    int id;
    String name;
    String username;
    String email;
    String created;
    String updated;

}
