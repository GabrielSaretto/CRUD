package com.example.CRUD.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse {

    private final String message;
    private final String username;

    public AuthenticationResponse(String message, String username) {
        this.message = message;
        this.username = username;
    }

}
