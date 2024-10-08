package pl.kowalczyk.maciej.java.app.bookingapp.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.UserEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.User;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private static final Logger LOGGER = Logger.getLogger(UserMapper.class.getName());

    public User from(UserEntity userEntity) {
        LOGGER.info("from(" + userEntity + ")");

        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userEntity, User.class);

        LOGGER.info("from(...) = " + user);
        return user;
    }

    public UserEntity from(User user) {
        LOGGER.info("from(" + user + ")");

        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);

        LOGGER.info("from(...) = " + userEntity);
        return userEntity;
    }

    public List<User> fromEntities(List<UserEntity> userEntities) {
        LOGGER.info("fromEntities(" + userEntities + ")");

        List<User> users = userEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());

        LOGGER.info("fromEntities(...) = " + users);
        return users;
    }
}
