package com.mirasoft.mike.userservice.dto.request;

import com.mirasoft.mike.userservice.model.emum.Role;
import lombok.*;

@Setter
@EqualsAndHashCode
@ToString
public class UserAuthPostRequestDto {

    private String surname;
    private String name;
    private String email;
    private String password;
    private Role role;

    public UserAuthPostRequestDto(String surname, String name, String email, String password, Role role) {
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}
