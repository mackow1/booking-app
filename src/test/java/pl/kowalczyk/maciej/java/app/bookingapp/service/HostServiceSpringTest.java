package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host.HostCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host.HostReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host.HostUpdateException;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Host;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HostServiceSpringTest {

    public static final String HOST_PIOTR_NAME = "Piotr";
    public static final String HOST_PIOTR_NUMBER = "678456890";

    @Autowired
    private HostService hostService;

    @Test
    void givenHostWhenCreateThenHostEntityIsCreated() throws HostCreateException {
        // given
        Host host = new Host();
        host.setName(HOST_PIOTR_NAME);
        host.setPhoneNumber(HOST_PIOTR_NUMBER);

        // when
        Host hostCreated = hostService.create(host);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(hostCreated, "Model is NULL"),
                () -> Assertions.assertEquals(HOST_PIOTR_NUMBER, hostCreated.getPhoneNumber(), "Numbers are not equal")
        );
    }

    @Test
    void givenNonExistingIdWhenReadThenExceptionThrown() {
        // given
        Long id = -1L;
        // when
        // then
        Assertions.assertThrows(HostReadException.class, () -> hostService.read(id));
    }

    @Test
    void givenNullWhenUpdateThenExceptionThrown() {
        // given
        // when
        // then
        Assertions.assertThrows(HostUpdateException.class, () -> hostService.update(null));
    }

    @Test
    void delete() {
        // given

        // when

        // then

    }
}