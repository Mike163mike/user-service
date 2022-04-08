package com.mirasoft.mike.userservice.dto.response;

import lombok.*;

import java.time.LocalDateTime;


@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private Long id;
    private String surname;
    private String name;
    private String email;
    private String local;
    private LocalDateTime lastVisit;

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

    public String getLocal() {
        return local;
    }

    public LocalDateTime getLastVisit() {
        return lastVisit;
    }
}
