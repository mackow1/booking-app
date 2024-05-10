package pl.kowalczyk.maciej.java.app.bookingapp.config.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.java.app.bookingapp.api.core.RoleType;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.UserRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.RoleEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.UserEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class BookingAppUserDetailService implements UserDetailsService {

    private static final Logger LOGGER = Logger.getLogger(BookingAppUserDetailService.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("loadUserByUsername(" + username + ")");

        UserEntity userEntity = userRepository.findByUsername(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

//        List<RoleType> listOfRoles = userEntity.getRoles().stream()
//                .map(role -> role.getName().toString())
//                .toList();
//
//        String[] roles = new String[listOfRoles.size()];
//        for (int i = 0; i < roles.length; i++) {
//            roles[i] = listOfRoles.get(i).toString();
//        }

        Set<RoleEntity> userEntityRoles = userEntity.getRoles();
        String[] roleNames = convertRolesToStringArray(userEntityRoles);

        UserDetails userDetails = User.withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles(roleNames)
                .build();

        LOGGER.info("loadUserByUsername(...) = " + userDetails);
        return userDetails;
    }

    String[] convertRolesToStringArray(Set<RoleEntity> userEntityRoles) {
        LOGGER.info("convertRolesToStringArray(" + userEntityRoles + ")");

        String[] roleNames = new String[userEntityRoles.size()];

        int index = 0;
        for (RoleEntity userEntityRole : userEntityRoles) {
            String roleName = userEntityRole.getName().name();
            roleNames[index] = roleName;
            index++;
        }

        LOGGER.info("convertRolesToStringArray(...) = " + Arrays.asList(roleNames));
        return roleNames;
    }
}
