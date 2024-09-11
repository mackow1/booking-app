package pl.kowalczyk.maciej.java.app.bookingapp.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.java.app.bookingapp.api.core.RoleType;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.RoleEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Role;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoleMapperTest {

    @Test
    void fromEntityToModel() {
        // given
        RoleMapper roleMapper = new RoleMapper();
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(RoleType.SERVICE);

        // when
        Role role = roleMapper.from(roleEntity);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(role, "Model is NULL"),
                () -> Assertions.assertEquals(RoleType.SERVICE, role.getName(), "Names are not equal")
        );
    }

    @Test
    void fromModelToEntity() {
        // given
        RoleMapper roleMapper = new RoleMapper();
        Role role = new Role();
        role.setName(RoleType.SERVICE);

        // when
        RoleEntity roleEntity = roleMapper.from(role);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(roleEntity, "Entity is NULL"),
                () -> Assertions.assertEquals(RoleType.SERVICE, roleEntity.getName(), "Names are not equal")
        );
    }

    @Test
    void fromEntities() {
        // given
        RoleMapper roleMapper = new RoleMapper();

        List<RoleEntity> roleEntities = new ArrayList<>();
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(RoleType.SERVICE);

        RoleEntity secondRoleEntity = new RoleEntity();
        secondRoleEntity.setName(RoleType.HOST);

        roleEntities.add(roleEntity);
        roleEntities.add(secondRoleEntity);

        // when
        List<Role> roles = roleMapper.fromEntities(roleEntities);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(roles, "List is NULL"),
                () -> Assertions.assertEquals(2, roles.size(), "List sizes are not equal")
        );
    }
}