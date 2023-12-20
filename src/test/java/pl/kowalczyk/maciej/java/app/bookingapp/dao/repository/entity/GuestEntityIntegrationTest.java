package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

class GuestEntityIntegrationTest {

    private SessionFactory sessionFactory;

    @BeforeEach
    void setUp() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml")
                        .build();
        try {
            sessionFactory =
                    new MetadataSources(registry)
                            .buildMetadata()
                            .buildSessionFactory();
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we
            // had trouble building the SessionFactory so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @Test
    void givenGuestEntityAndReservation_whenRemoveReservation_thenGuestReservationIsNull() {
        // given
        GuestEntity guest = new GuestEntity();
        ReservationEntity reservation = new ReservationEntity();
        int setSize;

        // when
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        guest.addReservation(reservation);
        Set<ReservationEntity> reservations = guest.getReservations();
        guest.removeReservation(reservation);

        setSize = reservations.size();
        session.getTransaction().commit();

        // then
        Assertions.assertEquals(0, setSize, "Reservation was not removed");
    }
}
