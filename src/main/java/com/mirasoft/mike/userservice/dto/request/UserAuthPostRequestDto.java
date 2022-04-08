package com.mirasoft.mike.userservice.dto.request;

import com.mirasoft.mike.userservice.model.emum.Role;
import lombok.*;

@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthPostRequestDto {

    private String surname;
    private String name;
    private String email;
    private String password;
    private Role role;

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
