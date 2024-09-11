package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.core.RoleType;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.RoleEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.UserEntity;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositorySpringTest {

    public static final String TEST_USERNAME = "TestUsername";
    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUsername() {
        // given
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("TestUser");

        // when
        userRepository.save(userEntity);
        UserEntity foundUserEntity = userRepository.findByUsername("TestUser");

        // then
        Assertions.assertAll(
                () -> assertNotNull(foundUserEntity),
                () -> assertEquals("TestUser", foundUserEntity.getUsername())
        );
    }

    @Test
    void createNewUserWithID() {
        // given
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(TEST_USERNAME);

        // when
        UserEntity savedUserEntity = userRepository.save(userEntity);
        Long savedUserEntityId = savedUserEntity.getId();

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedUserEntity),
                () -> Assertions.assertNotNull(savedUserEntityId)
        );
    }

    @Test
    void createUserWithRoles() {
        // given
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("TestUserWithRoles");

        RoleEntity roleEntityAdmin = new RoleEntity();
        roleEntityAdmin.setName(RoleType.ADMIN);
        RoleEntity roleEntityHost = new RoleEntity();
        roleEntityHost.setName(RoleType.HOST);
        Set<RoleEntity> roles = new HashSet<>();

        roles.add(roleEntityAdmin);
        roles.add(roleEntityHost);

        userEntity.setRoles(roles);

        // when
        UserEntity savedUserEntity = userRepository.save(userEntity);
        Set<RoleEntity> userEntityRoles = savedUserEntity.getRoles();
        // then
        Assertions.assertAll(
                () -> assertNotNull(savedUserEntity),
                () -> assertEquals(2, userEntityRoles.size(), "Roles not added")
        );
    }

}