package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.UserRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.UserEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.User;
import pl.kowalczyk.maciej.java.app.bookingapp.service.mapper.UserMapper;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
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

    public User create(User user) {
        LOGGER.info("create(" + user + ")");

// TODO: 06.09.2024 na podstawioe roleId z user pobrać role z bazy i wstawić do user przed użyciem mappera
        UserEntity userEntity = userMapper.from(user);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        User userSaved = userMapper.from(savedUserEntity);

        LOGGER.info("create(...) = " + userSaved);
        return userSaved;
    }
}
