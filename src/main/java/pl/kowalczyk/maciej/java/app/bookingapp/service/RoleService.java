package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.role.RoleReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.RoleRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.RoleEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Role;
import pl.kowalczyk.maciej.java.app.bookingapp.service.mapper.RoleMapper;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class RoleService {

    private static final Logger LOGGER = Logger.getLogger(RoleService.class.getName());

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    public List<Role> list() {
        LOGGER.info("list()");

        List<RoleEntity> roleEntities = roleRepository.findAll();
        List<Role> roles = roleMapper.fromEntities(roleEntities);

        LOGGER.info("list(...) = " + roles);
        return roles;
    }

    public Role read(Long id) throws RoleReadException {
        LOGGER.info("read(" + id + ")");

        Optional<RoleEntity> optionalRoleEntity = roleRepository.findById(id);
        RoleEntity roleEntity = optionalRoleEntity.orElseThrow(() -> {
            LOGGER.log(Level.SEVERE, "Role not found for given id: " + id);
            return new RoleReadException("Role not found for given id: " + id);
        });

        Role role = roleMapper.from(roleEntity);

        LOGGER.info("read(...) = " + role);
        return role;
    }
}
