package com.mirasoft.mike.userservice.dto.request;

import lombok.*;

@Setter
@EqualsAndHashCode
@ToString
public class UserGetRequestDto {

    private String email;

    public UserGetRequestDto(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}


