package com.mirasoft.mike.userservice;

import com.mirasoft.mike.userservice.model.emum.Role;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserServiceApplicationTests {

    @Test
    void testValidateRole() {
    String testUser = "USER";
    String testADMIN = "ADMIN";
    assertEquals(Role.USER.name(), testUser, "Метод \"validateRole()\" не прошёл тестирование.");
    assertEquals(Role.ADMIN.name(), testADMIN, "Метод \"validateRole()\" не прошёл тестирование.");
    }
}
