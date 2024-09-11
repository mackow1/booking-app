package pl.kowalczyk.maciej.java.app.bookingapp.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.RoleEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Role;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class RoleMapper {

    private static final Logger LOGGER = Logger.getLogger(RoleMapper.class.getName());

    public Role from(RoleEntity roleEntity) {
        LOGGER.info("from(" + roleEntity + ")");

        ModelMapper modelMapper = new ModelMapper();
        Role role = modelMapper.map(roleEntity, Role.class);

        LOGGER.info("from(...) = " + role);
        return role;
    }

    public RoleEntity from(Role role) {
        LOGGER.info("from(" + role + ")");

        ModelMapper modelMapper = new ModelMapper();
        RoleEntity roleEntity = modelMapper.map(role, RoleEntity.class);

        LOGGER.info("from(...) = " + roleEntity);
        return roleEntity;
    }

    public List<Role> fromEntities(List<RoleEntity> roleEntities) {
        LOGGER.info("fromEntities(" + roleEntities + ")");

        List<Role> roles = roleEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());

        LOGGER.info("fromEntities(...) = " + roles);
        return roles;
    }
}
