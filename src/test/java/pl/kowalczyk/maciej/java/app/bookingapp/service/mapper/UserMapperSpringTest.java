package pl.kowalczyk.maciej.java.app.bookingapp.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.core.RoleType;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.RoleEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.UserEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Role;
import pl.kowalczyk.maciej.java.app.bookingapp.model.User;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperSpringTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void from() {
        // given
        User user = new User();
        user.setUsername("UsernameWithRoles");
        Role adminRole = new Role();
        adminRole.setName(RoleType.ADMIN);
        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);

        user.setRoles(roles);

        // when
        UserEntity userEntity = userMapper.from(user);
        Set<RoleEntity> userEntityRoles = userEntity.getRoles();

        // then
        Assertions.assertAll(
                () -> assertNotNull(userEntity),
                () -> assertEquals(1, userEntityRoles.size())
        );
    }
}