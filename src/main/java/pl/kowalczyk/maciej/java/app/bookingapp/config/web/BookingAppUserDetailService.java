package pl.kowalczyk.maciej.java.app.bookingapp.config.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.UserRepository;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.UserEntity;

import java.util.logging.Logger;

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

        UserDetails userDetails = User.withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles("USER")
                .build();

        LOGGER.info("loadUserByUsername(...) = " + userDetails);
        return userDetails;
    }
}
