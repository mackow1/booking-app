package pl.kowalczyk.maciej.java.app.bookingapp.config.web;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class BookingAppUserDetailService implements UserDetailsService {

    private static final Logger LOGGER = Logger.getLogger(BookingAppUserDetailService.class.getName());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("loadUserByUsername(" + username + ")");
        return null;
    }
}
