package pl.kowalczyk.maciej.java.app.bookingapp.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity.HostEntity;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Host;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HostMapperSpringTest {

    public static final String MACIEJ_HOST_NAME = "Maciej";
    public static final String HOST_EMAIL = "maciej.k@gmail.com";

    @Autowired
    private HostMapper hostMapper;

    @Test
    void givenHostWhenFromThenHostEntityCreated() {
        // given
        Host host = new Host();
        host.setName(MACIEJ_HOST_NAME);
        host.setEmail(HOST_EMAIL);

        // when
        HostEntity hostEntity = hostMapper.from(host);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(hostEntity, "Entity is NULL"),
                () -> Assertions.assertEquals(HOST_EMAIL, hostEntity.getEmail(), "Emails are not equal")
        );

    }

    @Test
    void givenHostEntityWhenFromThenHostCreated() {
        // given
        HostEntity hostEntity = new HostEntity();
        hostEntity.setName(MACIEJ_HOST_NAME);
        hostEntity.setEmail(HOST_EMAIL);

        // when
        Host host = hostMapper.from(hostEntity);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(host, "Model is NULL"),
                () -> Assertions.assertEquals(MACIEJ_HOST_NAME, host.getName(), "Names are not equal")
        );
    }
}