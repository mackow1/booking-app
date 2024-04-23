package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RentalEntityTest {

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
    void createRentalWithGuestAndReservation() {
        // given
        RentalEntity rentalRead = null;

        ReservationEntity reservation = new ReservationEntity();
        reservation.setNumberOfPersons(3);
        reservation.setCheckIn("11.11.2023");
        reservation.setCheckOut("15.11.2023");

        GuestEntity guest = new GuestEntity();
        guest.setName("John");
        guest.setPhoneNumber("34235234");
        guest.setEmail("dasda@gsg.com");

        RentalEntity rental = new RentalEntity();
        rental.setReservation(reservation);
//        rental.setGuest(guest);

        // when
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(reservation);
            session.save(guest);
            Long savedId = (Long) session.save(rental);
            rentalRead = session.get(RentalEntity.class, savedId);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        // then

        Assertions.assertNotNull(rentalRead, "Rental was not created");
    }
}
