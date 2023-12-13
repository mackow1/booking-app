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

class HostEntityTest {

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
    void createHostWithAddress() {
        // given
        HostEntity hostRead = new HostEntity();
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCountry("Poland");
        addressEntity.setCity("Poznan");

        HostEntity hostCreated = new HostEntity();
        hostCreated.setName("Marcin");
        hostCreated.setEmail("fsda@gd.com");
        hostCreated.setAddress(addressEntity);

        // when
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(addressEntity);
            Long savedId = (Long) session.save(hostCreated);

            hostRead = session.get(HostEntity.class, savedId);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        // then
        Assertions.assertNotNull(hostRead, "Host was not created");
    }

}