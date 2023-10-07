package com.pinyaskin.social.requests;

import lombok.Data;

@Data
public class AddUserRequest {
    private String username;
    private String password;
}
