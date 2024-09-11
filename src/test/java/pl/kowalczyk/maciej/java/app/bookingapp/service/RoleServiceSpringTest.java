package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.core.RoleType;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.role.RoleReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.RoleRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.RoleEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Role;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleServiceSpringTest {

    @Autowired
    private RoleService roleService;

    @Test
    void read() throws RoleReadException {
        // given

        // when
        Role readRole = roleService.read(1L);
        String roleName = readRole.getName().toString();

        // then
        Assertions.assertAll(
                () -> assertNotNull(readRole, "Role is NULL"),
                () -> assertEquals("ADMIN", roleName, "Role name is not equal ADMIN")
        );
    }
}