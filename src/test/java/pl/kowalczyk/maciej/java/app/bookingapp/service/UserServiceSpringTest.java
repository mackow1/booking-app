package pl.kowalczyk.maciej.java.app.bookingapp.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.core.RoleType;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.role.RoleReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.RoleRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.RoleEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Role;
import pl.kowalczyk.maciej.java.app.bookingapp.model.User;
import pl.kowalczyk.maciej.java.app.bookingapp.service.mapper.RoleMapper;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceSpringTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void createUserWithRole() throws RoleReadException {
        // given
        User user = new User();
        Role role = new Role();
        role.setName(RoleType.ADMIN);

        user.setUsername("UsernameWithRoleAdmin");
        user.getRoles().add(role);

        // when
        User userCreated = userService.create(user);

        // then
        Assertions.assertAll(
                () -> assertNotNull(userCreated, "New user is NULL"),
                () -> assertEquals(1, userCreated.getRoles().size(), "Role was not added to set")
        );
    }

    @Test
    @Transactional
    void createUserWithNewRole() throws RoleReadException {
        // given
        RoleEntity role = new RoleEntity();
        role.setName(RoleType.SERVICE);
        RoleEntity savedRoleEntity = roleRepository.save(role);
        Long roleEntityId = savedRoleEntity.getId();

        User user = new User();
        user.setUsername("Maciej Kowalczyk");
        user.setRoleId(roleEntityId);

        // when
        User savedUser = userService.create(user);

        // then
        Assertions.assertAll(
                () -> assertNotNull(savedUser, "User is NULL"),
                () -> assertEquals(1, savedUser.getRoles().size(), "User has no roles")
        );

    }
}

/*
SELECT *
FROM USERS AS U
LEFT JOIN USERS_ROLES AS UR
ON U.ID = UR.USER_ENTITY_ID
LEFT JOIN ROLES AS R
ON UR.ROLES_ID = R.ID
 */