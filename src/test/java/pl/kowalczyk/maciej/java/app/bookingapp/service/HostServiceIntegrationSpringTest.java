package pl.kowalczyk.maciej.java.app.bookingapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host.HostCreateException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host.HostDeleteException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host.HostReadException;
import pl.kowalczyk.maciej.java.app.bookingapp.api.exception.host.HostUpdateException;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Host;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HostServiceIntegrationSpringTest {

    public static final String KRZYSZTOF_HOST_NAME = "Krzysztof";
    public static final String HOST_MAIL = "testmail@test.pl";

    @Autowired
    private HostService hostService;

    @Test
    void givenHostEntityAndHostIdWhenReadThenHostFound() throws HostCreateException, HostReadException {
        // given
        Host host = new Host();
        host.setName(KRZYSZTOF_HOST_NAME);
        host.setEmail(HOST_MAIL);

        Host hostCreated = hostService.create(host);
        Long id = hostCreated.getId();

        // when
        Host readHost = hostService.read(id);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(readHost, "Host is NULL"),
                () -> Assertions.assertEquals(HOST_MAIL, readHost.getEmail(), "Emails are not equal")
        );
    }

    @Test
    void givenHostWhenUpdateThenHostUpdated() throws HostCreateException, HostUpdateException {
        // given
        Host host = new Host();
        host.setName(KRZYSZTOF_HOST_NAME);
        host.setEmail(HOST_MAIL);

        Host hostCreated = hostService.create(host);
        Long id = hostCreated.getId();

        String nameMarcin = "Marcin";
        String mailMarcin = "marcintest@mail.com";

        Host hostForUpdate =new Host();
        hostForUpdate.setId(id);
        hostForUpdate.setName(nameMarcin);
        hostForUpdate.setEmail(mailMarcin);

        // when
        Host updatedHost = hostService.update(hostForUpdate);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(updatedHost, "Host is NULL"),
                () -> Assertions.assertEquals(mailMarcin, updatedHost.getEmail(), "Mails are not equal")
        );

    }

    @Test
    void givenHostIdWhenDeleteThenHostDeleted() throws HostCreateException, HostDeleteException {
        // given
        Host host = new Host();
        host.setName("Daniel");
        host.setEmail("daniel@gmail.com");

        Host hostCreated = hostService.create(host);
        Long id = hostCreated.getId();

        // when
        hostService.delete(id);

        // then
        Assertions.assertThrows(HostReadException.class, () -> hostService.read(id));
    }
}