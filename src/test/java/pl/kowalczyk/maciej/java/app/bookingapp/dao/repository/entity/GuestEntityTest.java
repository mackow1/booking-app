package pl.kowalczyk.maciej.java.app.bookingapp.dao.repository.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GuestEntityTest {

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
    void createWithAddress() {
        // given
        GuestEntity guestEntity = new GuestEntity();
        guestEntity.setName("Maciek");
        guestEntity.setPhoneNumber("894375639");

        AddressEntity guestAddress = new AddressEntity();
        guestAddress.setCity("Kraków");
        guestAddress.setCountry("Polska");

        guestEntity.setAddress(guestAddress);

        // when
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(guestAddress);
        session.save(guestEntity);
        session.getTransaction().commit();

//        session.getTransaction().begin();
//        session.getTransaction().commit();

        // then

    }
}