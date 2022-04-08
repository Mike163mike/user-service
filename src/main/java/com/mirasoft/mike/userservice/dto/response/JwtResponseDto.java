package com.mirasoft.mike.userservice.dto.response;

import lombok.*;

import java.util.List;

@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponseDto {

    private String token;
    private String type = "Bearer";
    private Long id;
    private String surname;
    private String name;
    private String email;
    private List<String> roles;

    public JwtResponseDto(String token, Long id, String surname, String name, String email, List<String> roles) {
        this.token = token;
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }

    public Long getId() {
        return id;
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

    public List<String> getRoles() {
        return roles;
    }
}
