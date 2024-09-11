package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.role.RoleReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.RoleRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.UserRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.RoleEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.UserEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.User;
import pl.kowalczyk.maciej.java.app.bookingapp.service.mapper.UserMapper;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(RoleService roleService, RoleRepository roleRepository, UserRepository userRepository, UserMapper userMapper) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<User> list() {
        LOGGER.info("list()");

        List<UserEntity> userEntities = userRepository.findAll();
        List<User> users = userMapper.fromEntities(userEntities);

        LOGGER.info("list(...) = " + users);
        return users;
    }

    public User create(User user) throws RoleReadException {
        LOGGER.info("create(" + user + ")");

        Long roleId = user.getRoleId();
        UserEntity userEntity = userMapper.from(user);

        if (roleId != null) {
            Optional<RoleEntity> optionalRoleEntity = roleRepository.findById(roleId);
            RoleEntity roleEntity = optionalRoleEntity.orElseThrow(() -> {
                LOGGER.log(Level.SEVERE, "No role found for id: " + roleId);
                return new RoleReadException("Role not found for given id: " + roleId);
            });

            userEntity.getRoles().add(roleEntity);
        }

        UserEntity savedUserEntity = userRepository.save(userEntity);
        User userSaved = userMapper.from(savedUserEntity);

        LOGGER.info("create(...) = " + userSaved);
        return userSaved;
    }
}
