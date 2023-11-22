package pl.kowalczyk.maciej.java.app.bookingapp.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kowalczyk.maciej.java.app.bookingapp.model.Host;


class HostDaoTest {

    @Test
    void create() {
        // given
        HostDao hostDao = new HostDao();
        Host host = new Host("", "", "");

        // when
        Host createdHost = hostDao.create(host);

        // then
        Assertions.assertNotNull(createdHost, "Host not created");
    }

    @Test
    void read() {
        // given
        HostDao hostDao = new HostDao();
        int id = 0;

        // when
        Host hostFound = hostDao.read(id);

        // then
        Assertions.assertNotNull(hostFound, "Host not found");
    }
}