package com.mirasoft.mike.userservice.model;

import com.mirasoft.mike.userservice.model.emum.Role;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Setter
@ToString
@AllArgsConstructor
@Table(name = "usr", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String surname;
    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
    }

    public User(String surname, String name, String email, String password, Role role) {
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(surname, user.surname)
                && Objects.equals(name, user.name) && Objects.equals(email, user.email)
                && Objects.equals(password, user.password) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, email, password, role);
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

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}
